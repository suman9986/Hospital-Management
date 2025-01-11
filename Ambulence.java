package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulence extends JFrame {
    JTable table;
    Ambulence(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5, 690,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);


        table = new JTable();
        table.setBounds(10,34,650,370);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        try{
            CONNECTION c = new CONNECTION();
            String q = "select * from Ambulence";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(75,11,105,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label1 = new JLabel("Gender");
        label1.setBounds(230,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("Contact");
        label2.setBounds(400,11,105,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel label3 = new JLabel("Availability");
        label3.setBounds(540,11,105,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel label4 = new JLabel("Location");
        label4.setBounds(700,11,105,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JButton button = new JButton("BACK");
        button.setBounds(280,420,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,470);
        setLayout(null);
        setLocation(420,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Ambulence();
    }
}
