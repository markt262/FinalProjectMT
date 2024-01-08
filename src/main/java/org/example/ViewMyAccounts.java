package org.example;

import javax.swing.*;

public class ViewMyAccounts extends JFrame {

    private JPanel panel4;

    private JLabel lbaAll;
    private JList list1;


    public ViewMyAccounts(){
        setContentPane(panel4);
        setTitle("All Accounts I own");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



    }
    public void returnTable(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame();
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }


}
