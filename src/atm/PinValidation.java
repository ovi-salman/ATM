package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 



public class PinValidation extends JFrame implements ActionListener {
    
    private String AtmCardNo;
    
    
    PinValidation(String AtmCardNo)
    {
        super("Pin Validation");
        this.AtmCardNo=AtmCardNo;
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan);
        addComponent();
    }
    
    JLabel labelPinNo;
    JLabel labelNo;
    JPasswordField textFieldPinNo;
    JButton btnEnter;
    
    void addComponent ()
    {
        //add Label
        labelPinNo = new JLabel("Please Enter your PIN Number");
        labelPinNo.setBounds(140, 10, 180, 30);
        this.add(labelPinNo);
        labelNo = new JLabel("Pin No :");
        labelNo.setBounds(120, 80, 80, 30);
        this.add(labelNo);
        
        //add TextField
        textFieldPinNo = new JPasswordField();
        textFieldPinNo.setBounds(180, 80, 120, 30);
        this.add(textFieldPinNo);
        //add Button
        btnEnter = new JButton("Enter");
        btnEnter.setBounds(180, 150, 80, 30);
        this.add(btnEnter);
        btnEnter.addActionListener(this);
        
        
    }
    
    String thisLine;
    boolean istrue=false;
    @Override
    public void actionPerformed(ActionEvent e) {
       
    try {
            //File read
		BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
			while ((thisLine = br.readLine()) != null) {   //read a line form Documents
				String[] parts = thisLine.split(" ");  //Split a line   
				if (AtmCardNo.equals(parts[0]) && textFieldPinNo.getText().equals(parts[1]))  //Checking user input to the line parsts 0
                                {
					
                                        
                                        JOptionPane.showMessageDialog(null, "Succesfully Login");
                                        dispose();
                                        Transaction transaction = new Transaction(AtmCardNo);
                                        transaction.setVisible(true);
                                        istrue=true;
                                        
                                }
                                else if (istrue=false)
                                    JOptionPane.showMessageDialog(null, "Wrong Pin");
				}
				br.close();
			}
    
    
    catch (Exception exception) {
	exception.printStackTrace();
			}
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
