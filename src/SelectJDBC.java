import Connection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class SelectJDBC {

    public static void main(String[] args) {

        try
        {
            Connection con = ConnectionProvider.getConnection();


            // How to select a table from the java code.
            String query = "select * from table1";

            Statement create = con.createStatement();

            ResultSet set = create.executeQuery(query);

            // for iterating over the table we use for loop
            while (set.next()){

                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);

                System.out.println("id: "+ id +" " + " name: "+ name +" "+ " city: "+ city);

            }






        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
