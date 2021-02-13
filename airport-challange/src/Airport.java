import java.util.ArrayList;
import java.util.List;

public class Airport {
    List<Plane> hangar = new ArrayList<>();

    public void landPlane(Plane plane) {
        hangar.add(plane);
    }

    public String displayAllPlanes() {
        List<String> planes = new ArrayList<>();
        hangar.forEach(plane -> planes.add(plane.name));

        return planes.toString();
    }


}
