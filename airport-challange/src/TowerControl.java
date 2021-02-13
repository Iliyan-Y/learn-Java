public class TowerControl {
    static Plane plane1 = new Plane("F1");;
    static Airport ap1 = new Airport();


    public static void main(String[] args) {
        ap1.landPlane(plane1);
        ap1.landPlane(plane1);

        System.out.println(ap1.hangar.size());
        System.out.println(ap1.hangar.get(0).name);
        System.out.println(ap1.displayAllPlanes());
    }
}
