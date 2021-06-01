import java.io.*;

public class Lab1 {
    public static double getDouble(String message) {
        System.out.println(message);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            try {
                return Double.parseDouble(s);
            }
            catch (NumberFormatException e) {
                return 0.0;
            }
        }
        catch (IOException e) {
            return 0.0;
        }
    }
    public static void main(String [] args) {
        Point3d point0 = new Point3d(getDouble("Point 0 x coord"),
                getDouble("Point 0 y coord"), getDouble("Point 0 z coord"));

        Point3d point1 = new Point3d(getDouble("Point 1 x coord"),
                getDouble("Point 1 y coord"), getDouble("Point 1 z coord"));

        Point3d point2 = new Point3d(getDouble("Point 2 x coord"),
                getDouble("Point 2 y coord"), getDouble("Point 2 z coord"));
        if (point0.equals(point1) || point1.equals(point2) || point0.equals(point2)) {
            System.out.println("Two or more points are the same.");
            System.exit(0);
        }
        double area = computeArea(point0, point1, point2);
        System.out.printf("area: %.4f\n", area);
    }
    public static double computeArea(Point3d point0, Point3d point1, Point3d point2) {
        double a = point0.distanceTo(point1);
        double b = point1.distanceTo(point2);
        double c = point0.distanceTo(point2);
        double s = (a + b + c)/2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
