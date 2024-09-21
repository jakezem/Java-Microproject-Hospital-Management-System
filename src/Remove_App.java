import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remove_App extends JFrame
{
	private JLabel idLabel, appnoLabel;
	private JTextField idField, appnoField;
	private JButton submitButton,back_button;
	private Color darkBlue = new Color(24, 44, 97);
	
	public Remove_App()
	{

        setTitle("Remove Patients");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        idLabel = new JLabel("Patient ID:");
        appnoLabel = new JLabel("Appointment Number:");
        
        idField = new JTextField(20);
        appnoField = new JTextField(20);
        
        submitButton = new JButton("Delete");
        submitButton.setBackground(darkBlue);
        submitButton.setForeground(Color.WHITE);
        back_button = new JButton("Back");
        back_button.setBackground(darkBlue);
        back_button.setForeground(Color.WHITE);
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = appnoField.getText();
                
                saveToDatabase(id, name);
                
                idField.setText("");
                appnoField.setText("");
            }
        });
        
        back_button.addActionListener(new ActionListener() 
        {
          public void actionPerformed(java.awt.event.ActionEvent evt) 
          {
              backActionPerformed(evt);
          }
        });
        
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(appnoLabel);
        panel.add(appnoField);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(submitButton);
        panel.add(back_button);
        add(panel);
		setVisible(true);
        
	}
	
	 private void saveToDatabase(String id, String appno)
	 {
		 String url = "jdbc:mysql://localhost:3306/microproject";
	     String username = "root";
	     String password = "jacob";

	     try (Connection conn = DriverManager.getConnection(url, username, password)) 
	     {
	    	 String query = "DELETE FROM appointments WHERE patientID = ? AND  App_No = ?";
	    	 PreparedStatement statement = conn.prepareStatement(query);
	         statement.setString(1, id);
	         statement.setString(2, appno);
	         
	         int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted> 0) 
	            {
	                JOptionPane.showMessageDialog(null, "Patient removed successfully!");
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
	    new Appointments();
	  }
	    public static void main(String[] args) {
	        new Remove_App();
	    }
}