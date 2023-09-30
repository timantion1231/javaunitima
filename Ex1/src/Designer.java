import java.util.List;

public class Designer extends Employee {
    List<String> platforms;
    int experienceY;

    public Designer(String name, int payment) {
        super(name, payment);
    }

    public Designer(String name, int payment, List<String> platforms) {
        super(name, payment);
        try {
            if (platforms.isEmpty()) {
                throw new Exception("Нет доступных платформ");
            }
            this.platforms = platforms;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Designer(String name, int payment, List<String> platforms, int experienceY) {
        super(name, payment);
        try {
            if (platforms.isEmpty()) {
                throw new Exception("Нет доступных платформ");
            }
            if (experienceY < 0 || experienceY > 100) {
                throw new Exception("Неверный стаж");
            }
            this.platforms = platforms;
            this.experienceY = experienceY;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
