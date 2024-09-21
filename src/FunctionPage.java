import javax.swing.*; 
import java.awt.*;
public class FunctionPage extends JFrame 
{
  JLabel MENU,background,logofield;;
  JButton app,staffs,avail_staffs,back_button;
  public FunctionPage()
  {
    MENU = new JLabel();
    app =  new JButton();
    staffs = new JButton();
    avail_staffs =  new JButton();
    back_button = new JButton("⬅");
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\bg.jpeg"); 
    background = new JLabel(backgroundImage);
    ImageIcon logo = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\Wellness (1).png"); 
    logofield = new JLabel(new ImageIcon(logo.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
    
    setLayout(null);
    setSize(1000,600);
    setVisible(true);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MENU");
    setLocationRelativeTo(null);
    

    logofield.setBounds(20, 70, 350, 350); 
    add(logofield);

    MENU.setFont(new java.awt.Font("Segoe UI", 1, 24));
    MENU.setForeground(Color.BLACK);
    MENU.setText("MENU");
    MENU.setBounds(660,0,200,100);
    add(MENU);

    back_button.setForeground(Color.BLACK);
    back_button.setBounds(10, 10, 50, 50);
    back_button.setBackground(new java.awt.Color(255, 255, 255));
    back_button.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          backActionPerformed(evt);
      }
    });
    add(back_button);

    
    app.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    app.setText("APPOINTMENTS");
    app.setForeground(Color.BLACK);
    app.setBackground(new java.awt.Color(255, 255, 255));
    app.setBounds(600, 250, 200, 60);
    app.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          appActionPerformed(evt);
      }
  });
    add(app);

    staffs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    staffs.setText("EDIT STAFFS");
    staffs.setForeground(Color.BLACK);
    staffs.setBackground(new java.awt.Color(255, 255, 255));
    staffs.setBounds(600, 100, 200, 60);
    staffs.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        staffsActionPerformed(evt);
      }
  });
    add(staffs);

    avail_staffs.setFont(new java.awt.Font("Segoe UI", 1, 14));
    avail_staffs.setText(" AVAILABLE STAFFS");
    avail_staffs.setForeground(Color.BLACK);
    avail_staffs.setBackground(new java.awt.Color(255, 255, 255));
    avail_staffs.setBounds(600, 400, 200, 60);
    avail_staffs.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        avail_staffsActionPerformed(evt);
      }
  });
    add(avail_staffs);
    
    background.setBounds(0, 0, 1000, 600);
    add(background);
  }
  private void appActionPerformed(java.awt.event.ActionEvent evt)
  {
	new Appointments();
    this.dispose();
  } 

  private void staffsActionPerformed(java.awt.event.ActionEvent evt)
  {
    new View_Staffs();
    this.dispose();
  } 
  private void  avail_staffsActionPerformed(java.awt.event.ActionEvent evt)
  {
    new Avail_Staffs();
    this.dispose();
  } 
  private void backActionPerformed(java.awt.event.ActionEvent evt) 
  {
    this.dispose();
    new IntroPage();
  }
  public static void main(String args[])
  {
	  new FunctionPage();
  }
}
