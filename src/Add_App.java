import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add_App extends JFrame {
    private JLabel nameLabel, doctorLabel, dateLabel, timeLabel,typeLabel;
    private JTextField nameField, dateField, timeField;
    private JComboBox<String> doctorComboBox,typeComboBox;
    private JButton submitButton,back_button;
    private Color darkBlue = new Color(24, 44, 97);

    public Add_App() {
    	
        setTitle("Patient Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        nameLabel = new JLabel("Patient Name:");
        doctorLabel = new JLabel("Doctor:");
        dateLabel = new JLabel("Date:");
        timeLabel = new JLabel("Time: ");
        typeLabel = new JLabel("Appointment Type:  ");

        nameField = new JTextField(20);
        String[] doctors = {
                "Dr. Rajashweri (Pediatrician)",
                "Dr. Andrews Peter (Orthopedic S)",
                "Dr. Hari Sundar (Oncologist)",
                "Dr. James Smith (Cardiologist)",
            };
        doctorComboBox = new JComboBox<>(doctors);
        dateField = new JTextField(50);
        timeField = new JTextField(50);
        String[] types = {"General Checkup", "Specialist Consultation", "Procedure", "Other"};
        typeComboBox = new JComboBox<>(types);

        submitButton = new JButton("Submit");
        submitButton.setBackground(darkBlue);
        submitButton.setForeground(Color.WHITE);
        back_button = new JButton("Back");
        back_button.setBackground(darkBlue);
        back_button.setForeground(Color.WHITE);
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String doctor = (String) doctorComboBox.getSelectedItem();
                String date = dateField.getText();
                String time = timeField.getText();
                String type = (String) typeComboBox.getSelectedItem();

                saveToDatabase(name,doctor,date,time,type);

                nameField.setText("");
                dateField.setText("");
                timeField.setText("");
            }
        });
        
        back_button.addActionListener(new ActionListener() 
        {
          public void actionPerformed(java.awt.event.ActionEvent evt) 
          {
              backActionPerformed(evt);
          }
        });
        
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(doctorLabel);
        panel.add(doctorComboBox);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(typeLabel);
        panel.add(typeComboBox);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(submitButton);
        panel.add(back_button);

        add(panel);
    	setVisible(true);
    }

    private void saveToDatabase(String name, String doctor, String date, String time,String type) {
        String url = "jdbc:mysql://localhost:3306/microproject";
        String username = "root";
        String password = "jacob";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
        	String id = null;
            String query = "SELECT patient_id FROM patients WHERE patient_name = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
        	
            if (rs.next()) {
                id = rs.getString("patient_id"); 
            }
            String query2 = "INSERT INTO appointments (patient_name, doctor, date, time,patientID, app_type) VALUES (?, ?, ?, ?,?, ?)";
            PreparedStatement statement = conn.prepareStatement(query2);
            statement.setString(1, name);
            statement.setString(2, doctor);
            statement.setString(3, date);
            statement.setString(4, time);
            statement.setString(5,id);
            statement.setString(6, type);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data saved successfully!");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to save data to database!");
        }
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) 
    {
      this.dispose();
      new Appointments();
    }
    public static void main(String[] args) {
        new Add_App();
    }
}
