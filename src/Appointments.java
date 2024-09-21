
import javax.swing.*; 
import java.awt.*;


public class Appointments extends JFrame
{
  JButton app_view,app_add,app_remove,back_button;
  JLabel background;
  Appointments()
  {
    setLayout(null);
    setVisible(true);
    setSize(1000,600);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("APPOINTMENTS");
    setLocationRelativeTo(null);
    
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\bg.jpeg"); 
    background = new JLabel(backgroundImage);

    app_view =  new JButton();
    app_add = new JButton();
    app_remove = new JButton();
    back_button = new JButton("⬅");

    app_view.setFont(new java.awt.Font("Segoe UI", 1, 14));
    app_view.setText("APPOINTMENT SCHEDULE");
    app_view.setForeground(Color.BLACK);
    app_view.setBackground(new java.awt.Color(255, 255, 255));
    app_view.setBounds(100, 200, 220, 80);
    app_view.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          appviewActionPerformed(evt);
      }
    });
    add(app_view);

    app_add.setFont(new java.awt.Font("Segoe UI", 1, 14));
    app_add.setText(" ADD APPOINTMENT ");
    app_add.setForeground(Color.BLACK);
    app_add.setBackground(new java.awt.Color(255, 255, 255));
    app_add.setBounds(400, 200, 200, 80);
    app_add.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          appaddActionPerformed(evt);
      }
    });
    add(app_add);

    app_remove.setFont(new java.awt.Font("Segoe UI", 1, 14));
    app_remove.setText("REMOVE APPOINTMENT");
    app_remove.setForeground(Color.BLACK);
    app_remove.setBackground(new java.awt.Color(255, 255, 255));
    app_remove.setBounds(700, 200, 210, 80);
    app_remove.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          appremoveActionPerformed(evt);
      }
    });
    add(app_remove);

    back_button.setText("⬅");
    back_button.setForeground(Color.BLACK);
    back_button.setBackground(new java.awt.Color(255, 255, 255));
    back_button.setBounds(10, 10, 50, 50);
    back_button.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          backActionPerformed(evt);
      }
    });
    add(back_button);
    
    background.setBounds(0, 0, 1000, 600);
    add(background);


  }
  private void backActionPerformed(java.awt.event.ActionEvent evt) 
  {
    this.dispose();
    new FunctionPage();
  }
  private void appviewActionPerformed(java.awt.event.ActionEvent evt)
  {
    this.dispose();
    new App_View();
  }
  private void appaddActionPerformed(java.awt.event.ActionEvent evt)
  {
	    new SignUpForm();
  }
  private void appremoveActionPerformed(java.awt.event.ActionEvent evt)
  {
	    this.dispose();
	    new Remove_App();
  }
  
}