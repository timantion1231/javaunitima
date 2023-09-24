import java.time.LocalDate;

public class Student {
    private int studentId;
    String sName;
    String faName;
    LocalDate bDate;
    double GPA;

    LocalDate getStudentDate() {
        return this.bDate;
    }

    void setStudentId(int Id) {
        this.studentId = Id;
    }

    int getStudentId(){
        return this.studentId;
    }


    Student(int studentId, String sName, String faName, LocalDate bDate, double GPA) {
        this.studentId = studentId;
        this.sName = sName;
        this.faName = faName;
        this.bDate = bDate;
        this.GPA = GPA;
    }

    String print() {
        return "id: " + studentId + "; surname: " + sName + "; father name: " + faName + "; birth date: " + bDate.toString()
                + "; GPA: " + GPA + "\n";
    }
}
