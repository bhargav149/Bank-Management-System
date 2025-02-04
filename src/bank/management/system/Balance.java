package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance extends JFrame implements ActionListener {

    JButton back;
    String pin;

    public Balance(String pin) {

        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn c1 = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            setSize(900, 900);
            setLocation(300, 0);
            setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is: $" + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);
    }


        public static void main(String[] args) {
        new Balance("").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
}
