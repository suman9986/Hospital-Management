package hospital.management.system;

import hospital.management.system.CONNECTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Customer-ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            CONNECTION c = new CONNECTION();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("ID_Num"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room No");
        label2.setBounds(30,120,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel RNO = new JLabel();
        RNO.setBounds(200,120,150,20);
        RNO.setFont(new Font("Tahoma",Font.BOLD,14));
        RNO.setForeground(Color.WHITE);
        panel.add(RNO);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,160,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel Intime = new JLabel();
        Intime.setBounds(200,160,210,20);
        Intime.setFont(new Font("Tahoma",Font.BOLD,14));
        Intime.setForeground(Color.WHITE);
        panel.add(Intime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,210,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        Date date = new Date();
        JLabel Outtime = new JLabel(""+date);
        Outtime.setBounds(200,210,210,20);
        Outtime.setFont(new Font("Tahoma",Font.BOLD,14));
        Outtime.setForeground(Color.WHITE);
        panel.add(Outtime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,340,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CONNECTION c = new CONNECTION();
                try{
                    c.statement.executeUpdate("delete from patient_info where ID_Num = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room set Availability = 'Avalabile' where room_no = '"+RNO.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }
                catch(Exception a){
                    a.printStackTrace();
                }
            }
        });


        JButton Cheek = new JButton("Cheek");
        Cheek.setBounds(200,340,120,30);
        Cheek.setBackground(Color.BLACK);
        Cheek.setForeground(Color.WHITE);
        panel.add(Cheek);

        Cheek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CONNECTION c = new CONNECTION();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where ID_Num ='"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        RNO.setText(resultSet.getString("Room_Number"));
                        Intime.setText(resultSet.getString("Time"));
                    }
                }
                catch(Exception q){
                    q.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(400,340,120,30);
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
        setSize(700,460);
        setLayout(null);
        setLocation(400,190);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}

