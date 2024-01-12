package DbProject;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class ModifyDataFrame implements ActionListener {

    private final JFrame modifyDataMenu;
    private final JButton fullName;
    private final JButton password;
    private final JButton email;
    private final JLabel label;

    ModifyDataFrame() {
        modifyDataMenu = new JFrame();
        label = new JLabel();

        label.setText("Available actions:");
        label.setBounds(85, 10, 100, 50);
        label.setVisible(true);
        modifyDataMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyDataMenu.setTitle("Modifying menu");
        modifyDataMenu.setLayout(null);
        modifyDataMenu.setSize(300, 300);
        modifyDataMenu.setVisible(true);

        fullName = new JButton();
        fullName.addActionListener(this);
        fullName.setText("Full Name");
        fullName.setBounds(85, 50, 100, 50);
        fullName.setVisible(true);

        password = new JButton();
        password.addActionListener(this);
        password.setText("Password");
        password.setBounds(85, 100, 100, 50);
        password.setVisible(true);

        email = new JButton();
        email.addActionListener(this);
        email.setText("Email");
        email.setBounds(85, 150, 100, 50);
        email.setVisible(true);

        modifyDataMenu.add(label);
        modifyDataMenu.add(fullName);
        modifyDataMenu.add(password);
        modifyDataMenu.add(email);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fullName) {
            ActionChoice.modifyFullName();

        } else if (e.getSource() == password) {
            ActionChoice.modifyPassword();

        } else if (e.getSource() == email) {
            ActionChoice.modifyEmail();
        }
    }
}