package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Mini extends JFrame {
    String pin;

    Mini(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Bank Management System");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);


        try {
            Conn c1 = new Conn();
            int bal = 0;
            String q1 = "select * from login where pin = '" + pin + "'";
            ResultSet rs = c1.s.executeQuery(q1);
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardno").substring(0,4)
                        + "XXXXXXXX" + rs.getString("cardno").substring(12));
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is $" + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c2 = new Conn();
            ResultSet rs = c2.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while(rs.next()) {
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        text.setBounds(20, 140, 400, 200);

        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Mini("").setVisible(true);
    }
}
