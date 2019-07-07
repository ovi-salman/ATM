package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdrawl extends JFrame implements ActionListener{
    
    
    private String AtmCardNo;
    
    Withdrawl(String AtmCardNo)
    {
        super("Withdrawl");
        this.AtmCardNo = AtmCardNo;
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan);
        addComponent();
    }
    
    JLabel labelName;
    JLabel labelAmt;
    JTextField textFieldAmt;
    JButton btnWithdraw;
    JButton btnCancel;
    JButton btnExit;
    
    void addComponent()
    {
        labelName = new JLabel("Maximum  Withdrawl limit is : 10000 TK");
        labelName.setBounds(110, 20, 250, 20);
        this.add(labelName);
        labelAmt = new JLabel("Please Enter your amount");
        labelAmt.setBounds(150, 80, 180, 20);
        this.add(labelAmt);
        textFieldAmt = new JTextField();
        textFieldAmt.setBounds(190, 120, 80, 30);
        this.add(textFieldAmt);
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(120, 180, 100, 30);
        this.add(btnWithdraw);
        btnWithdraw.addActionListener(this);
        
       
                
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        String thisLine;
        
        System.out.println("action");
         int withdrawBalance = Integer.parseInt(textFieldAmt.getText());
         System.out.println(withdrawBalance);
         if(withdrawBalance >10000 || withdrawBalance <500)
         {
             System.out.println("in if");
             JOptionPane.showMessageDialog(null, "Invalid Input");
         }
         else if(withdrawBalance%500 != 0)
         {
             JOptionPane.showMessageDialog(null, "Enter ammount which is multiliied by 500");
         }
         else
         {
             
              ArrayList<String> al = new ArrayList<String>();
              try {

            //File read
            BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
            while ((thisLine = br.readLine()) != null) {   //read a line form Documents

                al.add(thisLine);

                String[] parts = thisLine.split(" ");  //Split a line

                if (AtmCardNo.equals(parts[0])) //Checking user input to the line parsts 0
                {

                    int cuttentBalance = Integer.parseInt(parts[4]);
                    int withdwawBalance = Integer.parseInt(textFieldAmt.getText());
                    

                    int totalBalance = cuttentBalance - withdwawBalance;
                    if(totalBalance<0)
                    {
                         JOptionPane.showMessageDialog(null, "Not enough money");
                         break;
                    }

                    thisLine = thisLine.replaceFirst(parts[4], Integer.toString(totalBalance));

                    if (al.size() > 0) {
                        al.remove(al.size() - 1);
                    }
                    al.add(thisLine);

                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date date = new Date();
                    String currentDate = dateFormat.format(date);

                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/atm/101.txt", true));
                    bw1.write(AtmCardNo + " -" + textFieldAmt.getText() + " "
                            + Integer.toString(totalBalance) + " " + currentDate);
                    bw1.newLine();

                    bw1.flush();
                    JOptionPane.showMessageDialog(null, "Thank you for using ATM");
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
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
}

