import java.awt.*;
import javax.swing.*;
public class IntroPage extends JFrame
{   
  JLabel welcare_hospital,logofield,background;
  JLabel Welcome;
  JButton PLogin;
  JButton Slogin;
  
  
  public IntroPage()
  {
    Welcome = new JLabel();
    welcare_hospital = new JLabel();
    PLogin = new JButton();
    Slogin = new JButton();
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\bg.jpeg"); 
    background = new JLabel(backgroundImage);
    ImageIcon logo = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\Wellness (1).png"); 
    logofield = new JLabel(new ImageIcon(logo.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
    
    setVisible(true);
    setLayout(null);
    setSize(1000,600);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("WELCARE HOSPITAL");
    setLocationRelativeTo(null);
    logofield.setBounds(20, 50, 350, 350); 
    add(logofield);
    
    
    Welcome.setFont(new java.awt.Font("Segoe UI", 1, 24));
    Welcome.setForeground(Color.BLACK);
    Welcome.setText("WELCOME");
    Welcome.setBounds(660,110,200,200);
    add(Welcome);

    welcare_hospital.setFont(new java.awt.Font("Segoe UI Historic", 1, 36));
    welcare_hospital.setForeground(Color.BLACK);
    welcare_hospital.setText("WELCARE HOSPITAL");
    welcare_hospital.setBounds(550,10,700,200);
    add(welcare_hospital);

    PLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    PLogin.setText("PATIENT LOGIN");
    PLogin.setForeground(Color.BLACK);
    PLogin.setBackground(new java.awt.Color(255, 255, 255));
    PLogin.setBounds(640, 250, 170, 100);
    add(PLogin);
    PLogin.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          PLoginActionPerformed(evt);
      }
    });
    Slogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Slogin.setText("STAFF LOGIN");
    Slogin.setForeground(Color.BLACK);
    Slogin.setBackground(new java.awt.Color(255, 255, 255));
    Slogin.setBounds(650, 400, 150, 100);
    add(Slogin);
    Slogin.addActionListener(new java.awt.event.ActionListener() 
    {
        public void actionPerformed(java.awt.event.ActionEvent evt) 
        {
            SloginActionPerformed(evt);
        }
    });
    
    background.setBounds(0, 0, 1000, 600);
    add(background);
  }
  private void PLoginActionPerformed(java.awt.event.ActionEvent evt) 
  {     
	new PatientLoginPage();
    this.dispose();
  }                                      
  private void SloginActionPerformed(java.awt.event.ActionEvent evt) 
  {                                       
    LoginAdmin LoginAdminFrame=new LoginAdmin();
    LoginAdminFrame.setVisible(true);
    LoginAdminFrame.pack();
    LoginAdminFrame.setLocationRelativeTo(null);
    this.dispose();
  }      
  public static void main(String args[])
  {
	  new IntroPage();
  }
}
