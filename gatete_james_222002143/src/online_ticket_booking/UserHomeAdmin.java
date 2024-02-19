package online_ticket_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserHomeAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	protected Object frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHomeAdmin frame = new UserHomeAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHomeAdmin() {

    }

    /**
     * Create the frame.
     */
    public UserHomeAdmin(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 190, 814, 497);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Logout");
        JButton btnNewButtonH = new JButton("Continue");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    LoginForm obj = new LoginForm();
                  //  obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                LoginForm obj = new LoginForm();

               // obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        
        btnNewButtonH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
              
            
                 Bus busFrame = new Bus(); 
                 busFrame.frame.setVisible(true); 
            	 dispose(); 
                
           

            }
        });
        btnNewButton.setBounds(247, 160, 291, 64);
        btnNewButton.setBackground(new Color(0, 150, 50));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);
        
        btnNewButtonH.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButtonH.setBounds(247, 60, 291, 64);
        btnNewButtonH.setBackground(new Color(0, 0, 50));
        btnNewButtonH.setForeground(Color.WHITE); 
        contentPane.add(btnNewButtonH);
        
        JButton button = new JButton("Change-password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button.setBackground(new Color(0, 0, 50));
        button.setForeground(Color.WHITE); 
        button.setBounds(247, 260, 291, 64);
        contentPane.add(button);
        
    }
}
