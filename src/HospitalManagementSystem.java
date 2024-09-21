import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PatientLoginPage();
        });
    }
}

class PatientLoginPage extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private Color darkBlue = new Color(24, 44, 97);

    public PatientLoginPage() {
        setTitle("WELCARE HOSPITAL - Patient Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        loginPanel.setBackground(Color.WHITE);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(darkBlue);
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(darkBlue);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(darkBlue);
        loginButton.setForeground(Color.WHITE);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);
        signUpButton.setBackground(darkBlue);
        signUpButton.setForeground(Color.WHITE);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); 
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); 
        loginPanel.add(signUpButton);

        getContentPane().setBackground(darkBlue);
        add(loginPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
         String usernamelg = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (e.getActionCommand().equals("Login")) {
            if (isValidLogin(usernamelg , password)) {
                dispose();
                new PatientDashboardAfterLogin(usernamelg );
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Sign Up")) {
            dispose(); // Close the login page
            new SignUpForm().setVisible(true); 
        }
    }

    private boolean isValidLogin(String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/microproject"; // Change to your database URL
        String dbUser = "root"; // Your database username
        String dbPassword = "jacob"; // Your database password
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Establish a connection
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            // Prepare a query to check if the username and password exist
            String query = "SELECT * FROM patients WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            // Check if a record exists with the given username and password
            if (rs.next()) {
                return true; // User found, login is valid
            } else {
                return false; // No matching user found
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

class SignUpForm extends JFrame implements ActionListener {

    private JTextField fullNameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField contactField;
    private JTextField addressField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private Color darkBlue = new Color(24, 44, 97);

    public SignUpForm() {
    	setVisible(true);
        setTitle("Patient Sign Up");
        setSize(400, 250); // Reduced height to fit fewer components
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        

        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameLabel.setForeground(darkBlue);
        fullNameField = new JTextField(20);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setForeground(darkBlue);
        ageField = new JTextField(20);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(darkBlue);
        genderField = new JTextField(20);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setForeground(darkBlue);
        contactField = new JTextField(20);
        contactField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (contactField.getText().length() >= 10 || !Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(darkBlue);
        addressField = new JTextField(20);
        
        JPanel signUpPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        signUpPanel.setBackground(Color.WHITE);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(darkBlue);
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(darkBlue);
        passwordField = new JPasswordField(20);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(darkBlue);
        confirmPasswordField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);
        signUpButton.setBackground(darkBlue);
        signUpButton.setForeground(Color.WHITE);

        signUpPanel.add(fullNameLabel);
        signUpPanel.add(fullNameField);
        signUpPanel.add(ageLabel);
        signUpPanel.add(ageField);
        signUpPanel.add(genderLabel);
        signUpPanel.add(genderField);
        signUpPanel.add(contactLabel);
        signUpPanel.add(contactField);
        signUpPanel.add(addressLabel);
        signUpPanel.add(addressField);
        signUpPanel.add(usernameLabel);
        signUpPanel.add(usernameField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);
        signUpPanel.add(confirmPasswordLabel);
        signUpPanel.add(confirmPasswordField);
        signUpPanel.add(new JLabel());
        signUpPanel.add(signUpButton);

        getContentPane().setBackground(darkBlue);
        add(signUpPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sign Up")) {
        	String fullname = fullNameField.getText();
        	String age = ageField.getText();
        	String gender = genderField.getText();
        	String contact  = contactField.getText();
        	String address = addressField.getText();
            String usernamesp = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	saveToDatabase(fullname,age,gender,contact,address,usernamesp, password);
            }
        }
    }
	 private void saveToDatabase(String fullname,String age,String gender,String contact,String address,String usernamesp,String password)
	 {
		 String dburl = "jdbc:mysql://localhost:3306/microproject";
	     String dbusername = "root";
	     String dbpassword = "jacob";

	     try (Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword)) 
	     {
	    	 String query = "INSERT INTO patients (patient_name, age,gender,address,contact_no,username,password) VALUES (?, ?,?,?,?,?,?)";;
	    	 PreparedStatement statement = conn.prepareStatement(query);
	    	 statement.setString(1,fullname);
	         statement.setString(2, age);
	         statement.setString(3, gender);
	         statement.setString(4, contact);
	         statement.setString(5, address);
	         statement.setString(6, usernamesp);
	         statement.setString(7, password);
	         
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "Data saved successfully!");
	                dispose(); // Close the sign-up form
	                new PatientDashboardAfterLogin(usernamesp);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: Failed to save data to database!");
	        }
	     }

	 }

class PatientDashboardAfterLogin extends JFrame implements ActionListener {

    private String username;
    private Color darkBlue = new Color(24, 44, 97);

    public PatientDashboardAfterLogin(String username) {
        this.username = username;
        setTitle("Patient Dashboard ");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel dashboardPanel = new JPanel(new GridLayout(1, 3, 10, 10)); 
        dashboardPanel.setBackground(Color.WHITE);

        JButton appointmentBookingButton = createButton("Appointment Booking");
        JButton editAppointmentButton = createButton("Edit Appointment");
        JButton logoutButton = createButton("Logout");

        dashboardPanel.add(appointmentBookingButton);
        dashboardPanel.add(editAppointmentButton);
        dashboardPanel.add(logoutButton);

        getContentPane().setBackground(darkBlue);
        add(dashboardPanel);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setBackground(darkBlue);
        button.setForeground(Color.WHITE);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Appointment Booking")) {
            AppointmentBookingForm appointmentForm = new AppointmentBookingForm();
            appointmentForm.setVisible(true);
        } else if (actionCommand.equals("Edit Appointment")) {
            EditAppointmentForm editForm = new EditAppointmentForm();
            editForm.setVisible(true);
        } else if (actionCommand.equals("Logout")) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
                new PatientLoginPage().setVisible(true); 
            }
        }
    }
}

class AppointmentBookingForm extends JFrame implements ActionListener {

    private JTextField patientNameField;
    private JComboBox<String> doctorComboBox;
    private JTextField appointmentDateField;
    private JTextField appointmentTimeField;
    private JComboBox<String> typeComboBox;
    private JDateChooser appdate;
    private Color darkBlue = new Color(24, 44, 97);

    public AppointmentBookingForm() {
        setTitle("Appointment Booking");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel appointmentPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        appointmentPanel.setBackground(Color.WHITE);

        appointmentPanel.add(new JLabel("Patient Name:"));
        patientNameField = new JTextField(20);
        appointmentPanel.add(patientNameField);

        appointmentPanel.add(new JLabel("Select Doctor:"));
        String[] doctors = {
            "Dr. Rajashweri (Pediatrician)",
            "Dr. Andrews Peter (Orthopedic S)",
            "Dr. Hari Sundar (Oncologist)",
            "Dr. James Smith (Cardiologist)",
        };
        doctorComboBox = new JComboBox<>(doctors);
        appointmentPanel.add(doctorComboBox);

        appointmentPanel.add(new JLabel("Appointment Date"));
        appdate = new JDateChooser();
        appointmentPanel.add(appdate);

        appointmentPanel.add(new JLabel("Appointment Time (HH:mm):"));
        appointmentTimeField = new JTextField(20);
        appointmentPanel.add(appointmentTimeField);

        appointmentPanel.add(new JLabel("Appointment Type:"));
        String[] types = {"General Checkup", "Specialist Consultation", "Procedure", "Other"};
        typeComboBox = new JComboBox<>(types);
        appointmentPanel.add(typeComboBox);

        JButton bookButton = new JButton("Book Appointment");
        bookButton.addActionListener(this);
        bookButton.setBackground(darkBlue);
        bookButton.setForeground(Color.WHITE);

        appointmentPanel.add(new JLabel()); 
        appointmentPanel.add(bookButton);

        getContentPane().setBackground(darkBlue);
        add(appointmentPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Book Appointment")) {
            String patientName = patientNameField.getText();
            String selectedDoctor = (String) doctorComboBox.getSelectedItem();
            String date = ((JTextField) appdate.getDateEditor().getUiComponent()).getText();
            String appointmentTime = appointmentTimeField.getText();
            String appointmentType = (String) typeComboBox.getSelectedItem();
            
            saveToDatabase(patientName,selectedDoctor,date,appointmentTime,appointmentType);
            
            patientNameField.setText("");
            appdate.setDate(null);
            appointmentTimeField.setText("");
        }
    }
    private void saveToDatabase(String patientName, String selectedDoctor, String date, String appointmentTime,String appointmentType) {
        String url = "jdbc:mysql://localhost:3306/microproject";
        String username = "root";
        String password = "jacob";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
        	String id = null;
            String query = "SELECT patient_id FROM patients WHERE patient_name = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, patientName);
            rs = ps.executeQuery();
        	
            if (rs.next()) {
                id = rs.getString("patient_id"); 
            }
            
            String query2 = "INSERT INTO appointments (patient_name, doctor, date, time,patientID, app_type) VALUES (?, ?, ?, ?,?, ?)";
            PreparedStatement statement = conn.prepareStatement(query2);
            statement.setString(1, patientName);
            statement.setString(2, selectedDoctor);
            statement.setString(3, date);
            statement.setString(4, appointmentTime);
            statement.setString(5,id);
            statement.setString(6, appointmentType);
            int rowsInserted = statement.executeUpdate();
            
            String query3 = "SELECT App_No FROM appointments WHERE patientID = ? AND time = ? ";
            PreparedStatement statement2 = conn.prepareStatement(query3);
            String app = null;
            statement2.setString(1,id);
            statement2.setString(2, appointmentTime);
            ResultSet rs2 = statement2.executeQuery();
            if (rs2.next()) {
                app = rs2.getString("App_No"); 
            }
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Success ! Appoiintment No:" + app);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to save data to database!");
        }
    }
}

class EditAppointmentForm extends JFrame implements ActionListener {

	private JTextField app_noField;
    private JTextField appointmentDateField;
    private JTextField appointmentTimeField;
    private JTextField patientNameField2;
    private JComboBox<String> typeComboBox;
    private JDateChooser appdate;
    private Color darkBlue = new Color(24, 44, 97);

    public EditAppointmentForm() {
        setTitle("Edit Appointment");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel editPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        editPanel.setBackground(Color.WHITE);
        
        editPanel.add(new JLabel("Appointment Number"));
        app_noField = new JTextField(20);
        editPanel.add(app_noField);
        
        editPanel.add(new JLabel("Patient Name:"));
        patientNameField2 = new JTextField(20);
        editPanel.add(patientNameField2);

        editPanel.add(new JLabel("Appointment Date"));
        appdate = new JDateChooser();
        editPanel.add(appdate);

        editPanel.add(new JLabel("Appointment Time (HH:mm):"));
        appointmentTimeField = new JTextField(20);
        editPanel.add(appointmentTimeField);

        editPanel.add(new JLabel("Appointment Type:"));
        String[] types = {"General Checkup", "Specialist Consultation", "Procedure", "Other"};
        typeComboBox = new JComboBox<>(types);
        editPanel.add(typeComboBox);

        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(this);
        saveButton.setBackground(darkBlue);
        saveButton.setForeground(Color.WHITE);

        editPanel.add(new JLabel()); 
        editPanel.add(saveButton);

        getContentPane().setBackground(darkBlue);
        add(editPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save Changes")) {
        	String app_no = app_noField.getText();
        	String patientName2 = patientNameField2.getText();
        	String date = ((JTextField) appdate.getDateEditor().getUiComponent()).getText();
            String appointmentTime = appointmentTimeField.getText();
            String appointmentType = (String) typeComboBox.getSelectedItem();
            
            saveToDatabase(app_no,patientName2,date,appointmentTime,appointmentType);
            
            app_noField.setText("");
            appointmentDateField.setText("");
            appointmentTimeField.setText("");
            
            
        }
    }
    private void saveToDatabase(String app_no, String patientName2,String date, String appointmentTime,String appointmentType) {
        String url = "jdbc:mysql://localhost:3306/microproject";
        String username = "root";
        String password = "jacob";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE appointments SET Date = ?,Time = ?,app_type = ? WHERE App_No = ?"; 
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, date);
            statement.setString(2, appointmentTime);
            statement.setString(3, appointmentType);
            statement.setString(4, app_no);
            statement.executeUpdate();
          
            JOptionPane.showMessageDialog(null, "Appointment booked successfully!");
            
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to save data to database!");
        }
    }
}