import javax.swing.*; 
public class SignUp extends JFrame 
{
  JLabel Email;
  JLabel Fullname;
  JPanel Left;
  JLabel Password;
  JPanel Right;
  JLabel SIGNUP;
  JButton alreadyAccount;
  JTextField email;
  JTextField fullname;
  JPanel jPanel2;
  JPasswordField jPasswordField2;
  JButton signup;
  public SignUp()
  {
    jPanel2 = new javax.swing.JPanel();
    Right = new javax.swing.JPanel();
    SIGNUP = new javax.swing.JLabel();
    Fullname = new javax.swing.JLabel();
    Password = new javax.swing.JLabel();
    jPasswordField2 = new javax.swing.JPasswordField();
    signup = new javax.swing.JButton();
    alreadyAccount = new javax.swing.JButton();
    Email = new javax.swing.JLabel();
    fullname = new javax.swing.JTextField();
    email = new javax.swing.JTextField();
    Left = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("SIGNUP");
    setPreferredSize(new java.awt.Dimension(800, 520));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
    jPanel2.setLayout(null);

    Right.setBackground(new java.awt.Color(255, 255, 255));
    Right.setMinimumSize(new java.awt.Dimension(400, 500));

    SIGNUP.setBackground(new java.awt.Color(51, 0, 153));
    SIGNUP.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
    SIGNUP.setForeground(new java.awt.Color(0, 51, 102));
    SIGNUP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    SIGNUP.setText("SIGNUP");

    Fullname.setBackground(new java.awt.Color(0, 0, 0));
    Fullname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Fullname.setText("Fullname");

    Password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Password.setText("Password");

    signup.setBackground(new java.awt.Color(51, 0, 153));
    signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    signup.setForeground(new java.awt.Color(255, 255, 255));
    signup.setText("SIGNUP");
    signup.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            signupActionPerformed(evt);
        }
    });

    alreadyAccount.setBackground(new java.awt.Color(204, 204, 204));
    alreadyAccount.setText("ALREADY HAVE AN ACCOUNT ?  LOGIN");
    alreadyAccount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            alreadyAccountActionPerformed(evt);
        }
    });

    Email.setBackground(new java.awt.Color(0, 0, 0));
    Email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    Email.setText("Email");

    email.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            emailActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
    Right.setLayout(RightLayout);
    RightLayout.setHorizontalGroup(
        RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(RightLayout.createSequentialGroup()
            .addGap(77, 77, 77)
            .addComponent(alreadyAccount)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(RightLayout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGroup(RightLayout.createSequentialGroup()
                    .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RightLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(RightLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SIGNUP, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    RightLayout.setVerticalGroup(
        RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(RightLayout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addComponent(SIGNUP)
            .addGap(51, 51, 51)
            .addComponent(Fullname)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Email)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Password)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(41, 41, 41)
            .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
            .addComponent(alreadyAccount)
            .addGap(32, 32, 32))
    );

    jPanel2.add(Right);
    Right.setBounds(400, 0, 400, 500);

    Left.setBackground(new java.awt.Color(51, 0, 153));
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

    jPanel2.add(Left);
    Left.setBounds(0, 0, 400, 500);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }
  private void signupActionPerformed(java.awt.event.ActionEvent evt) {                                       

}                                      

private void alreadyAccountActionPerformed(java.awt.event.ActionEvent evt) {                                               
    Login LoginFrame=new Login();
    LoginFrame.setVisible(true);
    LoginFrame.pack();
    LoginFrame.setLocationRelativeTo(null);
    this.dispose();
}                                              

private void emailActionPerformed(java.awt.event.ActionEvent evt) {                                      
}                                     

}
