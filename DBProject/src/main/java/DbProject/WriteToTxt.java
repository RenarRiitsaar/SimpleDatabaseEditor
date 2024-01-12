package DbProject;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {

    public static void Write(String username, String fullName, String password, String email){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/DbProject/userData.txt", true))){
            writer.write( "username: " + username + "\nfull name: "
                    + fullName + "\npassword: " + password + "\nemail: " + email + "\n" + "\n");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong!");
        }
    }
}