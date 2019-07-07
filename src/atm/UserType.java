
package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;






public class UserType extends JFrame implements ActionListener{
    
    UserType()
    {
        super("User");
        this.setLayout(null);
        this.setSize(450, 350);
        this.setLocation(780, 260);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.cyan);
        addComponent();
        
        
    }
    
    JButton userBtn;
    JButton adminBtn;
    
    
    
    void addComponent(){
    
    userBtn = new JButton("USER");
    userBtn.setBounds(130, 250, 80, 30);
    this.add(userBtn);
    adminBtn = new JButton("adminBtn");
    adminBtn.setBounds(70, 250, 20, 30);
    this.add(adminBtn);
    
    userBtn.addActionListener(this);
    adminBtn.addActionListener(this);
   
}
  

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource()== userBtn )
        {
           dispose();
           Atm atm = new Atm();
           atm.setVisible(true);
           
        }
        else if(adminBtn == e.getSource())
        {
            dispose();
            AtmAdmin atmAdmin = new AtmAdmin();
            atmAdmin.setVisible(true);   
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
