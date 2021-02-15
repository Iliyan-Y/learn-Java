import components.Airport;
import components.Plane;

public class TowerControl {
  static Plane plane1 = new Plane("F1");
  static Plane plane2 = new Plane("F2");
  static Plane plane3 = new Plane("F3");
  static Airport ap1 = new Airport();


  public static void main(String[] args) {
    ap1.landPlane(plane1);
    ap1.landPlane(plane2);
    ap1.landPlane(plane3);
    System.out.println(ap1.hangar.size());
    System.out.println(ap1.showAllPlanesName());
    ap1.takeOffPlane(plane2);
    System.out.println(ap1.showAllPlanesName());
  }
}
