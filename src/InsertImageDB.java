import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImageDB {

    public static void main(String[] args) {


        try {

            //load the driver first
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "Bhaskar@$123";
            //connection creating
            Connection con = DriverManager.getConnection(url, username, password);

            // execute your queries
            String q = "insert into images(pic) values(?)";
            PreparedStatement ppmt = con.prepareStatement(q);

            // we usually do ppmt.setString("") something
            // but we are trying to store an image inside of the database
            FileInputStream fis = new FileInputStream("/Users/rohitbhaskaruday/Downloads/IMG_C56E315DA773-1.jpeg");
            ppmt.setBinaryStream(1,fis, fis.available());

            //execute Query
            ppmt.executeUpdate();

            System.out.println("added into the db");
            // close
            con.close();





        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
