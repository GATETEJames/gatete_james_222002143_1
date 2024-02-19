package online_ticket_booking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Agency {

    JFrame frame;
    private JTextField agencyidtxf;
    private JTextField agencyntxf;
    private JTextField ematxf;
    private JTextField photxf;
    private JTextField lotxf;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Agency window = new Agency();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Agency() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 20, 876, 604);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        table = new JTable();
        table.setBounds(10, 464, 840, 21);
        frame.getContentPane().add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 333, 840, 120);
        frame.getContentPane().add(scrollPane);

        JButton retrieveBtn = new JButton("Retrieve Data");
        retrieveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveData1();
            }
        });
        retrieveBtn.setBackground(new Color(0, 150, 50));
        retrieveBtn.setForeground(Color.WHITE); 
        retrieveBtn.setBounds(10, 464, 200, 30);
        frame.getContentPane().add(retrieveBtn);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        JMenuItem bus = new JMenuItem("bus");
        menu.add(bus);

        JMenuItem agency = new JMenuItem("agency");
        menu.add(agency);

        JMenuItem booking = new JMenuItem("booking");
        menu.add(booking);

        JMenuItem logout = new JMenuItem("logout");
        menu.add(logout);

        bus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Bus busFrame = new Bus();
                busFrame.frame.setVisible(true);
            }
        });

        agency.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Agency agencyFrame = new Agency();
                agencyFrame.frame.setVisible(true);
            }
        });

        booking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                orders bookingFrame = new orders();
                bookingFrame.frame.setVisible(true);
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    LoginForm obj = new LoginForm();
                    // obj.setTitle("Student-Login");
                    obj.setVisible(true);
                    frame.dispose();
                }
//                dispose();
//                LoginForm obj = new LoginForm();
//
//               // obj.setTitle("Student-Login");
//                obj.setVisible(true);

            }
        });

        JLabel lblNewLabel = new JLabel("AGENCY");
        lblNewLabel.setForeground(new Color(0, 0, 50));
        lblNewLabel.setFont(new Font("Times new roman", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(94, 0, 539, 42);
        frame.getContentPane().add(lblNewLabel);

        JLabel agencylb = new JLabel("agencyID");
        agencylb.setFont(new Font("Tahoma", Font.BOLD, 17));
        agencylb.setBounds(10, 103, 182, 29);
        frame.getContentPane().add(agencylb);

        JLabel agenlb = new JLabel("AgencyName");
        agenlb.setFont(new Font("Tahoma", Font.BOLD, 17));
        agenlb.setBounds(10, 148, 182, 29);
        frame.getContentPane().add(agenlb);

        JLabel emalb = new JLabel("email");
        emalb.setFont(new Font("Tahoma", Font.BOLD, 17));
        emalb.setBounds(10, 198, 182, 29);
        frame.getContentPane().add(emalb);

        JLabel pholb = new JLabel("phone");
        pholb.setFont(new Font("Tahoma", Font.BOLD, 17));
        pholb.setBounds(10, 246, 182, 29);
        frame.getContentPane().add(pholb);

        JLabel lolb = new JLabel("location");
        lolb.setFont(new Font("Tahoma", Font.BOLD, 17));
        lolb.setBounds(10, 292, 182, 29);
        frame.getContentPane().add(lolb);

        JButton Insertbtn = new JButton("INSERT");
        Insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "INSERT INTO agency VALUES(?,?,?,?,?)";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setInt(1, Integer.parseInt(agencyidtxf.getText()));
                        stm.setString(2, agencyntxf.getText());
                        stm.setString(3, ematxf.getText());
                        stm.setString(4, photxf.getText());
                        stm.setString(5, lotxf.getText());

                        stm.executeUpdate(); // Execute the update

                        JOptionPane.showMessageDialog(Insertbtn, "Data inserted successfully!");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Insertbtn, "An error occurred. Please check the console for details.");
                }
            }
        });


        Insertbtn.setBackground(new Color(0, 0, 50));
        Insertbtn.setForeground(Color.WHITE);
        Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Insertbtn.setBounds(470, 10, 122, 42);
        frame.getContentPane().add(Insertbtn);


        JButton Updatebtn = new JButton("UPDATE");
        Updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "UPDATE agency SET AgencyName=?, email=?, phone=?, location=? WHERE agencyID=?";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setString(1, agencyntxf.getText());
                        stm.setString(2, ematxf.getText());
                        stm.setString(3, photxf.getText());
                        stm.setString(4, lotxf.getText());
                        stm.setInt(5, Integer.parseInt(agencyidtxf.getText()));

                        int rowsAffected = stm.executeUpdate(); // Execute the update

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(Updatebtn, "Record updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(Updatebtn, "No record found with the given agencyID.");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Updatebtn, "An error occurred. Please check the console for details.");
                }
            }
        });

        Updatebtn.setBackground(new Color(0, 0, 50));
        Updatebtn.setForeground(Color.WHITE);
        Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Updatebtn.setBounds(600, 10, 122, 42);
        frame.getContentPane().add(Updatebtn);

        JButton Deletebtn = new JButton("DELETE");
        Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

                    con.setAutoCommit(true); // Set auto-commit to true

                    String sql = "DELETE FROM agency WHERE agencyID = ?";
                    try (PreparedStatement stm = con.prepareStatement(sql)) {
                        stm.setInt(1, Integer.parseInt(agencyidtxf.getText()));

                        int rowsAffected = stm.executeUpdate(); // Execute the update

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(Deletebtn, "Record deleted successfully!");
                        } else {
                            JOptionPane.showMessageDialog(Deletebtn, "No record found with the given agencyID.");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(Deletebtn, "An error occurred. Please check the console for details.");
                }
            }
        });

        Deletebtn.setBackground(new Color(0, 0, 50));
        Deletebtn.setForeground(Color.WHITE);
        Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 17));
        Deletebtn.setBounds(725, 10, 122, 42);
        frame.getContentPane().add(Deletebtn);

        agencyidtxf = new JTextField();
        agencyidtxf.setBounds(253, 105, 330, 29);
        frame.getContentPane().add(agencyidtxf);
        agencyidtxf.setColumns(10);

        agencyntxf = new JTextField();
        agencyntxf.setColumns(10);
        agencyntxf.setBounds(253, 148, 330, 29);
        frame.getContentPane().add(agencyntxf);

        ematxf = new JTextField();
        ematxf.setColumns(10);
        ematxf.setBounds(253, 198, 330, 29);
        frame.getContentPane().add(ematxf);

        photxf = new JTextField();
        photxf.setColumns(10);
        photxf.setBounds(253, 246, 330, 29);
        frame.getContentPane().add(photxf);

        lotxf = new JTextField();
        lotxf.setColumns(10);
        lotxf.setBounds(253, 292, 330, 29);
        frame.getContentPane().add(lotxf);
    }

    private void retrieveData1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

            String sql = "SELECT * FROM agency";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery(); // Execute the query

                // Create a table model and populate it with the data from the ResultSet
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Agency ID");
                model.addColumn("Agency Name");
                model.addColumn("Email");
                model.addColumn("Phone");
                model.addColumn("Location");

                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("agencyID"),
                            rs.getString("AgencyName"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("location")
                    });
                }

                // Set the model to the JTable
                table.setModel(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An error occurred while retrieving data. Please check the console for details.");
        }
    }

    protected void retrieveData() {
        // TODO Auto-generated method stub

    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub

    }

    public void dispose() {
        // TODO Auto-generated method stub

    }

}
