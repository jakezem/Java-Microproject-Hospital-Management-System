import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remove_Staff extends JFrame
{
	private JLabel idLabel, nameLabel;
	private JTextField idField, nameField;
	private JButton submitButton,back_button;
	private Color darkBlue = new Color(24, 44, 97);
	
	public Remove_Staff()
	{

        setTitle("Remove Staff");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        idLabel = new JLabel("Staff ID:");
        nameLabel = new JLabel("Staff Name:");
        
        idField = new JTextField(20);
        nameField = new JTextField(20);
        
        submitButton = new JButton("Delete");
        submitButton.setBackground(darkBlue);
        submitButton.setForeground(Color.WHITE);
        back_button = new JButton("Back");
        back_button.setBackground(darkBlue);
        back_button.setForeground(Color.WHITE);
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                
                saveToDatabase(id, name);
                
                idField.setText("");
                nameField.setText("");
            }
        });
        
        back_button.addActionListener(new ActionListener() 
        {
          public void actionPerformed(java.awt.event.ActionEvent evt) 
          {
              backActionPerformed(evt);
          }
        });
        
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(submitButton);
        panel.add(back_button);
        add(panel);
		setVisible(true);
        
	}
	
	 private void saveToDatabase(String id, String name)
	 {
		 String url = "jdbc:mysql://localhost:3306/microproject";
	     String username = "root";
	     String password = "jacob";

	     try (Connection conn = DriverManager.getConnection(url, username, password)) 
	     {
	    	 String query = "DELETE FROM staffs WHERE staff_id = ? AND  staff_name = ?";
	    	 String query2 = "DELETE FROM doctor WHERE staff_id = ? AND  doctor_name = ?";
	    	 String query3 = "DELETE FROM doctors_available WHERE staff_id = ? AND  doctor_name = ?";
	    	 PreparedStatement statement = conn.prepareStatement(query);
	         statement.setString(1, id);
	         statement.setString(2, name);
	         
	    	 PreparedStatement statement2 = conn.prepareStatement(query2);
	         statement2.setString(1, id);
	         statement2.setString(2, name);
	         
	    	 PreparedStatement statement3 = conn.prepareStatement(query3);
	         statement3.setString(1, id);
	         statement3.setString(2, name);
	         int rowsDeleted2 = statement2.executeUpdate();
	         int rowsDeleted = statement.executeUpdate();
	         statement3.executeUpdate();
	            if (rowsDeleted> 0) 
	            {
	                JOptionPane.showMessageDialog(null, "Staff removed successfully!");
	            }
	     }
	     catch (SQLException ex) 
	     {
	         ex.printStackTrace();
	         JOptionPane.showMessageDialog(null, "Error: Failed to delete data from database!");
	     }
	 }
	  private void backActionPerformed(java.awt.event.ActionEvent evt) 
	  {
	    this.dispose();
	    new View_Staffs();
	  }
	   public static void main(String[] args) 
	   {
	        new Remove_Staff();
	   }
}