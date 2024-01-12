package DbProject;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataModifier {

    public static void ModifyPassword(Connection con, String username, String password) throws SQLException {
        String sql = "UPDATE Users SET password = ? WHERE userName = ?;";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, password);
        statement.setString(2, username);
        int modifiedPassword = statement.executeUpdate();

        if(modifiedPassword > 0){
            JOptionPane.showMessageDialog(null, "Password successfully changed!");
        }
    }
    public static void ModifyFullName(Connection con, String username, String fullName) throws SQLException{
        String sql = "UPDATE Users SET fullName = ? WHERE userName = ?;";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, fullName);
        statement.setString(2, username);

        int modifiedFullName = statement.executeUpdate();

        if(modifiedFullName > 0){
            JOptionPane.showMessageDialog(null, "Full name successfully changed!");
        }
    }
    public static void ModifyEmail(Connection con, String username, String email) throws SQLException{
        String sql = "UPDATE Users SET email = ? WHERE username = ?;";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2,username);

        int modifiedEmail = statement.executeUpdate();

        if(modifiedEmail > 0){
            JOptionPane.showMessageDialog(null, "Email successfully changed!");
        }
    }
}
