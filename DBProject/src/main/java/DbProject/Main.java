package DbProject;

import lombok.Getter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    @Getter
    private static Connection con;

    public static void main(String[] args) throws SQLException {

        //Configuration of database

        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pw = "1234";


        try {
            con = DriverManager.getConnection(url, user, pw);
            new Frame();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot establish connection to database!");

        } finally {
            new Frame();
        }
    }
}


