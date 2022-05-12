import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
public class studreg {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	  DefaultTableModel model;
	  ResultSet rs;
	  private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studreg window = new studreg();
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
	public studreg() {
		initialize();
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		load();
	}
	
	public void load() {
		int a=1 ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
	      //  Statement st=con.createStatement();
	    	PreparedStatement p=con.prepareStatement("select * from registration");
	    	ResultSet rs=p.executeQuery();
	    	model=(DefaultTableModel)table.getModel();
	    	model.setRowCount(0);
	    	while(rs.next()) {
	    		Vector<String> v2=new Vector<String>();
	    	      for (int i = 1; i <= a; i++) {
	                    v2.add(rs.getString("name"));
	                    v2.add(rs.getString("student_id"));
	                    v2.add(rs.getString("graduate"));
	                    v2.add(rs.getString("department"));
	                    v2.add(rs.getString("mobile"));
	                   
	                }
	                model.addRow(v2);
	               
	            }

			}
						 catch (Exception ex) {
				ex.printStackTrace();
						 }
		
	
}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\laptop files\\venkatesh\\new phone all images\\Camera\\IMG_20200926_145645.jpg"));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 925, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 11, 656, 444);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {                                    
	        model = (DefaultTableModel) table.getModel();
	        int selected = table.getSelectedRow();
	        textField.setText(model.getValueAt(selected, 0).toString());
	        textField_1.setText(model.getValueAt(selected, 1).toString());
	         textField_2.setText(model.getValueAt(selected, 2).toString());
	         textField_3.setText(model.getValueAt(selected, 3).toString());
	         textField_4.setText(model.getValueAt(selected, 4).toString());
	        load();
	    }
	    });
		table.setBackground(new Color(211, 211, 211));
	    model=new DefaultTableModel();
	    Object[] column= {"Student_Name", "Student_Id", "Graduate", "Department", "Mobile No."};
	    Object[] row=new Object[8];
	    model.setColumnIdentifiers(column);
	    table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("Student Registration Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 213, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 61, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Id:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 115, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Graduate:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 170, 73, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 225, 97, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 280, 86, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(120, 59, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 113, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 168, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(108, 223, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 278, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("(EX: ST***)\r\n");
		lblNewLabel_6.setBounds(188, 116, 65, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("(UG/PG)");
		lblNewLabel_7.setBounds(189, 171, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
			      
			    	PreparedStatement p=con.prepareStatement("insert into registration values(?,?,?,?,?)");
			    	p.setString(1,textField.getText());
			    	p.setString(2,textField_1.getText());
			    	p.setString(3,textField_2.getText());
			    	p.setString(4,textField_3.getText());
			    	p.setString(5,textField_4.getText());
			    	p.executeUpdate();
			    	JOptionPane.showMessageDialog(null, "Register Successfull");
			
					}
								 catch (Exception ex) {
						ex.printStackTrace();
								 }
				row[0]=textField.getText();
				row[1]=textField_1.getText();
				row[2]=textField_2.getText();
				row[3]=textField_3.getText();
				row[4]=textField_4.getText();
				model.addRow(row);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(63, 328, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
	    btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    try {
			    	Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
			      
			    	PreparedStatement p=con.prepareStatement("update registration set name=(?) ,graduate=(?) ,department=(?) ,mobile=(?) where student_id=(?)");
			    	p.setString(1,textField.getText());
			    	p.setString(2,textField_2.getText());
			    	p.setString(3,textField_3.getText());
			    	p.setString(4,textField_4.getText());
			    	p.setString(5,textField_1.getText());
			    	p.executeUpdate();
			    	JOptionPane.showMessageDialog(null, "student Record Updated Successfully");
			    }
			    catch (Exception ex) {
					ex.printStackTrace();
							 }
			    row[0]=textField.getText();
				row[1]=textField_1.getText();
				row[2]=textField_2.getText();
				row[3]=textField_3.getText();
				row[4]=textField_4.getText();
				model.addRow(row);
			}
		}); 
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 372, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
			      
			    	PreparedStatement p=con.prepareStatement("delete from registration where student_id=(?)");
			    	p.setString(1,textField_1.getText());
			    	p.executeUpdate();
			    	JOptionPane.showMessageDialog(null, "student Record Deleted Successfully");
			
					}
								 catch (Exception ex) {
						ex.printStackTrace();
								 }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(105, 372, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("Student Details");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_8.setBounds(595, 17, 118, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(63, 413, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

	
}
