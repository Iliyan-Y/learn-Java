package components;

import java.util.ArrayList;
import java.util.List;

public class Airport {
  public List<Plane> hangar = new ArrayList<>();

  public void landPlane(Plane plane) {
    if (hangar.size() == 3) {
      throw new IllegalArgumentException("airport is full");
    }
    hangar.add(plane);
    plane.flying = false;
    System.out.println("Plane " + plane.name + " has landed successfully");
  }

  public void takeOffPlane(Plane plane) {
    hangar.remove(plane);
    plane.flying = true;
    System.out.println("Plane " + plane.name + " has took off successfully");
  }


  public String showAllPlanesName() {
    List<String> planes = new ArrayList<>();
    hangar.forEach(plane -> planes.add(plane.name));
    return planes.toString();
  }


}
