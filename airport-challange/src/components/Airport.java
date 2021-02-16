package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport {
  public List<Plane> hangar = new ArrayList<>();
  public int capacity = 3;
  private boolean[] weather = {true, false};

  public void landPlane(Plane plane) {
    if (hangar.size() == capacity) {
      throw new IllegalArgumentException("airport is full");
    }
    if (checkWeather()) {
      throw new IllegalArgumentException("Bad weather, airport is closed");
    }
    hangar.add(plane);
    plane.flying = false;
    System.out.println("Plane " + plane.name + " has landed successfully");
  }

  public void takeOffPlane(Plane plane) {
    if (checkWeather()) {
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

  int getRandomNumber() {
    Random rand = new Random();
    return rand.nextInt(weather.length);
  }

  private boolean checkWeather() {
    return weather[getRandomNumber()];
  }

}
