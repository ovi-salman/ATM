package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class TransactionStatement extends JFrame {
    
    TransactionStatement()
    {
        super("Transaction Statement");
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.cyan); 
        
    }
}
    
    
    
    

    