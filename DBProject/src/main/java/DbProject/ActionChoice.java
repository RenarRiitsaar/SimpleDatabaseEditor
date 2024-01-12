package DbProject;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ActionChoice {


    private static Set<String> users;

    static void inputData() {
        String username = null;
        String password = null;
        String fullName = null;
        String email = null;

        while(username == null) {
            username = JOptionPane.showInputDialog("Enter a new username:");
            if(username.isEmpty()){
                username = null;
                JOptionPane.showMessageDialog(null, "Username field cannot be empty!");
            }
        }
        while(password == null) {
            password = JOptionPane.showInputDialog("Enter a password for the user:");
            if(password.isEmpty()){
                password = null;
                JOptionPane.showMessageDialog(null, "Password field cannot be empty!");
            }
        }
        while(fullName == null) {
            fullName = JOptionPane.showInputDialog("Enter a full name of the user:");
            if(fullName.isEmpty()){
                fullName = null;
                JOptionPane.showMessageDialog(null,"Full name field cannot be empty!");
            }
        }
        while(email == null) {
            email = JOptionPane.showInputDialog("Enter the email address for the user:");
            if(email.isEmpty()){
                email = null;
                JOptionPane.showMessageDialog(null, "Email field cannot be empty!");
            }
        }

        try {
            DataInsertion.insertData(Main.getCon(), username, password, fullName, email);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }

    static void initializeData(){
        String command = "SELECT * FROM Users";
        Statement statements;
        try {
            statements = Main.getCon().createStatement();
            ResultSet results = statements.executeQuery(command);
            users = new HashSet<>();

            while (results.next()) {
                String username = results.getString("username");
                users.add(username);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }
    static void viewData() {
        String sql = "SELECT * FROM Users";
        Statement statement;
        File file = null;
        try {
            statement = Main.getCon().createStatement();
            ResultSet result = statement.executeQuery(sql);


            while (result.next()) {
                String username = result.getString("username");
                String fullName = result.getString("fullName");
                String password = result.getString("password");
                String email = result.getString("email");

                WriteToTxt.Write(username, fullName, password, email);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file = new File("src/main/java/DbProject/userData.txt"));
            Thread.sleep(2000);

        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        } finally {
            assert file != null;
            file.delete();
        }
    }

    static void deleteData() {
        String username = JOptionPane.showInputDialog("Enter the username to delete from the database:");

        try {
            UserDeleter.deleteData(Main.getCon(), username);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }

    static void modifyPassword() {
        initializeData();
        String username = null;
        String password = null;

        while(username == null) {
            username = JOptionPane.showInputDialog("Enter the username to modify password for:");

            if(username.isEmpty()){
                username = null;
                JOptionPane.showMessageDialog(null, "Username field cannot be empty!");

            } else if (!users.contains(username)) {
                username = null;
                JOptionPane.showMessageDialog(null, "Username is not listed in database!");
            }
        }

        while(password == null) {
            password = JOptionPane.showInputDialog("Enter a new password for " + username + " !");

            if(password.isEmpty()){
                password = null;
                JOptionPane.showMessageDialog(null, "Password field cannot be empty!");
            }
        }
        try {
            DataModifier.ModifyPassword(Main.getCon(), username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }

    static void modifyFullName() {
        initializeData();
        String fullName = null;
        String username = null;

        while(username == null) {
            username = JOptionPane.showInputDialog("Enter the username to modify full name for:");

            if(username.isEmpty()){
                username = null;
                JOptionPane.showMessageDialog(null, "Username field cannot be empty!");

            } else if (!users.contains(username)) {
                username = null;
                JOptionPane.showMessageDialog(null,"User is not listed in database!");
            }
        }

        while (fullName == null) {
            fullName = JOptionPane.showInputDialog("Enter a new full name for " + username + " !");
            if(fullName.isEmpty()){
                fullName = null;
                JOptionPane.showMessageDialog(null, "Full name cannot be empty!");
            }
        }

        try {
            DataModifier.ModifyFullName(Main.getCon(), username, fullName);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }

    static void modifyEmail(){
        initializeData();
        String username = null;
        String email = null;

        while(username == null) {
            username = JOptionPane.showInputDialog("Enter the username to modify email for:");

            if(username.isEmpty()){
                username = null;
            JOptionPane.showMessageDialog(null, "Username field cannot be empty!");

            } else if (!users.contains(username)) {
                username =null;
                JOptionPane.showMessageDialog(null,"Username is not listed in database!");
            }
        }

        while(email == null) {
            email = JOptionPane.showInputDialog("Enter a new email for " + username + " !");

            if(email.isEmpty()){
                email = null;
                JOptionPane.showMessageDialog(null,"Email field cannot be empty!");
            }
        }

        try {
            DataModifier.ModifyEmail(Main.getCon(), username, email);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }
}
