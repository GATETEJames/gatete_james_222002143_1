package online_ticket_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserHome extends JFrame {

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
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }

    /**
     * Create the frame.
     */
    public UserHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 620, 497);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnorder = new JButton("book your ticket");
        btnorder.setForeground(new Color(0, 0, 0));
        btnorder.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnorder.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
              
            
                 ordersUser bookingFrame = new ordersUser(); 
                 bookingFrame.frame.setVisible(true); 
            	 dispose(); 
                
           
            	

            }
        });
        btnorder.setBounds(147, 160, 291, 64);
        btnorder.setBackground(new Color(0, 150, 50));
        btnorder.setForeground(Color.WHITE); 
        contentPane.add(btnorder);
        JButton btnNewButton = new JButton("Logout");
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
                   // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                LoginForm obj = new LoginForm();

               // obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(147, 60, 291, 64);
        btnNewButton.setBackground(new Color(0, 0, 50));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);
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
        button.setBounds(147, 260, 291, 64);
        contentPane.add(button);
        
    }
}
