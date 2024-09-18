package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pin;
    Fastcash(String pin) {

        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("$10");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("$20");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("$50");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("$100");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("$1000");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("$2000");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Fastcash("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        else {
            String amount = ((JButton)e.getSource()).getText().replace("$", "");
            Conn c1 = new Conn();
            try{
                ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next())
                {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$"+amount+" Debited Successfully");

                setVisible(false);
                new Transaction(pin).setVisible(true);
            } catch (Exception e1) {
                System.out.println(e1);
            }

            setVisible(false);
            new Transaction(pin).setVisible(true);
        }


    }
}
