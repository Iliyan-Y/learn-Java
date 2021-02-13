public class Tests {
    static Plane plane1 = new Plane("F1");
    static Airport ap1 = new Airport();

    public static void main(String[] args) {
        do {
            int counter = 0;
            try {
                counter++;
                System.out.println("Testing: Planes can land at the airport");
                ap1.landPlane(plane1);
                if(plane1.flying || !ap1.hangar.contains(plane1)){throw null;}else{
                    System.out.println("Test: " + counter + " --Green--");
                }
            }
            catch (Exception e) {
                System.out.println("Test: " + counter + " -------Something went wrong-------");
                break;
            }

            try {
                counter++;
                System.out.println("Testing: Planes can take off from the airport");
                ap1.takeOffPlane(plane1);
                if(!plane1.flying || ap1.hangar.contains(plane1)){throw null;}else{
                    System.out.println("Test: " + counter + " --Green--");
                }
            }
            catch (Exception e) {
                System.out.println("Test: " + counter + " -------Something went wrong------");
                break;
            }

            System.out.println(counter + " tests passed successfully");
        } while (false);
    }
}
