import java.util.Random;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;

    }

    public double vectorLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double scalarMultiply(Vector3D v1, Vector3D v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static Vector3D vectorMultiply(Vector3D v1, Vector3D v2) {
        double x1 = v1.x;
        double x2 = v2.x;
        double y1 = v1.y;
        double y2 = v2.y;;
        double z1 = v1.z;
        double z2 = v2.z;

        return new Vector3D(y1*z2 - z1*y2, z1*x2-x1*z2, x1*y2-y1*x2);
    }

    public static double cosAngleVectors(Vector3D v1, Vector3D v2) {
        try {
            if (v1.vectorLength() * v2.vectorLength() == 0) {
                throw new Exception("Деление на ноль");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return scalarMultiply(v1, v2) / (v1.vectorLength() * v2.vectorLength());
    }

    public static Vector3D sumVector(Vector3D v1, Vector3D v2) {
        double x1 = v1.x;
        double x2 = v2.x;

        double y1 = v1.y;
        double y2 = v2.y;

        double z1 = v1.z;
        double z2 = v2.z;

        return new Vector3D(x1+x2, y1+y2, z1+z2);
    }

    public double[] getVectorCords() {
        return new double[]{this.x, this.y, this.z};
    }

    public static Vector3D differenceVector(Vector3D v1, Vector3D v2) {
        double x1 = v1.x;
        double x2 = v2.x;

        double y1 = v1.y;
        double y2 = v2.y;

        double z1 = v1.z;
        double z2 = v2.z;

        return new Vector3D(x1-x2, y1-y2, z1-z2);
    }

    public static Vector3D[] randomVectorsArray(int length) {
        Vector3D[] arr = new Vector3D[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = new Vector3D(rnd.nextDouble(-100, 100),
                    rnd.nextDouble(-100, 100),
                    rnd.nextDouble(-100, 100));
        }
        return arr;
    }

    public static Vector3D genRandomVector() {
        Random rnd = new Random();
        return new Vector3D(rnd.nextInt(-100, 100),
                rnd.nextInt(-100, 100),
                rnd.nextInt(-100, 100));
    }

}
