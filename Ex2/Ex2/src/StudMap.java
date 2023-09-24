import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class StudMap {

    Map<String, Double> studMap = new HashMap<>();
    ArrayList<Student> students = new ArrayList<Student>();
    int lid = 1234;

    StudMap() {
        students.add(new Student(lid++, "Kavalskyy", "matronovich",
                LocalDate.of(2001, 5, 5), 3.5));
        students.add(new Student(lid++, "Skonkaya", "Petrovna",
                LocalDate.of(2001, 3, 2), 4.5));
        students.add(new Student(lid++, "Shapkov", "Mikevich",
                LocalDate.of(2000, 8, 1), 2.5));
        students.add(new Student(lid, "Pupkin", "Vasevich",
                LocalDate.of(2002, 6, 4), 4.8));

        for (Student item : students) {
            studMap.put(item.getFIO(), item.getGPA());
        }
    }

    String print() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Double> item : studMap.entrySet()) {
            s.append("key: ").append(item.getKey()).append(" Value: ").append(item.getValue());
        }
        return s.toString();
    }

    String delLossers() {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Double> item : studMap.entrySet()) {
            if (item.getValue() < 3) {
                studMap.remove(item.getKey());
                s.append(item.getKey()).append("removed\n");
            } else s.append(item.getKey()).append("pass\n");
        }
        return s.toString();
    }


    public static String b(String s){


        return "";
    }
}





