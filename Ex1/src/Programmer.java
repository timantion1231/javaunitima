//import java.util.ArrayList;

import java.util.List;

public class Programmer extends Employee {

    private List<String> langs;// = new ArrayList<>();
    private List<String> frams;//= new ArrayList<>();

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }

    public void setFrams(List<String> frams) {
        this.frams = frams;
    }

    public List<String> getLangs() {
        return this.langs;
    }

    public List<String> getFrams() {
        return this.frams;
    }

    public Programmer(String name, int payment) {
        super(name, payment);
    }

    public Programmer(String name, int payment, List<String> langs) {
        super(name, payment);
        try {
            if (langs.isEmpty()) {
                throw new Exception("Нет доступных языков");
            }
            this.langs = langs;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Programmer(String name, int payment, List<String> langs, List<String> frams) {
        super(name, payment);
        try {
            if (langs.isEmpty()) {
                throw new Exception("Нет доступных языков");
            }
            if (frams.isEmpty()) {
                throw new Exception("Нет доступных фреймворков");
            }
            this.langs = langs;
            this.frams = frams;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Languages: " +  langs + "\nFrameworks: " + frams);
    }
}
