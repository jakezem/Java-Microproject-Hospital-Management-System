import javax.swing.*; 
import java.awt.*;
public class Avail_Staffs extends JFrame 
{
  JButton doct_avail,mark_leave,back_button,on_leave;
  JLabel background;
  Avail_Staffs()
  {
    setLayout(null);
    setVisible(true);
    setSize(1000,600);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("AVAILABLE STAFFS");
    setLocationRelativeTo(null);
    
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\bg.jpeg"); 
    background = new JLabel(backgroundImage);
    
    doct_avail = new JButton();
    mark_leave = new JButton();
    on_leave = new JButton();
    back_button = new JButton("⬅");

    doct_avail.setFont(new java.awt.Font("Segoe UI", 1, 14));
    doct_avail.setText("DOCTORS AVAILABLE");
    doct_avail.setForeground(Color.BLACK);
    doct_avail.setBackground(new java.awt.Color(255, 255, 255));
    doct_avail.setBounds(100, 200, 200, 80);
    doct_avail.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          doctavailActionPerformed(evt);
      }
    });
    add(doct_avail);

    mark_leave.setFont(new java.awt.Font("Segoe UI", 1, 14));
    mark_leave.setText("MARK LEAVE");
    mark_leave.setForeground(Color.BLACK);
    mark_leave.setBackground(new java.awt.Color(255, 255, 255));
    mark_leave.setBounds(400, 200, 200, 80);
    mark_leave.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          markleaveActionPerformed(evt);
      }
    });
    add(mark_leave);
    
    on_leave.setFont(new java.awt.Font("Segoe UI", 1, 14));
    on_leave.setText("VIEW STAFFS ON LEAVE");
    on_leave.setForeground(Color.BLACK);
    on_leave.setBackground(new java.awt.Color(255, 255, 255));
    on_leave.setBounds(700, 200, 230, 80);
    on_leave.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          onleaveActionPerformed(evt);
      }
    });
    add(on_leave);


    back_button.setBackground(new java.awt.Color(255, 255, 255));
    back_button.setForeground(Color.BLACK);
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
    setVisible(false);
     new FunctionPage();
  }
  private void onleaveActionPerformed(java.awt.event.ActionEvent evt) 
  {
    setVisible(false);
    new On_Leave();
    
  }
  private void markleaveActionPerformed(java.awt.event.ActionEvent evt) 
  {
    setVisible(false);
    new Mark_Leave();
    
  }
  private void doctavailActionPerformed(java.awt.event.ActionEvent evt) 
  {
    setVisible(false);
    new Doctors_Available();
    
  }
}
