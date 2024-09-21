import java.awt.Image;
import javax.swing.*; 
public class LoginAdmin extends JFrame
{
  JLabel logofield;
  JLabel LOGIN;
  JPanel Left;
  JLabel Password;
  JPanel Right;
  JLabel Username;
  JPanel jPanel1;
  JButton login;
  JPasswordField password;
  JTextField username;
  public LoginAdmin()
  {
    jPanel1 = new javax.swing.JPanel();
    Left = new javax.swing.JPanel();
    Right = new javax.swing.JPanel();
    LOGIN = new javax.swing.JLabel();
    Username = new javax.swing.JLabel();
    Password = new javax.swing.JLabel();
    username = new javax.swing.JTextField();
    password = new javax.swing.JPasswordField();
    login = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("LOGIN");
    
    ImageIcon logo = new ImageIcon("C:\\Users\\JACOP\\eclipse-workspace\\HospitalMS\\src\\icons\\Wellness (1).png"); 
    logofield = new JLabel(new ImageIcon(logo.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
    logofield.setBounds(20, 50, 350, 350); 
    add(logofield);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
    jPanel1.setLayout(null);

    Left.setBackground(new java.awt.Color(255, 255, 255));
    Left.setPreferredSize(new java.awt.Dimension(400, 500));

    javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
    Left.setLayout(LeftLayout);
    LeftLayout.setHorizontalGroup(
        LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 400, Short.MAX_VALUE)
    );
    LeftLayout.setVerticalGroup(
        LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 500, Short.MAX_VALUE)
    );

    jPanel1.add(Left);
    Left.setBounds(0, 0, 400, 500);

    Right.setBackground(new java.awt.Color(255, 255, 255));
    Right.setMinimumSize(new java.awt.Dimension(400, 500));

    LOGIN.setBackground(new java.awt.Color(51, 0, 153));
    LOGIN.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    LOGIN.setForeground(new java.awt.Color(0, 51, 102));
    LOGIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LOGIN.setText("LOGIN");

    Username.setBackground(new java.awt.Color(0, 0, 0));
    Username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Username.setText("Username");

    Password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Password.setText("Password");

    username.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            usernameActionPerformed(evt);
        }
    });

    login.setBackground(new java.awt.Color(51, 0, 153));
    login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    login.setForeground(new java.awt.Color(255, 255, 255));
    login.setText("LOGIN");
    login.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            loginActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
    Right.setLayout(RightLayout);
    RightLayout.setHorizontalGroup(
        RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(RightLayout.createSequentialGroup()
            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(RightLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(username)
                        .addComponent(password)
                        .addGroup(RightLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))))
                .addGroup(RightLayout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    ))
            .addContainerGap(38, Short.MAX_VALUE))
    );
    RightLayout.setVerticalGroup(
        RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(RightLayout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addComponent(LOGIN)
            .addGap(50, 50, 50)
            .addComponent(Username)
            .addGap(28, 28, 28)
            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(Password)
            .addGap(18, 18, 18)
            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(28, 28, 28)
            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
            .addGap(22, 22, 22))
    );

    jPanel1.add(Right);
    Right.setBounds(400, 0, 400, 500);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }
  private void usernameActionPerformed(java.awt.event.ActionEvent evt) {                                         
}                                        

    private void loginActionPerformed(java.awt.event.ActionEvent evt) 
    {
        String Uname = username.getText();
        String Pword = password.getText();
        if(Uname.equals("") && Pword.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Username and Password !");

        }
        else if(Pword.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Password !");
        }
        else if(Uname.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Username !");
        }
        else if(Uname.equals("admin") && Pword.equals("123"))
        {
            JOptionPane.showMessageDialog(this,"LOGIN SUCCESSFUL !");
            new FunctionPage();
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Credentials !");
        }

    }   
}