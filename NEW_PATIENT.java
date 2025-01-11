package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener{
    JComboBox comboBox;

    JTextField textFieldNumber, textName,textFieldDisease,textFieldDeposit;

    JRadioButton r1,r2;
    Choice c1;

    JLabel date;

    JButton b1 , b2;


    NEW_PATIENT(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,550);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel lebelName = new JLabel("NEW PATIENT FROM");
        lebelName.setBounds(118,11,260,53);
        lebelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(lebelName);

        JLabel lebelID = new JLabel("ID : ");
        lebelID.setBounds(35,76,200,14);
        lebelID.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelID.setForeground(Color.WHITE);
        panel.add(lebelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card" ,"Votar Id" , "Driving Lisence"});
        comboBox.setBounds(271, 73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel lebelNumber = new JLabel("Number : ");
        lebelNumber.setBounds(35,111,200,14);
        lebelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelNumber.setForeground(Color.WHITE);
        panel.add(lebelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel lebelName1 = new JLabel("Name : ");
        lebelName1.setBounds(35,151,200,14);
        lebelName1.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelName1.setForeground(Color.WHITE);
        panel.add(lebelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel lebelGender = new JLabel("Gender : ");
        lebelGender.setBounds(35,191,200,14);
        lebelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelGender.setForeground(Color.WHITE);
        panel.add(lebelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel lebelDisease = new JLabel("Disease : ");
        lebelDisease.setBounds(35,231,200,14);
        lebelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelDisease.setForeground(Color.WHITE);
        panel.add(lebelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel lebelRoom = new JLabel("Room : ");
        lebelRoom.setBounds(35,274,200,14);
        lebelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelRoom.setForeground(Color.WHITE);
        panel.add(lebelRoom);

//        Choice choice = new Choice();


        c1 = new Choice();


        try{
            CONNECTION c = new CONNECTION();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,25);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel lebelDate = new JLabel("Date : ");
        lebelDate.setBounds(35,316,200,14);
        lebelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelDate.setForeground(Color.WHITE);
        panel.add(lebelDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel lebelDiposite = new JLabel("Diposite : ");
        lebelDiposite.setBounds(35,359,200,14);
        lebelDiposite.setFont(new Font("Tahoma",Font.BOLD,14));
        lebelDiposite.setForeground(Color.WHITE);
        panel.add(lebelDiposite);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        panel.add(textFieldDeposit);

        b1 = new JButton("ADD");
        b1.setBounds(210,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(370,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        panel.add(b2);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });
        b1.addActionListener(this);


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        b2.addActionListener(this);


        setSize(850,550);
        setLayout(null);
        setLocation(240,130);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            CONNECTION c = new CONNECTION();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }
            else if(r2.isSelected()){
                radioBTN = "Female";
            }
            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try{
                String q = "insert into patient_info values('"+s1+"' , '"+s2+"' , '"+s3+"' , '"+s4+"' , '"+s5+"' , '"+s6+"' , '"+s7+"' , '"+s8+"')";
          String q1 = "update Room set  Availability = 'Occupied' where room_no= " +s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch(Exception a){
                a.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new NEW_PATIENT();
    }
}

