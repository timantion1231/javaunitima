import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int programNum = -1;
        String inputLine = "";
        while (programNum != 0) {
            System.out.println("Введите номер программы:\n1: Сотрудники\n2: Векторы\n0: Выход");
            inputLine = in.nextLine();
            if (chkNum(inputLine)) programNum = Integer.parseInt(inputLine);
            else {
                System.out.println("Неверный формат номера");
                programNum = -1;
            }
            switch (programNum) {
                case 1 -> employee();
                case 2 -> vectors();
            }
        }
    }

    public static void employee() {
        Programmer tom = new Programmer("Tom", 450000);
        Designer bob = new Designer("Bob", 250000);
        ArrayList<String> tomFrams = new ArrayList<String>();
        ArrayList<String> tomlangs = new ArrayList<String>();

        tomFrams.add("django");
        tomFrams.add("react");
        tomlangs.add("python");
        tomlangs.add("javascript");
        tom.setFrams(tomFrams);
        tom.setLangs(tomlangs);

        tom.printInfo();
        bob.printInfo();
    }

    public static boolean chkNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    public static void vectors() {
        Scanner in = new Scanner(System.in);

        Vector3D v1;
        Vector3D v2;

        System.out.println("Ввести координаты вручную? y/n");

        if (in.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Vector1: x, y, z\n");
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double z1 = in.nextDouble();

            System.out.println("Vector2: x, y, z\n");
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double z2 = in.nextDouble();

            v1 = new Vector3D(x1, y1, z1);
            v2 = new Vector3D(x2, y2, z2);
        } else {
            v1 = Vector3D.genRandomVector();
            System.out.println(Arrays.toString(v1.getVectorCords()));
            v2 = Vector3D.genRandomVector();
            System.out.println(Arrays.toString(v2.getVectorCords()));
        }

        System.out.println("Vector1 length: " + v1.vectorLength()
                + "\nVector2 length: " + v2.vectorLength());

        System.out.println("Скаляр: " + Vector3D.scalarMultiply(v1, v2));

        System.out.println("Векторное:\n" + Arrays.toString(Vector3D.vectorMultiply(v1, v2).getVectorCords()));

        System.out.println("Косинус угла: " + Vector3D.cosAngleVectors(v1, v2));

        System.out.println("Сумма:\n" + Arrays.toString(Vector3D.sumVector(v1, v2).getVectorCords()));

        System.out.println("Разница:\n" + Arrays.toString(Vector3D.differenceVector(v1, v2).getVectorCords()));

       // System.out.println("Random vectors");
    }
}



