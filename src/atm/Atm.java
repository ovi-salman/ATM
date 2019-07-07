package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Atm extends JFrame implements ActionListener  {
    
    //Creating Constructor 
     Atm()
    {
        super("ATM");
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan); 
        addComponent();
    }
     
     
    
    //Lebel Object Reference
    JLabel labelAtmCardNo;
    JLabel labelNo;
    //Text Field Reference
    JTextField textFieldCardNo;
    //Button Refernce
    JButton btnEnter;
    
    //adding component
    void addComponent()
    {
        //add Label
        labelAtmCardNo = new JLabel("Enter Your ATM Card number");
        labelAtmCardNo.setBounds(120, 10, 180, 30);
        this.add(labelAtmCardNo);
        labelNo = new JLabel("Card No :");
        labelNo.setBounds(120, 80, 80, 30);
        this.add(labelNo);
        
        //add TextField
        textFieldCardNo = new JTextField(); ///problem with understanding
        this.add(textFieldCardNo);
        textFieldCardNo.setBounds(180, 80, 120 , 30);
        //add Button
        btnEnter = new JButton("Enter");
        this.add(btnEnter);
        btnEnter.setBounds(180, 150 , 80, 30);
        btnEnter.addActionListener(this);
        
    }
    
    String thisLine;
    boolean istrue =false;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("In Action");
        try {
            //File read
		BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
			while ((thisLine = br.readLine()) != null) {   //read a line form Documents
				String[] parts = thisLine.split(" ");  //Split a line   
				if (textFieldCardNo.getText().equals(parts[0]))  //Checking user input to the line parsts 0
                                {
					JOptionPane.showMessageDialog(null, "Successfully");
                                        dispose(); //disposing the current gui
                                        PinValidation pinValidaion = new PinValidation(textFieldCardNo.getText()); //create new object
                                        pinValidaion.setVisible(true); // see another gui
                                        istrue=true;
                                }
                                else if (istrue=false)
                                    JOptionPane.showMessageDialog(null, "Account No is wrong, Provide Correct Account Number");
				}
				br.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			




        
    }
    
    
}
