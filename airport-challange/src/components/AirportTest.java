package components;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class AirportTest {
  Airport airport = new Airport();
  Plane plane = new Plane("test Plane");
  Airport airportSpy = Mockito.spy(airport);
  int goodWeather = 1;
  int badWeather = 0;

  @Test
  void landPlane() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    airportSpy.landPlane(plane);
    assertEquals(false, plane.flying);
    assertEquals(true, airportSpy.hangar.contains(plane));
  }

  @Test
  @DisplayName("Planes cant land when airport is full")
  void landPlaneWhenApFull() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    for (int i = 0; i < airportSpy.capacity; i++) {
      airportSpy.landPlane(new Plane("random"));
    }
    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          airportSpy.landPlane(plane);
        });
    assertEquals("airport is full", exceptionThatWasThrown.getMessage());
  }

  @Test
  @DisplayName("Airport capacity can be overwritten")
  void airportCapCanBeChanged() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    int newCapacity = 5;
    airportSpy.capacity = newCapacity;
    for (int i = 0; i < airportSpy.capacity; i++) {
      airportSpy.landPlane(new Plane("Tests"));
    }
    assertEquals(newCapacity, airportSpy.hangar.size());
  }


  @Test
  @DisplayName("prevent Plane To take off in stormy weather")
  void preventTakeOffInStormyWeather() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    airportSpy.landPlane(plane);
    doReturn(badWeather).when(airportSpy).getRandomNumber();
    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          airportSpy.takeOffPlane(plane);
        });
    assertEquals("Bad weather, airport is closed",
        exceptionThatWasThrown.getMessage());
  }

  @Test
  @DisplayName("prevent landing off in stormy weather")
  void preventLandingInStormyWeather() {
    doReturn(badWeather).when(airportSpy).getRandomNumber();

    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          airportSpy.landPlane(plane);
        });
    assertEquals("Bad weather, airport is closed",
        exceptionThatWasThrown.getMessage());
  }

  @Test
  void takeOffPlane() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    airportSpy.landPlane(plane);
    airportSpy.takeOffPlane(plane);
    assertTrue(plane.flying);
    assertFalse(airportSpy.hangar.contains(plane));
  }

  @Test
  void showAllPlanesName() {
    doReturn(goodWeather).when(airportSpy).getRandomNumber();
    airportSpy.landPlane(plane);
    airportSpy.landPlane(new Plane("test Plane 2"));
    List<String> expectedList = new ArrayList<>();
    expectedList.add("test Plane");
    expectedList.add("test Plane 2");
    assertEquals(expectedList.toString(), airportSpy.showAllPlanesName());
  }

  @Test
  void changeCapacity() {
    int newCapacity = 10;
    int firstCapacity = airport.capacity;
    airport.changeCapacity(newCapacity);
    assertEquals(newCapacity, airport.capacity);
    assertNotEquals(firstCapacity, airport.capacity);
  }

  @Test
  void planesCanNotTakeOffIfNotAtAirport() {
    Airport newAirport = Mockito.spy(new Airport());
    Plane testPlane = new Plane("TestPlane2");
    doReturn(goodWeather).when(newAirport).getRandomNumber();

    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          newAirport.takeOffPlane(testPlane);
        });
    assertEquals("This plain isn't at this airport",
        exceptionThatWasThrown.getMessage());
  }

  @Test
  void planesCanNotTakeOffFromDifferentLocation() {
    Airport newAirport = Mockito.spy(new Airport());
    Airport newMexicoAp = Mockito.spy(new Airport());
    Plane testPlane = new Plane("TestPlane2");
    doReturn(goodWeather).when(newAirport).getRandomNumber();
    doReturn(goodWeather).when(newMexicoAp).getRandomNumber();
    newAirport.landPlane(testPlane);

    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          newMexicoAp.takeOffPlane(testPlane);
        });
    assertEquals("This plain isn't at this airport",
        exceptionThatWasThrown.getMessage());
  }

  @Test
  void planesCanLandOnlyIfTheyFly() {
    Airport newAirport = Mockito.spy(new Airport());
    Plane testPlane = new Plane("TestPlane2");
    doReturn(goodWeather).when(newAirport).getRandomNumber();
    newAirport.landPlane(testPlane);

    Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
        () -> {
          newAirport.landPlane(testPlane);
        });
    assertEquals("This plain isn't flying",
        exceptionThatWasThrown.getMessage());
  }

}