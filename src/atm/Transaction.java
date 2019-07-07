package atm;


import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Transaction extends JFrame implements ActionListener{
    
   private String AtmCardNo;
   
   
  
   
    
    
    
    //Creating Constructor
    Transaction(String AtmCardNo)
    {
        super("TRANSACTION");
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
      JButton btnCashWithdrawl;
      JButton btnPinChange;
      JButton btnBalanceEnquiry;
      JButton btnTransfer;
      JButton btnTransactionStatement;
     
      
      void addComponent()
      {
          labelName = new JLabel("Please Select Your Transaction");
          labelName.setBounds(130, 20, 180, 20);
          this.add(labelName);
          btnCashWithdrawl = new JButton("Cash Withdrawl");
          btnCashWithdrawl.setBounds(170, 100, 140 , 20);
          this.add(btnCashWithdrawl);
          btnCashWithdrawl.addActionListener(this);
          btnPinChange = new JButton("Pin Change");
          btnPinChange.setBounds(90, 150, 130, 20);
          this.add(btnPinChange);
          btnPinChange.addActionListener(this);
          btnBalanceEnquiry = new JButton("Balance Enquiry");
          btnBalanceEnquiry.setBounds(250, 150, 140, 20);
          this.add(btnBalanceEnquiry);
          btnTransfer = new JButton("Transfer");
          btnTransfer.setBounds(90, 200, 130, 20);
          this.add(btnTransfer);
          btnTransactionStatement = new JButton("Transaction Statement");
          btnTransactionStatement.setBounds(250, 200, 170, 20);
          this.add(btnTransactionStatement);
          
           btnBalanceEnquiry.addActionListener(this);
           btnTransfer.addActionListener(this);
           btnTransactionStatement.addActionListener(this);
          
         
      }
      
      
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnCashWithdrawl )
        {
            dispose();
            Withdrawl withdrawl = new Withdrawl(AtmCardNo);
            withdrawl.setVisible(true);
        }
        else if(e.getSource() == btnPinChange )
        {
            dispose();
            PinChange pinChange = new PinChange(AtmCardNo);
            pinChange.setVisible(true);
        }
        else if(e.getSource() == btnBalanceEnquiry)
        {
            System.out.println("in action");
            String thisLine;
             try {
            //File read
		BufferedReader br = new BufferedReader(new FileReader("src/atm/atmUsers.txt"));
			while ((thisLine = br.readLine()) != null) {   //read a line form Documents
				String[] parts = thisLine.split(" ");  //Split a line   
				if(AtmCardNo.equals(parts[0]) )  //Checking user input to the line parsts 0
                                {
                                    System.out.println("in if");
                                    JOptionPane.showMessageDialog(null, "Your current balance is " +parts[4]
                                    + " Taka");
                                }
                                
				}
				br.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
            
        }
        else if(e.getSource() == btnTransfer)
        {
            dispose();
            Transfer transfer = new Transfer(AtmCardNo);
            transfer.setVisible(true);
            
        }
        else if(e.getSource() == btnTransactionStatement)
        {
            dispose();
            TransactionStatement transactionStatement = new TransactionStatement();
            transactionStatement.setVisible(true);
        }
             
        

    }
}
    
    
