package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextfield, fnameTextfield, emailTextfield,
            addressTextfield, cityTextfield, stateTextfield,
            pincodeTextfield;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;

    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formnumber = new JLabel("APPLICATION FORM NO. " + random);
        formnumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formnumber.setBounds(140, 20, 600, 40);
        add(formnumber);

        JLabel personDetails = new JLabel("PAGE 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel name = new JLabel("First Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextfield.setBounds(300, 140, 400, 30);
        add(nameTextfield);

        JLabel fname = new JLabel("Last Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextfield.setBounds(300, 190, 400, 30);
        add(fnameTextfield);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextfield.setBounds(300, 340, 400, 30);
        add(emailTextfield);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Others");
        other.setBounds(500, 390, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        genderGroup.add(married);
        genderGroup.add(unmarried);
        genderGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextfield = new JTextField();
        addressTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextfield.setBounds(300, 440, 400, 30);
        add(addressTextfield);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextfield.setBounds(300, 490, 400, 30);
        add(cityTextfield);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextfield = new JTextField();
        stateTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextfield.setBounds(300, 540, 400, 30);
        add(stateTextfield);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeTextfield = new JTextField();
        pincodeTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextfield.setBounds(300, 590, 400, 30);
        add(pincodeTextfield);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formNumber = "" + random; //long to string
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        }
        else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextfield.getText();

        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }
        else if (unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if (other.isSelected()){
            marital = "Other";
        }

        String address = addressTextfield.getText();
        String city = cityTextfield.getText();
        String state = stateTextfield.getText();
        String pin = pincodeTextfield.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formNumber+"', '"+name+"', '"+fname+"', '"
                        +dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+
                        "', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formNumber).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void main(
            String[] args) {
        new SignupOne();

    }

}

