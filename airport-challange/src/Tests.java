public class Tests {

    public static void main(String[] args) {
        try {
            System.out.println("Testing: Planes can land at the airport");
            Plane plane1 = new Plane("F1");
            Airport ap1 = new Airport();
            ap1.landPlane(plane1);

            if(plane1.flying || !ap1.hangar.contains(plane1)){throw null;}else{
                System.out.println("--Green--");
            }
        }
        catch (Exception e) {
            System.out.println("----------------Something went wrong---------------");
        }

        try {
            System.out.println("Testing: Planes can take off from the airport");
            Plane plane1 = new Plane("F1");
            Airport ap1 = new Airport();
            ap1.landPlane(plane1);
            ap1.takeOffPlane(plane1);

            if(!plane1.flying || ap1.hangar.contains(plane1)){throw null;}else{
                System.out.println("--Green--");
            }
        }
        catch (Exception e) {
            System.out.println("----------------Something went wrong---------------");
        }
    }
}
