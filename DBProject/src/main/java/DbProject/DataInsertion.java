package DbProject;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsertion {

    public static void insertData(Connection con, String userName, String password, String fullName, String email) throws SQLException {
        String sql = "INSERT INTO Users (username, password, fullName, email) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);
        statement.setString(3, fullName);
        statement.setString(4, email);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "New user successfully inserted to the database!");
        }

    }
}
