package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Airport {
  public List<Plane> hangar = new ArrayList<>();
  public int capacity = 3;

  public void landPlane(Plane plane) {
    if (hangar.size() == capacity) {
      throw new IllegalArgumentException("airport is full");
    }
    hangar.add(plane);
    plane.flying = false;
    System.out.println("Plane " + plane.name + " has landed successfully");
  }

  public void takeOffPlane(Plane plane) {
    if (stormyWeather()) {
      throw new IllegalArgumentException("Bad weather, airport is closed");
    }
    hangar.remove(plane);
    plane.flying = true;
    System.out.println("Plane " + plane.name + " has took off successfully");
  }

  public void changeCapacity(int newCapacity) {
    capacity = newCapacity;
  }

  public String showAllPlanesName() {
    List<String> planes = new ArrayList<>();
    hangar.forEach(plane -> planes.add(plane.name));
    return planes.toString();
  }

  private boolean stormyWeather() {
    boolean[] weather = {true, false, false, true, true, false, true, false};
    Random rand = new Random();
    int randomWeather = rand.nextInt(weather.length);
    return weather[randomWeather];
  }

}
