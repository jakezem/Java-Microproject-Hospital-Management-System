import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;

public class Mark_Leave extends JFrame{
	 private JLabel idLabel, nameLabel, startLabel,endLabel;
	 private JTextField idField, nameField,startField,endField;
	 private JButton submitButton,back_button;
	 private JDateChooser startdate,enddate;
	 private Color darkBlue = new Color(24, 44, 97);
	 public Mark_Leave()
	 {
	        setTitle("Leave Form");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        idLabel = new JLabel("Staff ID:");
	        nameLabel = new JLabel("Staff Name:");
	        startLabel = new JLabel("From:");
	        endLabel = new JLabel("Till:");
	        startdate = new JDateChooser();
	        enddate = new JDateChooser();
	        
	        idField = new JTextField(20);
	        nameField = new JTextField(20);
	        
	        
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
	                String start = ((JTextField) startdate.getDateEditor().getUiComponent()).getText();
	                String end = ((JTextField) enddate.getDateEditor().getUiComponent()).getText();

	                saveToDatabase(id, name,start,end);

	                idField.setText("");
	                nameField.setText("");
	                startdate.setDate(null);
	                enddate.setDate(null);
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
	        panel.add(startLabel);
	        panel.add(startdate);
	        panel.add(endLabel);
	        panel.add(enddate);
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(new JLabel());
	        panel.add(submitButton);
	        panel.add(back_button);

	        add(panel);
	    	setVisible(true);
	 }
	    private void saveToDatabase(String id, String name, String start, String end) {
	        String url = "jdbc:mysql://localhost:3306/microproject";
	        String username = "root";
	        String password = "jacob";
	        
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            String query1 = "INSERT INTO on_leave ( staff_id, staff_name, startdate, enddate) VALUES (?, ?, ?, ?)";
	            String query2 = "DELETE FROM  doctors_available WHERE staff_id = ? OR doctor_name = ? ";
	            PreparedStatement statement1 = conn.prepareStatement(query1);
	            statement1.setString(1, id);
	            statement1.setString(2, name);
	            statement1.setString(3, start);
	            statement1.setString(4, end);
	            
	            PreparedStatement statement2 = conn.prepareStatement(query2);
	            statement2.setString(1, id);
	            statement2.setString(2, name);
	            
	            int rowsInserted = statement1.executeUpdate();
	            int rowsInserted2 = statement2.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "Leave Applied Successfully");
	            }
	            statement2.executeUpdate();
	        
	        }
	        catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error!");
	        }
	    }
	    private void backActionPerformed(java.awt.event.ActionEvent evt) 
	    {
	    	this.dispose();
	    	new Avail_Staffs();
	    }
	    public static void main(String[] args) {
	    	new Mark_Leave();
	    }
	    
}



