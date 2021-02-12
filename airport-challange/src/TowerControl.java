public class TowerControl {

    public static void main(String[] args) {
        Plane plane1 = new Plane("F1");
        Airport ap1 = new Airport();
        ap1.landPlane(plane1);
        ap1.landPlane(plane1);
        System.out.println(ap1.hangar.size());
        System.out.println(ap1.hangar.get(0).name);
    }
}
