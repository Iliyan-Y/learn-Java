package components;

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
}