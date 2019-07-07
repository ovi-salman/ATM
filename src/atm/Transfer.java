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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Transfer extends JFrame implements ActionListener{
    
    String AtmCardNo;
    
    Transfer(String AtmCardNo)
    {
        super("Transfer");
        this.AtmCardNo= AtmCardNo;
      
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan); 
        addComponent();
    }
    
    JLabel labelAccounttNo;
    JTextField textFieldNoAcc;
    JTextField textFieldNoAmt;
    JButton btnEnter;
    
    void addComponent()
    {
       labelAccounttNo = new JLabel("Give an account Number:");
       labelAccounttNo.setBounds(50, 50, 180, 20);
       this.add(labelAccounttNo);
       textFieldNoAcc = new JTextField();
       textFieldNoAcc.setBounds(250, 50, 80, 20);
       this.add(textFieldNoAcc);
       textFieldNoAmt = new JTextField();
       textFieldNoAmt.setBounds(250, 120, 80, 20);
       this.add(textFieldNoAmt);
       
       btnEnter = new JButton();
       btnEnter.setBounds(250, 180, 80, 20);
       this.add(btnEnter);
       btnEnter.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String thisLine;
        
        ArrayList<String> al = new ArrayList<String>();
        try {

            //File read
            BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
            while ((thisLine = br.readLine()) != null) {   //read a line form Documents

                al.add(thisLine);

                String[] parts = thisLine.split(" ");  //Split a line

                if (AtmCardNo.equals(parts[0])) //Checking user input to the line parsts 0
                {

                    int myCuttentBalance = Integer.parseInt(parts[4]);
                    int transferBalance = Integer.parseInt(textFieldNoAmt.getText());
                    
                    if(myCuttentBalance>transferBalance){

                    int totalBalance = myCuttentBalance - transferBalance;
                    
                    thisLine = thisLine.replaceFirst(parts[4], Integer.toString(totalBalance));

                    if (al.size() > 0) {
                        al.remove(al.size() - 1);
                    }
                    al.add(thisLine);

                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date date = new Date();
                    String currentDate = dateFormat.format(date);
                    
                    BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/atm/101.txt", true));
                    bw1.write(textFieldNoAcc.getText() + " +" + textFieldNoAmt.getText() + " "
                            + Integer.toString(totalBalance) + " " + currentDate);
                    bw1.newLine();

                    bw1.flush();

                }
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Check the Account Number");
                     break;
                }
            

            BufferedWriter bw2 = new BufferedWriter(new FileWriter("src/atm/atmUsers.txt"));

            for (String str : al) {
                bw2.write(str);
                bw2.newLine();
            }
            bw2.close();
        }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
            

        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
