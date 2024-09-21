import java.awt.*;
import javax.swing.*; 
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class App_View extends JFrame 
{
  JTable table;
  JButton back_button;
  App_View()
  {
    setLayout(null);
    setVisible(true);
    setSize(1000,700);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("APPOINTMENTS SCHEDULE");
    setLocationRelativeTo(null);
    
    back_button = new JButton("⬅");
    
    table = new JTable();
	String url = "jdbc:mysql://localhost:3306/microproject";
    String username = "root";
    String password = "jacob";

    try(Connection conn = DriverManager.getConnection(url, username, password))
    {
    	String query = "select * from appointments ";
    	Statement statement = conn.createStatement();
    	ResultSet rs = statement.executeQuery(query);
    	table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (Exception e){
      e.printStackTrace();
    }
    
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(100,100,700,600);
    add(jsp);
    
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

  }
  private void backActionPerformed(java.awt.event.ActionEvent evt) 
  {
    this.dispose();
    new Appointments();
  }
  public static void main(String args[])
  {
	  new App_View();
  }

}