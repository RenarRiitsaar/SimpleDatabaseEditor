package DbProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {

    JButton input;
    JButton view;
    JButton modify;
    JButton delete;
    JLabel label = new JLabel();

    Frame() {

        label.setText("Available actions:");
        label.setBounds(85, 10, 100, 50);
        label.setVisible(true);

        input = new JButton();
        input.addActionListener(this);
        input.setBounds(85, 50, 100, 50);
        input.setText("Input");

        view = new JButton();
        view.addActionListener(this);
        view.setBounds(85, 100, 100, 50);
        view.setText("View");

        modify = new JButton();
        modify.addActionListener(this);
        modify.setBounds(85, 150, 100, 50);
        modify.setText("Modify");

        delete = new JButton();
        delete.addActionListener(this);
        delete.setBounds(85, 200, 100, 50);
        delete.setText("Delete");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Database editor");
        this.setLayout(null);
        this.setSize(300, 300);
        this.setVisible(true);

        this.add(label);
        this.add(input);
        this.add(view);
        this.add(modify);
        this.add(delete);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == input) {
            ActionChoice.inputData();

        } else if (e.getSource() == view) {
            ActionChoice.viewData();

         } else if(e.getSource()==delete){
        ActionChoice.deleteData();

        } else if (e.getSource() == modify) {
            new ModifyDataFrame();

        }

        }
    }


