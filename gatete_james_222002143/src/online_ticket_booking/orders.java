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
import java.sql.SQLException;

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

public class orders {

	JFrame frame;
	private JTextField bookingID;
	private JTextField fullname;
	private JTextField phone;
	private JTextField idnumber;
	private JTextField email;
	private JTextField agencyID;
	private JTextField amount;
	private JTextField location;
	private JTextField destination;
	private JTextField bookingdate;
	private JTextField busStation;
	private JTextField datenow;
	private JTextField status;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orders window = new orders();
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
	public orders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
        table.setBounds(10, 464, 840, 21);
        frame.getContentPane().add(table);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(45, 500, 1200, 120);
        frame.getContentPane().add(scrollPane);
        
        JButton retrieveBtn = new JButton("Retrieve Data");
        retrieveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retrieveData1();
            }
        });
        retrieveBtn.setBackground(new Color(0, 150, 50));
        retrieveBtn.setForeground(Color.WHITE); 
        retrieveBtn.setBounds(50, 630, 200, 30);
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
//                    dispose();
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

		
		JLabel lblNewLabel = new JLabel("BOOKINGS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("times new roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 0, 521, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel bookingid = new JLabel("bookingID");
		bookingid.setFont(new Font("Tahoma", Font.BOLD, 15));
		bookingid.setBounds(10, 61, 141, 28);  // Adjust the bounds to align with the JTextField
		frame.getContentPane().add(bookingid);

		
		JLabel fulb = new JLabel("fullname");
		fulb.setFont(new Font("Tahoma", Font.BOLD, 15));
		fulb.setBounds(10, 106, 141, 28);
		frame.getContentPane().add(fulb);
		
		JLabel pholb = new JLabel("phone");
		pholb.setFont(new Font("Tahoma", Font.BOLD, 15));
		pholb.setBounds(10, 136, 141, 28);
		frame.getContentPane().add(pholb);
		
		JLabel idnulb = new JLabel("idnumber");
		idnulb.setFont(new Font("Tahoma", Font.BOLD, 15));
		idnulb.setBounds(10, 165, 141, 28);
		frame.getContentPane().add(idnulb);
		
		JLabel emalb = new JLabel("email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 15));
		emalb.setBounds(10, 195, 141, 28);
		frame.getContentPane().add(emalb);
		
		JLabel agenlb = new JLabel("agencyID");
		agenlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		agenlb.setBounds(10, 224, 141, 28);
		frame.getContentPane().add(agenlb);
		
		JLabel amolb = new JLabel("amount");
		amolb.setFont(new Font("Tahoma", Font.BOLD, 15));
		amolb.setBounds(10, 253, 141, 28);
		frame.getContentPane().add(amolb);
		
		JLabel lolb = new JLabel("location");
		lolb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lolb.setBounds(10, 282, 141, 28);
		frame.getContentPane().add(lolb);
		
		JLabel destlb = new JLabel("destination");
		destlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		destlb.setBounds(10, 312, 141, 28);
		frame.getContentPane().add(destlb);
		
		JLabel bdlb = new JLabel("bookingDate");
		bdlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		bdlb.setBounds(10, 344, 141, 28);
		frame.getContentPane().add(bdlb);
		
		JLabel bslb = new JLabel("busStation");
		bslb.setFont(new Font("Tahoma", Font.BOLD, 15));
		bslb.setBounds(10, 374, 141, 28);
		frame.getContentPane().add(bslb);
		
		JLabel dnlb = new JLabel("dateNow");
		dnlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		dnlb.setBounds(10, 402, 141, 28);
		frame.getContentPane().add(dnlb);
		
		JLabel stalb = new JLabel("status");
		stalb.setFont(new Font("Tahoma", Font.BOLD, 15));
		stalb.setBounds(10, 431, 141, 28);
		frame.getContentPane().add(stalb);
		
		JButton insertbtn = new JButton("INSERT");
		insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fullname = orders.this.fullname.getText();
                String phone = orders.this.phone.getText();
                String idnumber = orders.this.idnumber.getText();
                String email = orders.this.email.getText();
                String agencyID = orders.this.agencyID.getText();
                String amount = orders.this.amount.getText();
                String location = orders.this.location.getText();
                String destination = orders.this.destination.getText();
                String bookingdate = orders.this.bookingdate.getText();
                String busStation = orders.this.busStation.getText();
                String datenow = orders.this.datenow.getText();
                String status = orders.this.status.getText();

                String msg = "" + fullname;
                msg += " \n";

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143")) {
                    String query = "INSERT INTO booking (bookingID,fullname, phone, idnumber, email, agencyID, amount, location, destination, bookingdate, busStation, datenow, status) " +
                                   "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)";

                    try (PreparedStatement sta = connection.prepareStatement(query)) {
                    	sta.setInt(1, Integer.parseInt(bookingID.getText()));
                        sta.setString(2, fullname);
                        sta.setString(3, phone);
                        sta.setString(4, idnumber);
                        sta.setString(5, email);
                        sta.setString(6, agencyID);
                        sta.setString(7, amount);
                        sta.setString(8, location);
                        sta.setString(9, destination);
                        sta.setString(10, bookingdate);
                        sta.setString(11, busStation);
                        sta.setString(12, datenow);
                        sta.setString(13, status);
        
                        int x = sta.executeUpdate();

                        if (x == 0) {
                            JOptionPane.showMessageDialog(insertbtn, "This is already exist");
                        } else {
                            JOptionPane.showMessageDialog(insertbtn,
                                                          "Welcome, " + msg + "Your account is successfully created");
                        }
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
		insertbtn.setBackground(new Color(0, 0, 50));
		insertbtn.setForeground(Color.WHITE);
		insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		insertbtn.setBounds(800, 20, 125, 44);
		frame.getContentPane().add(insertbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "UPDATE booking SET fullname=?, phone=?, idnumber=?, email=?, agencyID=?, amount=?, location=?, destination=?,bookingdate=?, busStation=?, datenow=?, status=?  WHERE bookingID=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, fullname.getText());
		                stm.setString(2, phone.getText());
		                stm.setString(3, idnumber.getText());
		                stm.setString(4, email.getText());
		                stm.setString(5, agencyID.getText());
		                stm.setString(6, amount.getText());
		                stm.setString(7, location.getText());
		                stm.setString(8, destination.getText());
		                stm.setString(9, bookingdate.getText());
		                stm.setString(10, busStation.getText());
		                stm.setString(11, datenow.getText());
		                stm.setString(12, status.getText());
		                stm.setInt(13, Integer.parseInt(bookingID.getText()));
		                int rowsAffected = stm.executeUpdate(); // Execute the update

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(Updatebtn, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(Updatebtn, "No record found with the given bookingID.");
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
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Updatebtn.setBounds(900, 20, 125, 44);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {   
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

		            con.setAutoCommit(true); // Set auto-commit to true

		            String sql = "DELETE FROM booking WHERE bookingID = ?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setInt(1, Integer.parseInt(bookingID.getText()));
		                
		                int rowsAffected = stm.executeUpdate(); // Execute the update

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(Deletebtn, "Record deleted successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(Deletebtn, "No record found with the given bookingID.");
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
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(1000, 20, 125, 44);
		frame.getContentPane().add(Deletebtn);
		
		bookingID = new JTextField();
		bookingID.setColumns(10);
		bookingID.setBounds(197, 66, 325, 20);  // Adjust the bounds according to your layout
		frame.getContentPane().add(bookingID);

		
		fullname = new JTextField();
		fullname.setColumns(10);
		fullname.setBounds(197, 112, 325, 20);
		frame.getContentPane().add(fullname);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(197, 142, 325, 20);
		frame.getContentPane().add(phone);
		
		idnumber = new JTextField();
		idnumber.setColumns(10);
		idnumber.setBounds(197, 171, 325, 20);
		frame.getContentPane().add(idnumber);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(197, 201, 325, 20);
		frame.getContentPane().add(email);
		
		agencyID = new JTextField();
		agencyID.setColumns(10);
		agencyID.setBounds(197, 230, 325, 20);
		frame.getContentPane().add(agencyID);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(197, 259, 325, 20);
		frame.getContentPane().add(amount);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(197, 288, 325, 20);
		frame.getContentPane().add(location);
		
		destination = new JTextField();
		destination.setColumns(10);
		destination.setBounds(197, 318, 325, 20);
		frame.getContentPane().add(destination);
		
		bookingdate = new JTextField();
		bookingdate.setColumns(10);
		bookingdate.setBounds(197, 347, 325, 20);
		frame.getContentPane().add(bookingdate);
		
		busStation = new JTextField();
		busStation.setColumns(10);
		busStation.setBounds(197, 378, 325, 20);
		frame.getContentPane().add(busStation);
		
		datenow = new JTextField();
		datenow.setColumns(10);
		datenow.setBounds(197, 405, 325, 20);
		frame.getContentPane().add(datenow);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(197, 437, 325, 20);
		frame.getContentPane().add(status);
	}

	private void retrieveData1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gatete_james_o_t_b", "222002143", "222002143");

            String sql = "SELECT * FROM Booking";
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery(); // Execute the query

                // Create a table model and populate it with the data from the ResultSet
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("bookingID");
                model.addColumn("fullname");
                model.addColumn("phone");
                model.addColumn("id number");
                model.addColumn("email");
                model.addColumn("agencyID");
                model.addColumn("amount");
                model.addColumn("location");
                model.addColumn("destination");
                model.addColumn("bookingDate");
                model.addColumn("busStation");
                model.addColumn("dateNow");
                model.addColumn("status");

                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("bookingID"),
                            rs.getString("fullname"),
                            rs.getString("phone"),
                            rs.getString("idnumber"),
                            rs.getString("email"),
                            rs.getInt("agencyID"),
                            rs.getString("amount"),
                            rs.getString("location"),
                            rs.getString("destination"),
                            rs.getString("bookingDate"),
                            rs.getString("busStation"),
                            rs.getString("dateNow"),
                            rs.getString("status")
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
