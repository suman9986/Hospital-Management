package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableCellRenderer;

public class All_Patient_Info extends JFrame {
    JTable table;
    All_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5, 890,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);


         table = new JTable();
        table.setBounds(10,34,820,370);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        try{
            CONNECTION c = new CONNECTION();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label7 = new JLabel("ID");
        label7.setBounds(35,11,105,20);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label1 = new JLabel("Aadhar No");
        label1.setBounds(135,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(255,11,105,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Gender");
        label3.setBounds(348,11,105,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Desease");
        label4.setBounds(445,11,105,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Room");
        label5.setBounds(545,11,105,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Date");
        label6.setBounds(649,11,105,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(750,11,105,20);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBounds(350,420,120,30);
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
        setSize(900,470);
        setLayout(null);
        setLocation(420,190);
        setVisible(true);
    }
    public static void main(String[] args) {

        new All_Patient_Info();
    }
}

