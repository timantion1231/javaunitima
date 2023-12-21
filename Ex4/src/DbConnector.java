import java.sql.*;
import java.util.ArrayList;
//import static jdk.internal.org.jline.utils.Colors.s;


public class DbConnector {
    private Connection connection;
    private Statement st;

    public boolean createConnection(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.st = connection.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
                    "root", "Pass256");
            this.st = connection.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getAll() {
        String result = "";
        try {
            ResultSet res = getQuery("SELECT * FROM users.users;");
            while (res.next()) {
                result += res.getInt("idUsers") + " " +
                        res.getString("Name") + " " +
                        res.getString("Lastname") + " " +
                        res.getString("Username") + " " +
                        res.getFloat("Experience") + " " +
                        res.getString("Position") + " " +
                        res.getInt("Salary") + "\n";
            }
            return result;
        } catch (SQLException e) {
            return result;
        }
    }

    private ResultSet getQuery(String query) {
        ResultSet res;
        try {
            res = st.executeQuery(query);
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUser(int id, String name, String lastname,
                              String username, float experience,
                              String position, int salary) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE users.users SET Name = ?, " +
                            "Lastname = ?, " +
                            "Username = ?, " +
                            "Experience = ?, " +
                            "Position = ?, " +
                            "Salary = ? " +
                            "WHERE idUsers = ?");
            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, username);
            ps.setFloat(4, experience);
            ps.setString(5, position);
            ps.setInt(6, salary);
            ps.setInt(7, id);
            createConnection();
            ps.executeUpdate();
            ps.close();
            closeConnection();

            // st.executeQuery(s);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        String query = "";
        try {
            query += "DELETE FROM users.users " +
                    "WHERE idUsers = ?";
            System.out.println(query);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            createConnection();
            ps.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(String name, String lastname,
                        String username, float experience,
                        String position, int salary) {
        String query = "";
        try {
            query = "INSERT INTO users.users " +
                    "(Name, " +
                    "Lastname, " +
                    "Username, " +
                    "Experience, " +
                    "Position, " +
                    "Salary) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println(query);

            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, username);
            ps.setFloat(4, experience);
            ps.setString(5, position);
            ps.setInt(6, salary);

            createConnection();
            ps.executeUpdate();
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findUsers(String name, String lastname,
                            String username, String experience,
                            String position, String salary, String id) {
        String result = "";
        try {
            String query = "SELECT * FROM users.users WHERE ";
            ArrayList<Integer> entries = new ArrayList<>();
            int counter = 1;
            createConnection();

            if (!name.isEmpty()) {
                query += "Name = ? ";
                entries.add(1);
            }

            if (!lastname.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "Lastname = ? ";
                entries.add(2);
            }

            if (!username.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "Username = ? ";
                entries.add(3);
            }

            if (!experience.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "Experience = ? ";
                entries.add(4);
            }

            if (!position.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "Position = ? ";
                entries.add(5);
            }

            if (!salary.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "Salary = ? ";
                entries.add(6);
            }

            if (!id.isEmpty()) {
                if (!entries.isEmpty()) query += "AND ";
                query += "idUsers = ? ";
                entries.add(7);
            }

            PreparedStatement ps = connection.prepareStatement(query);

            System.out.println(query);
            for (int item : entries) {
                switch (item) {
                    case 1 -> ps.setString(counter, name);
                    case 2 -> ps.setString(counter, lastname);
                    case 3 -> ps.setString(counter, username);
                    case 4 -> ps.setFloat(counter, Float.parseFloat(experience));
                    case 5 -> ps.setString(counter, position);
                    case 6 -> ps.setInt(counter, Integer.parseInt(salary));
                    case 7 -> ps.setInt(counter, Integer.parseInt(id));
                }
                counter++;
            }


            ResultSet rs = ps.executeQuery();
            counter = 1;
            while (rs.next()) {
                result += "---" + counter + "---\n" + "idUsers: " + rs.getInt("idUsers") + " Name: " +
                        rs.getString("Name") + "\nLastname: " +
                        rs.getString("Lastname") + " Username: " +
                        rs.getString("Username") + "\nExperience: " +
                        rs.getFloat("Experience") + " Position: " +
                        rs.getString("Position") + " Salary: " +
                        rs.getInt("Salary") + "\n";
            }
            closeConnection();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
