package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient extends JFrame {
    Update_Patient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 390);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(100, 11, 270, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(30, 65, 100, 15);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(150 , 65 , 100 , 25);
        panel.add(choice);

        try{
            CONNECTION c = new CONNECTION();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(30, 110, 150, 15);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(150 , 110 , 150 , 15);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In Time :");
        label4.setBounds(30, 149, 150, 15);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldI = new JTextField();
        textFieldI.setBounds(150 , 149 , 170 , 15);
        panel.add(textFieldI);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(30, 185, 150, 15);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldA = new JTextField();
        textFieldA.setBounds(150 , 185 , 150 , 15);
        panel.add(textFieldA);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(30, 223, 150, 15);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldP = new JTextField();
        textFieldP.setBounds(150 , 223 , 150 , 15);
        panel.add(textFieldP);

        JButton Cheek = new JButton("Cheek");
        Cheek.setBounds(60,300,120,30);
        Cheek.setBackground(Color.BLACK);
        Cheek.setForeground(Color.WHITE);
        panel.add(Cheek);

        Cheek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id  = choice.getSelectedItem();
                String q = "select * from patient_info where Name = '"+id+"'";
                try{
                    CONNECTION c = new CONNECTION();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldI.setText(resultSet.getString("Time"));
                        textFieldA.setText(resultSet.getString("Diposite"));

                    }
                    ResultSet resultSet1  = c.statement.executeQuery("select * from Room where room_no  = '"+textFieldR.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountpaid = Integer.parseInt(price) - Integer.parseInt(textFieldA.getText());
                        textFieldP.setText(""+amountpaid);
                    }
                }
                catch (Exception E){

                }
            }
        });

        JButton Update = new JButton("Update");
        Update.setBounds(220,300,120,30);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        panel.add(Update);

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    CONNECTION c = new CONNECTION();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldI.getText();
                    String amount = textFieldA.getText();
//                    c.statement.executeQuery("select * from patient_info where Room_Number = '"+room+"' , Time =  '"+time+"' , Diposite = '"+amount+"' where name = '"+q+"'");
                    String query = "UPDATE patient_info SET Room_Number = '" + room + "', Time = '" + time + "', Diposite = '" + amount + "' WHERE Name = '" + q + "'";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }
                catch( Exception E1){
                   E1.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(400,300,120,30);
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
        setSize(800, 450);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient();
    }
}
