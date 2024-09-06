import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.*;

public class PrepStatement {


    public static void main(String[] args) {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/student"; // check for port number inside the sql server
            String username = "root";
            String password = "Bhaskar@$123";
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "insert into table1(tName, tCity) values(?,?)";

            //PreparedStatement are used for dynamic query or paremetrised query = A query which accepts parameters is called prepared statement

            //Now get the object for PreparedStatement
            PreparedStatement ppst = con.prepareStatement(query);

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name = bf.readLine();
            System.out.println("Enter city: ");
            String city = bf.readLine();


            ppst.setString(1, name);
            ppst.setString(2,city);
            ppst.executeUpdate(); // it is a prepared statement so you do not have to pass the query onto this.

            System.out.println("data added to the table");

            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
