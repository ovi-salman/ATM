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


public class PinChange extends JFrame implements ActionListener{
    
    private String AtmCardNo;
    
     
    PinChange(String AtmCardNo)
    {
        super("PIN Change");
        this.AtmCardNo =AtmCardNo;
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan);
        addComponent();
    }
    
    JLabel labelName;
    JLabel labelCurrentPin;
    JTextField textFieldPin;
    JLabel labelNewPin;
    JTextField textFieldNewPin;
    JLabel labelConfirmPin;
    JTextField textFieldConfirmPin;
    JButton btnSave;
    JButton btnBack;
    
    void addComponent()
    {
        labelName = new JLabel("Change your Pin");
        labelName.setBounds(170, 20, 160, 80);
        this.add(labelName);
        labelCurrentPin = new JLabel("Current Pin :");
        labelCurrentPin.setBounds(120, 100, 120, 20);
        this.add(labelCurrentPin);
        textFieldPin = new JTextField();
        textFieldPin.setBounds(240, 100, 80, 20);
        this.add(textFieldPin);
        labelNewPin = new JLabel("New Pin : ");
        labelNewPin.setBounds(120, 150, 120, 20);
        this.add(labelNewPin);
        textFieldNewPin = new JTextField();
        textFieldNewPin.setBounds(240, 150, 80, 20);
        this.add(textFieldNewPin);
        labelConfirmPin = new JLabel("Confirm New Pin:");
        labelConfirmPin.setBounds(120, 200, 160, 20);
        this.add(labelConfirmPin);
        textFieldConfirmPin = new JTextField();
        textFieldConfirmPin.setBounds(240, 200, 80, 20);
        this.add(textFieldConfirmPin);
        btnSave = new JButton("Save");
        btnSave.setBounds(130, 250, 80, 30);
        this.add(btnSave);
        btnSave.addActionListener(this);
        btnBack = new JButton("Back");
        btnBack.setBounds(240, 250, 80, 30);
        this.add(btnBack);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String thisLine;
        if(ae.getSource()==btnSave){
        ArrayList<String> al = new ArrayList<String>();
        try {

            //File read
            BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
            while ((thisLine = br.readLine()) != null) {   //read a line form Documents

                al.add(thisLine);

                String[] parts = thisLine.split(" ");  //Split a line

                if (AtmCardNo.equals(parts[0])) //Checking user input to the line parsts 0
                {

                   
                    thisLine = thisLine.replaceFirst(parts[1],textFieldNewPin.getText() );

                    if (al.size() > 0) {
                        al.remove(al.size() - 1);
                    }
                    al.add(thisLine);

                    

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
    
}
