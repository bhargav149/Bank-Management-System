package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String pin;
    Deposit(String pin) {

        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 320, 25);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 280, 30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String amountValue = amount.getText();
            Date date = new Date();
            if (amountValue.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            } else {
                try{
                    Conn c1 = new Conn();
                    String query = "Insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amountValue + "')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$" + amountValue + " Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
}
