package DbProject;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleter {
    public static void deleteData(Connection con, String userName) throws SQLException {
        String sql = "DELETE FROM Users WHERE userName = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, userName);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null,"User successfully deleted!");
        } else {
            JOptionPane.showMessageDialog(null,"User not found!");
        }

    }
}