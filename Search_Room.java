package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableCellRenderer;

public class Search_Room extends JFrame {
    Choice choice;
    JTable table;
    Search_Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,420);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Search For Room :");
        label.setBounds(260, 10, 150, 15);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Status :");
        label1.setBounds(30, 40, 120, 15);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        choice = new Choice();
        choice.setBounds(170 , 40 ,140 , 16);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        // Create the table
        table = new JTable();
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.WHITE);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

// Wrap the table in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 87, 700, 200); // Set bounds for the scroll pane
        panel.add(scrollPane); // Add the scroll pane to the panel

// Load data into the table
        try {
            CONNECTION c = new CONNECTION();
            String q = "SELECT * FROM Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton Search = new JButton("Search");
        Search.setBounds(170 , 310 , 90 , 25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        panel.add(Search);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    CONNECTION c = new CONNECTION();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(320 , 310 , 90 , 25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700 , 430);
        setLayout(null);
        setLocation(450, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Search_Room();
    }
}
