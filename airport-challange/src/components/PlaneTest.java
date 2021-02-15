package components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
  @Test
  void createPlaneWithName() {
    Plane plane = new Plane("Test Plane");
    assertEquals("Test Plane", plane.name);
  }

  @Test
  void planeAlwaysFlyWhenCreated() {
    Plane plane = new Plane("Test Plane");
    assertEquals(true, plane.flying);
  }
}