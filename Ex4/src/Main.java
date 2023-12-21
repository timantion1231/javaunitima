import java.sql.*;
import javax.swing.*;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {

        DbConnector db = new DbConnector();
        db.createConnection("jdbc:mysql://localhost:3306/users",
                "root", "Pass256");
        out.println(db.getAll());
        UI.mainFrame();
    }


}



/*
        try{
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users",
                "root",
                "Pass256");
                Statement st=connection.createStatement();
                String s="SELECT * FROM users.users;";
                ResultSet res=st.executeQuery(s);
                while(res.next()){
                System.out.println(res.getInt("idUsers")+" "+res.getString("Name"));
                }
                connection.close();
                }
                catch(SQLException e){
                e.printStackTrace();
                }

 */