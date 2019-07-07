package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    Deposit() {
        super("Deposit");
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan);
        addComponent();
    }

    JLabel labelAmmount;
    JLabel labelBalance;
    JTextField textFieldDepositAmt;
    JTextField textFieldAccountNo;
    JButton btnDeposit;

    void addComponent() {
        labelAmmount = new JLabel("Enter Amount,You want to deposit");
        labelAmmount.setBounds(130, 20, 200, 20);
        this.add(labelAmmount);
        labelBalance = new JLabel("Enter Amount,You want to deposit");
        labelBalance.setBounds(180, 50, 200, 20);
        this.add(labelBalance);

        textFieldAccountNo = new JTextField();
        textFieldAccountNo.setBounds(290, 10, 80, 30);
        this.add(textFieldAccountNo);
        textFieldDepositAmt = new JTextField();
        textFieldDepositAmt.setBounds(180, 160, 80, 30);
        this.add(textFieldDepositAmt);
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(90, 150, 120, 20);
        this.add(btnDeposit);
        btnDeposit.addActionListener(this);

    }

    String thisLine;

    @Override
    public void actionPerformed(ActionEvent ae) {

        
        ArrayList<String> al = new ArrayList<String>();
        try {

            //File read
            BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
            while ((thisLine = br.readLine()) != null) {   //read a line form Documents

                al.add(thisLine);

                String[] parts = thisLine.split(" ");  //Split a line

                if (textFieldAccountNo.getText().equals(parts[0])) //Checking user input to the line parsts 0
                {

                    int cuttentBalance = Integer.parseInt(parts[4]);
                    int depositBalance = Integer.parseInt(textFieldDepositAmt.getText());

                    int totalBalance = cuttentBalance + depositBalance;

                    thisLine = thisLine.replaceFirst(parts[4], Integer.toString(totalBalance));

                    if (al.size() > 0) {
                        al.remove(al.size() - 1);
                    }
                    al.add(thisLine);

                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date date = new Date();
                    String currentDate = dateFormat.format(date);

                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/atm/101.txt", true));
                    bw1.write(textFieldAccountNo.getText() + " +" + textFieldDepositAmt.getText() + " "
                            + Integer.toString(totalBalance) + " " + currentDate);
                    bw1.newLine();

                    bw1.flush();

                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Check the Account Number");
                     break;
                }
            }

            BufferedWriter bw2 = new BufferedWriter(new FileWriter("src/atm/atmUsers.txt"));

            for (String str : al) {
                bw2.write(str);
                bw2.newLine();
            }
            bw2.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
