package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
        JPasswordField ssnTextfield;
    JButton next;
    JRadioButton yes, no;
    JDateChooser dateChooser;
    JComboBox ethnicityComboBox, militaryStatus, incomeCat, eduCat, occCat, citCat;
    String formnumber;

    SignupTwo(String formnumber) {
        this.formnumber = formnumber;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel addDetails = new JLabel("PAGE 2 : Additional Details");
        addDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        addDetails.setBounds(290, 80, 400, 30);
        add(addDetails);

        JLabel ethinicity = new JLabel("Ethnicity:");
        ethinicity.setFont(new Font("Raleway", Font.BOLD, 20));
        ethinicity.setBounds(100, 140, 100, 30);
        add(ethinicity);

        ethnicityComboBox = new JComboBox(new String[] {"Asian", "American Indian", "African American", "Caucasian", "Hispanic", "Other"});
        ethnicityComboBox.setBounds(300, 140, 400, 30);
        ethnicityComboBox.setBackground(Color.WHITE);
        add(ethnicityComboBox);

        JLabel mstatus = new JLabel("Military Status:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mstatus.setBounds(100, 190, 250, 30);
        add(mstatus);

        militaryStatus = new JComboBox(new String[] {"Active", "Inactive", "Not a Veteran"});
        militaryStatus.setBounds(300, 190, 400, 30);
        militaryStatus.setBackground(Color.WHITE);
        add(militaryStatus);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        incomeCat = new JComboBox(new String[] {"null", "< $30000", "< $50000" , "< $100000", "> $100000"});
        incomeCat.setBounds(300, 240, 400, 30);
        incomeCat.setBackground(Color.WHITE);
        add(incomeCat);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        eduCat = new JComboBox(new String[] {"High School Diploma", "Associate's Degree", "Bachelor's Degree" , "Master's Degree", "Post-Doctoral", "Other"});
        eduCat.setBackground(Color.WHITE);
        eduCat.setBounds(300, 290, 400, 30);
        add(eduCat);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        occCat = new JComboBox(new String[] {"Salaried", "Self Employed", "Business" , "Student", "Retired", "Other"});
        occCat.setBackground(Color.WHITE);
        occCat.setBounds(300, 340, 400, 30);
        add(occCat);

        JLabel address = new JLabel("SSN:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 390, 200, 30);
        add(address);

        ssnTextfield = new JPasswordField();
        ssnTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        ssnTextfield.setBounds(300, 390, 400, 30);
        add(ssnTextfield);

        JLabel cstatus = new JLabel("Citizenship status:");
        cstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        cstatus.setBounds(100, 440, 200, 30);
        add(cstatus);

        citCat = new JComboBox(new String[] {"Citizen", "Permanent Resident", "H1B" , "Student", "Other"});
        citCat.setBackground(Color.WHITE);
        citCat.setBounds(300, 440, 200, 30);
        add(citCat);

        JLabel accountStatus = new JLabel("Existing Account:");
        accountStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        accountStatus.setBounds(100, 490, 200, 30);
        add(accountStatus);

        yes = new JRadioButton("Yes");
        yes.setBounds(300, 490, 80, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(400, 490, 80, 30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(yes);
        accountGroup.add(no);


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
        String thisfornnumber = formnumber;
        String pethinicity = (String) ethnicityComboBox.getSelectedItem();
        String pmstatus = (String) militaryStatus.getSelectedItem();
        String income = (String) incomeCat.getSelectedItem();
        String education = (String) eduCat.getSelectedItem();
        String occupation = (String) occCat.getSelectedItem();
        String ssn = ssnTextfield.getText();
        String cstatus = (String) citCat.getSelectedItem();
        String exaccount = null;
        if (yes.isSelected()) {
            exaccount = "Yes";
        }
        else if (no.isSelected()) {
            exaccount = "No";
        }

        try {
            if (ssn.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+thisfornnumber+"', '" +pethinicity+"', '"+pmstatus+"', '"
                        +income+"', '"+education+"', '"+occupation+"', '"+ssn+"', '"+cstatus+"', '"+exaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(thisfornnumber).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void main(
            String[] args) {
        new SignupTwo("");

    }

}

