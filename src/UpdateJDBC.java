import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionProvider;
import com.mysql.cj.PreparedQuery;

public class UpdateJDBC {


    public static void main(String[] args) {

        try{
            Connection con = ConnectionProvider.getConnection();

            String query  = "update table1 set tName=?, tcity=? where tid=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter new name: ");
            String name = br.readLine();

            System.out.println("Enter new ity name: ");
            String city = br.readLine();

            System.out.println("Enter the student ID number");
            int id = Integer.parseInt(br.readLine());

            // fire the queries
            PreparedStatement pmpt = con.prepareStatement(query);
            pmpt.setString(1,name);
            pmpt.setString(2, city);
            pmpt.setInt(3, id);
            //execute your query
            pmpt.executeUpdate();

            System.out.println("Query Executed successfully");

            con.close();








        }catch (Exception e){
       e.printStackTrace();
        }


    }

}
