package components;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
  Airport airport = new Airport();
  Plane plane = new Plane("test Plane");

  @Test
  void landPlane() {
    airport.landPlane(plane);
    assertEquals(false, plane.flying);
    assertEquals(true, airport.hangar.contains(plane));
  }

  @Test
  @DisplayName("Planes cant land when airport is full")
  void landPlaneWhenApFull() {
    for (int i = 0; i < airport.capacity; i++) {
      airport.landPlane(plane);
    }
    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          airport.landPlane(plane);
        });
    assertEquals("airport is full", exceptionThatWasThrown.getMessage());
  }

  @Test
  @DisplayName("Airport capacity can be overwritten")
  void airportCapCanBeChanged() {
    int newCapacity = 5;
    airport.capacity = newCapacity;
    for (int i = 0; i < airport.capacity; i++) {
      airport.landPlane(plane);
    }
    assertEquals(newCapacity, airport.hangar.size());
  }


  @Test
  @DisplayName("prevent Plane To take off in stormy weather")
  void preventTakeOffInStormyWeather() {
    airport.landPlane(plane);
    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          airport.takeOffPlane(plane);
        });
    assertEquals("Bad weather, airport is closed",
        exceptionThatWasThrown.getMessage());
  }

  @Test
  void takeOffPlane() {
    airport.landPlane(plane);
    airport.takeOffPlane(plane);
    assertTrue(plane.flying);
    assertFalse(airport.hangar.contains(plane));
  }

  @Test
  void showAllPlanesName() {
    airport.landPlane(plane);
    airport.landPlane(new Plane("test Plane 2"));
    List<String> expectedList = new ArrayList<>();
    expectedList.add("test Plane");
    expectedList.add("test Plane 2");
    assertEquals(expectedList.toString(), airport.showAllPlanesName());
  }

  @Test
  void changeCapacity() {
    int newCapacity = 10;
    int firstCapacity = airport.capacity;
    airport.changeCapacity(newCapacity);
    assertEquals(newCapacity, airport.capacity);
    assertNotEquals(firstCapacity, airport.capacity);
  }
}