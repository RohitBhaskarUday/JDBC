import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.ConnectionProvider;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        try{
            Connection connection = ConnectionProvider.getConnection();

            String q = "insert into images(pic) values(?)";
            PreparedStatement ppmt = connection.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);
            ppmt.setBinaryStream(1, fis, fis.available());

            ppmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "success");

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}