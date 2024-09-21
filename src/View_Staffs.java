
import javax.swing.*; 
import java.awt.*;
public class View_Staffs extends JFrame 
{
  JButton add_staff,remove_staff,back_button,display_staffs;
  JLabel background;
  View_Staffs()
  {
    setLayout(null);
    setVisible(true);
    setSize(1000,600);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("STAFFS");
    setLocationRelativeTo(null);
    
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\bg.jpeg"); 
    background = new JLabel(backgroundImage);

    add_staff = new JButton();
    remove_staff = new JButton();
    display_staffs = new JButton();
    back_button = new JButton("⬅");

    add_staff.setFont(new java.awt.Font("Segoe UI", 1, 14));
    add_staff.setText("ADD NEW STAFF");
    add_staff.setForeground(Color.BLACK);
    add_staff.setBackground(new java.awt.Color(255, 255, 255));
    add_staff.setBounds(100, 200, 200, 80);
    add_staff.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          addstaffActionPerformed(evt);
      }
    });
    add(add_staff);

    remove_staff.setFont(new java.awt.Font("Segoe UI", 1, 14));
    remove_staff.setText("REMOVE STAFF");
    remove_staff.setForeground(Color.BLACK);
    remove_staff.setBackground(new java.awt.Color(255, 255, 255));
    remove_staff.setBounds(400, 200, 200, 80);
    remove_staff.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          removestaffActionPerformed(evt);
      }
    });
    add(remove_staff);
    
    display_staffs.setFont(new java.awt.Font("Segoe UI", 1, 14));
    display_staffs.setText("DISPLAY STAFFS");
    display_staffs.setForeground(Color.BLACK);
    display_staffs.setBackground(new java.awt.Color(255, 255, 255));
    display_staffs.setBounds(750, 200, 200, 80);
    display_staffs.addActionListener(new java.awt.event.ActionListener() 
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
          displayActionPerformed(evt);
      }
    });
    add(display_staffs);
    
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
    setVisible(false);
     new FunctionPage();
  }
  private void displayActionPerformed(java.awt.event.ActionEvent evt) 
  {
	    setVisible(false);
	    new Display_Staff();
  }
  private void  addstaffActionPerformed(java.awt.event.ActionEvent evt) 
  {
	    setVisible(false);
	    new Add_Staff();
  }
  private void  removestaffActionPerformed(java.awt.event.ActionEvent evt)
  {
	    setVisible(false);
	    new Remove_Staff();
  }
  
}
