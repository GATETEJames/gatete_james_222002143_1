package online_ticket_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField phone;
    private JTextField address;
    private JPasswordField password;
    private JTextField role;
    private JButton btnNewButton;
    private JButton btnNewButtona;
	protected Window frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 20, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Register here");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setForeground(new Color(40, 0, 50)); 
        lblNewUserRegister.setBounds(362, 52, 225, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lbllastname = new JLabel("Last Name");
        lbllastname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbllastname.setBounds(58, 243, 110, 29);
        contentPane.add(lbllastname);

        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(58, 324, 124, 36);
        contentPane.add(lblemail);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(58, 400, 110, 29);
        contentPane.add(lblphone);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstname.setBounds(214, 151, 228, 30);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lastname.setBounds(214, 235, 228, 30);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(214, 320, 228, 30);
        contentPane.add(email);
        email.setColumns(10);
        
        address = new JTextField();
        address.setFont(new Font("Tahoma", Font.PLAIN, 20));
        address.setBounds(214, 400, 228, 30);
        contentPane.add(address);
        address.setColumns(10);


        JLabel lbladdress = new JLabel("Addres");
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbladdress.setBounds(542, 151, 99, 29);
        contentPane.add(lbladdress);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblpassword.setBounds(542, 243, 99, 29);
        contentPane.add(lblpassword);

        JLabel lblrole = new JLabel("Role");
        lblrole.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblrole.setBounds(542, 324, 99, 24);
        contentPane.add(lblrole);

        
        
        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        phone.setBounds(707, 151, 228, 30);
        contentPane.add(phone);
        phone.setColumns(10);
        
        password = new JPasswordField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 20));
        password.setBounds(707, 240, 228, 30);
        contentPane.add(password);
        password.setColumns(10);

        role = new JTextField();
        role.setFont(new Font("Tahoma", Font.PLAIN, 20));
        role.setBounds(707, 324, 228, 30);
        contentPane.add(role);
        role.setColumns(10);


        
        firstname.setBackground(Color.white);
        lastname.setBackground(Color.white);
        email.setBackground(Color.white);
        phone.setBackground(Color.white);
        address.setBackground(Color.white);
        password.setBackground(Color.white);
        role.setBackground(Color.white);



     // ... (existing code)
        btnNewButtona = new JButton("Already have an account");
        btnNewButtona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
              
            
                 LoginForm bookingFrame = new LoginForm(); 
                 bookingFrame.frame.setVisible(true); 
            	 dispose(); 
                
           
            	

            }
        });
        btnNewButtona.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButtona.setBounds(600, 480, 259, 54);
        btnNewButtona.setBackground(new Color(0, 150, 50));
        btnNewButtona.setForeground(Color.WHITE); 
        contentPane.add(btnNewButtona);

        btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstname = UserRegistration.this.firstname.getText();
                String lastname = UserRegistration.this.lastname.getText();
                String email = UserRegistration.this.email.getText();
                String phone = UserRegistration.this.phone.getText();
                String address = UserRegistration.this.address.getText();
                char[] passwordChars = UserRegistration.this.password.getPassword();
                String password = new String(passwordChars);
                String role = UserRegistration.this.role.getText();

                String msg = "" + firstname;
                msg += " \n";

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143")) {
                    String query = "INSERT INTO user (firstname, lastname, email, phone, address, password, role) " +
                                   "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement sta = connection.prepareStatement(query)) {
                        sta.setString(1, firstname);
                        sta.setString(2, lastname);
                        sta.setString(3, email);
                        sta.setString(4, phone);
                        sta.setString(5, address);
                        sta.setString(6, password);
                        sta.setString(7, role);

                        int x = sta.executeUpdate();

                        if (x == 0) {
                        	frame.dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                        } else {
                            JOptionPane.showMessageDialog(btnNewButton,
                                                          "Welcome, " + msg + "Your account is successfully created");
                           
                        }
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
        // ... (existing code)

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(350, 480, 159, 54);
        btnNewButton.setBackground(new Color(0, 0, 50));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);
    }
}

