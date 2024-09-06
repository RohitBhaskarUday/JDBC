package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if(con==null){
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Bhaskar@$123");
        }

        return con;
    }

}
