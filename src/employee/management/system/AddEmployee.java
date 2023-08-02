package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField efname, elname, eaddress, ephone, epostalcode, eemail, esalary, edesignation;
    JDateChooser edob;
    JComboBox eeducation;
    JLabel lblempId;
    JButton add, back;
    
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("First Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        efname = new JTextField();
        efname.setBounds(200, 150, 150, 30);
        add(efname);
        
        JLabel labelfname = new JLabel("Last Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        elname = new JTextField();
        elname.setBounds(600, 150, 150, 30);
        add(elname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        edob = new JDateChooser();
        edob.setBounds(200, 200, 150, 30);
        add(edob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        esalary = new JTextField();
        esalary.setBounds(600, 200, 150, 30);
        add(esalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        eaddress = new JTextField();
        eaddress.setBounds(200, 250, 150, 30);
        add(eaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        ephone = new JTextField();
        ephone.setBounds(600, 250, 150, 30);
        add(ephone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        eemail = new JTextField();
        eemail.setBounds(200, 300, 150, 30);
        add(eemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        eeducation = new JComboBox(courses);
        eeducation.setBackground(Color.WHITE);
        eeducation.setBounds(600, 300, 150, 30);
        add(eeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        edesignation = new JTextField();
        edesignation.setBounds(200, 350, 150, 30);
        add(edesignation);
        
        JLabel labelaadhar = new JLabel("Postal Code");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        epostalcode = new JTextField();
        epostalcode.setBounds(600, 350, 150, 30);
        add(epostalcode);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = efname.getText();
            String lname = elname.getText();
            String dob = ((JTextField) edob.getDateEditor().getUiComponent()).getText();
            String salary = esalary.getText();
            String address = eaddress.getText();
            String phone = ephone.getText();
            String email = eemail.getText();
            String education = (String) eeducation.getSelectedItem();
            String designation = edesignation.getText();
            String postalcode = epostalcode.getText();
            String empId = lblempId.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+fname+"', '"+lname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+postalcode+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
