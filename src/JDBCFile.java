import java.sql.*;


// Program for JDBC connectivity
public class JDBCFile {

    public static void main(String[] args) {

        // sql would through a checked exception that is a compile time error
        // so handle it
        try{

            // first load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/student"; // check for port number inside the sql server
            String username = "root";
            String password = "Bhaskar@$123";
            Connection con = DriverManager.getConnection(url, username, password);

            //check if the connection is open or created else closed.
            if(con.isClosed()){
                System.out.println("connection is closed");
            }else{
                System.out.println("Connection is created with the database.");
            }

            // now create a query
            String q = "create table table1(tid int(20) primary key auto_increment, " +
                    "tName varchar(200) not null, tcity varchar(400))";

            // use of statement - to fire the above query
            Statement smt = con.createStatement();
            smt.executeUpdate(q); // if this does not execute directly we will go to exception.

            System.out.println("Table has been created in the database");




            // now close the connection
            con.close();



        }catch (ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }



    }



}
