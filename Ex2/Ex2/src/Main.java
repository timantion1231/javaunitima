import java.time.LocalDate;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int programNum = -1;
        String inputLine = "";
        while (programNum != 0) {
            System.out.println("Введите номер программы: 1, 2, 3\n0: Выход");
            inputLine = in.nextLine();
            if (chkNum(inputLine)) programNum = Integer.parseInt(inputLine);
            else {
                System.out.println("Неверный формат номера");
                programNum = -1;
            }
            switch (programNum) {
                case 1 -> ex1();
                case 2 -> ex2();
                case 3 -> ex3();
            }
        }
    }

    static void ex1() {
        ArrayList<Student> students = new ArrayList<Student>();
        int lid = 1234;
        TreeMap<LocalDate, Integer> dateMap = new TreeMap<LocalDate, Integer>();
        Map<Integer, Student> studMap = new HashMap<>();
        students.add(new Student(lid++, "Kavalskyy", "matronovich",
                LocalDate.of(2001, 5, 5), 3.5));
        students.add(new Student(lid++, "Skonkaya", "Petrovna",
                LocalDate.of(2001, 3, 2), 4.5));
        students.add(new Student(lid++, "Shapkov", "Mikevich",
                LocalDate.of(2000, 8, 1), 3.7));
        students.add(new Student(lid, "Pupkin", "Vasevich",
                LocalDate.of(2002, 6, 4), 4.8));

        for (Student stud : students) {
            System.out.print(stud.print());
        }
        students.get(2).setStudentId(1239);
        System.out.println("\n" + students.get(2).print());
        students.remove(students.size() - 1);
        System.out.println("\nLast student removed");

        for (Student stud : students) {
            dateMap.put(stud.getStudentDate(), stud.getStudentId());
            studMap.put(stud.getStudentId(), stud);
        }

        for (Map.Entry<LocalDate, Integer> item : dateMap.entrySet()) {
            System.out.println(studMap.get(item.getValue()).print());
        }

        students.clear();
        System.out.println("All students has been removed");


    }

    static void ex2() {
        ArrayDeque<Student> students = new ArrayDeque<>();
        int sucsessAdds = 0;
        int lid = 1234;
        if (students.offer(new Student(lid++, "Kavalskyy", "matronovich",
                LocalDate.of(2001, 5, 5), 3.5))) sucsessAdds++;
        if (students.offer(new Student(lid++, "Skonkaya", "Petrovna",
                LocalDate.of(2001, 3, 2), 4.5))) sucsessAdds++;
        if (students.offer(new Student(lid++, "Shapkov", "Mikevich",
                LocalDate.of(2000, 8, 1), 3.7))) sucsessAdds++;
        if (students.offer(new Student(lid, "Pupkin", "Vasevich",
                LocalDate.of(2002, 6, 4), 4.8))) sucsessAdds++;

        if (sucsessAdds == students.size()) System.out.println("All students added");
        else System.out.println("Problemas");

        while (!students.isEmpty()) {
            System.out.println(students.poll().print());
        }

        System.out.println("All students removed successfully");
    }

    static void ex3() {

    }

    public static boolean chkNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
}