package test;

public class RunAllTests {
    public static void main(String[] args) {
        int totalTests = AirportTest.test();
        System.out.println( totalTests + " Total tests ran");
    }
}
