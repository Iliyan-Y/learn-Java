import java.util.ArrayList;

public class Airport {
    ArrayList<Plane> hangar;

    public Airport() {
        this.hangar  = new ArrayList<Plane>();
    }

    public void landPlane(Plane plane) {
        hangar.add(plane);
    }

}
