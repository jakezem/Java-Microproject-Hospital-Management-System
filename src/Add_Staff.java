import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Add_Staff extends JFrame 
{
	 private JLabel idLabel, nameLabel, positionLabel, ageLabel, sexLabel,spezLabel;
	 private JTextField idField, nameField, positionField, ageField, sexField,spezField;
	 private JButton submitButton,back_button;
	 private Color darkBlue = new Color(24, 44, 97);
	 public Add_Staff()
	 {
	        setTitle("Staff Registration Form");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        idLabel = new JLabel("Staff ID:");
	        nameLabel = new JLabel("Staff Name:");
	        positionLabel = new JLabel("Staff Position:");
	        ageLabel = new JLabel("Age:");
	        sexLabel = new JLabel("Sex:");
	        spezLabel = new JLabel("Specialization(if doctor):");

	        idField = new JTextField(20);
	        nameField = new JTextField(20);
	        positionField = new JTextField(20);
	        ageField = new JTextField(50);
	        sexField = new JTextField(50);
	        spezField = new JTextField(50);

	        submitButton = new JButton("Submit");
	        submitButton.setBackground(darkBlue);
	        submitButton.setForeground(Color.WHITE);
	        back_button = new JButton("Back");
	        back_button.setBackground(darkBlue);
	        back_button.setForeground(Color.WHITE);
	        
	        submitButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String id = idField.getText();
	                String name = nameField.getText();
	                String position = positionField.getText();
	                String age = ageField.getText();
	                String sex = sexField.getText();
	                String spez = spezField.getText();

	                saveToDatabase(id, name, position, age, sex,spez);

	                idField.setText("");
	                nameField.setText("");
	                positionField.setText("");
	                ageField.setText("");
	                sexField.setText("");
	                spezField.setText("");
	            }
	        });
	        back_button.addActionListener(new ActionListener() 
	        {
	          public void actionPerformed(java.awt.event.ActionEvent evt) 
	          {
	              backActionPerformed(evt);
	          }
	        });
	        
	        JPanel panel = new JPanel(new GridLayout(8, 2));
	        panel.add(idLabel);
	        panel.add(idField);
	        panel.add(nameLabel);
	        panel.add(nameField);
	        panel.add(positionLabel);
	        panel.add(positionField);
	        panel.add(ageLabel);
	        panel.add(ageField);
	        panel.add(sexLabel);
	        panel.add(sexField);
	        panel.add(spezLabel);
	        panel.add(spezField);
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(submitButton);
	        panel.add(back_button);

	        add(panel);
	    	setVisible(true);
	 }
	    private void saveToDatabase(String id, String name, String position, String age, String sex,String spez) {
	        String url = "jdbc:mysql://localhost:3306/microproject";
	        String username = "root";
	        String password = "jacob";

	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	        	if(position.equals("Doctor")) {
	        		String query1 = "INSERT INTO staffs (staff_id, staff_name, staff_position, age, sex) VALUES (?, ?, ?, ?, ?)";
	        		String query2 = "INSERT INTO doctor (staff_id,doctor_name,specialization) VALUES (?,?,?)" ;
	        		String query3 = "INSERT INTO doctors_available (staff_id,doctor_name,specialization) VALUES (?,?,?)" ;
		            PreparedStatement statement1 = conn.prepareStatement(query1);
		            statement1.setString(1, id);
		            statement1.setString(2, name);
		            statement1.setString(3, position);
		            statement1.setString(4, age);
		            statement1.setString(5, sex);
		            
		            PreparedStatement statement2 = conn.prepareStatement(query2);
		            statement2.setString(1, id);
		            statement2.setString(2, name);
		            statement2.setString(3, spez);
		            
		            PreparedStatement statement3 = conn.prepareStatement(query3);
		            statement3.setString(1, id);
		            statement3.setString(2, name);
		            statement3.setString(3, spez);


		            int rowsInserted1 = statement1.executeUpdate();
		            int rowsInserted2 = statement2.executeUpdate();
		            statement3.executeUpdate();
		            if (rowsInserted1 > 0 && rowsInserted2 > 0) {
		                JOptionPane.showMessageDialog(null, "Data saved successfully!");
		            }
	        	}
	        	else 
	        	{
	            String query = "INSERT INTO staffs (staff_id, staff_name, staff_position, age, sex) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, id);
	            statement.setString(2, name);
	            statement.setString(3, position);
	            statement.setString(4, age);
	            statement.setString(5, sex);

	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "Data saved successfully!");
	            }
	        	}
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: Failed to save data to database!");
	        }
	    }
	    private void backActionPerformed(java.awt.event.ActionEvent evt) 
	    {
	    	this.dispose();
	    	new View_Staffs();
	    }
	    public static void main(String[] args) {
	    	new Add_Staff();
	    }
}
