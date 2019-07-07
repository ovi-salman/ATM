package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    BalanceEnquiry()
    {
        super("Balance Enquiry");
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan); 
        addComponent();
    }
    
    JLabel labelCurrentBalance;
    JTextField textShowBalance;
    
    void addComponent()
    {
       labelCurrentBalance = new JLabel("Your Current Balance :");
       labelCurrentBalance.setBounds(80, 150, 180, 20);
       this.add(labelCurrentBalance);
       textShowBalance = new JTextField();
       textShowBalance.setBounds(220, 150, 80, 30);
       this.add(textShowBalance);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
