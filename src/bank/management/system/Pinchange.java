package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pinField, repinField;
    String pin;

    Pinchange(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New Pin: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pinField = new JPasswordField();
        pinField.setFont(new Font("Raleway", Font.BOLD, 25));
        pinField.setBounds(330, 320, 180, 25);
        image.add(pinField);

        JLabel repintext = new JLabel("Re-enter New Pin: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repinField = new JPasswordField();
        repinField.setFont(new Font("Raleway", Font.BOLD, 25));
        repinField.setBounds(330, 360, 180, 25);
        image.add(repinField);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change)
        {
            try {
                String npin = pinField.getText();
                String rpin = repinField.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
                    return;
                }

                if (npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the New PIN");
                    return;
                }

                if (rpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Re-enter the New PIN");
                    return;
                }

                Conn c1 = new Conn();
                String query = "update bank set pin = '" + npin + "' where pin = '" + pin + "'";
                String query2 = "update login set pin = '" + npin + "' where pin = '" + pin + "'";
                String query3 = "update signupthree set pin = '" + npin + "' where pin = '" + pin + "'";

                c1.s.executeUpdate(query);
                c1.s.executeUpdate(query2);
                c1.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Transaction(npin).setVisible(true);

            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
        else {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
}
