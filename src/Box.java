import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Box {

	private JFrame frame;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
    DefaultTableModel model;
    int x;
    int c;
    private JTextField textField_7;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Box window = new Box();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//--------------------------------------Constructor-----------------------------------
	public Box() {
		initialize();
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Total:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 363, 54, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(250, 235, 215));
		textField_7.setBounds(97, 362, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Click");
		btnNewButton_4.setBackground(new Color(250, 235, 215));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c=(Integer.parseInt(textField_2.getText())+Integer.parseInt(textField_3.getText())+Integer.parseInt(textField_4.getText())+Integer.parseInt(textField_5.getText())+Integer.parseInt(textField_6.getText()));
                textField_7.setText(c+"");
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_4.setBounds(44, 317, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.setBackground(new Color(250, 235, 215));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
		      //  Statement st=con.createStatement();
		    	PreparedStatement p=con.prepareStatement("update studentmarks set tamil=(?) ,english=(?) ,maths=(?) ,science=(?) ,social=(?) ,total=(?) where student_id=(?)");
		    	p.setString(1,textField_2.getText());
		    	p.setString(2,textField_3.getText());
		    	p.setString(3,textField_4.getText());
		    	p.setString(4,textField_5.getText());
		    	p.setString(5,textField_6.getText());
		    	p.setString(6,textField_7.getText());
		    	p.setString(7,textField_1.getText());
		    	p.executeUpdate();
		    	JOptionPane.showMessageDialog(null, "Student Marks Updated Successfully");
			}
			catch (Exception ex) {
				ex.printStackTrace();
						 }
			 
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(116, 408, 95, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		load();
	}
	
	public void load() {
		int a=7 ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
	      //  Statement st=con.createStatement();
	    	PreparedStatement p=con.prepareStatement("select * from studentmarks");
	    	ResultSet rs=p.executeQuery();
	    	model=(DefaultTableModel)table.getModel();
	    	model.setRowCount(0);
	    	while(rs.next()) {
	    		Vector<String> v2=new Vector<String>();
	    	      for (int i = 1; i <= a; i++) {
	                    
	                    v2.add(rs.getString("student_id"));
	                    v2.add(rs.getString("tamil"));
	                    v2.add(rs.getString("english"));
	                    v2.add(rs.getString("maths"));
	                    v2.add(rs.getString("science"));
	                    v2.add(rs.getString("social"));
	                    v2.add(rs.getString("total"));
	                   
	                }
	                model.addRow(v2);
	               
	            }

			}
						 catch (Exception ex) {
				ex.printStackTrace();
						 }
		
	
}
		
	

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\laptop files\\venkatesh\\new phone all images\\Camera\\IMG_20200926_145645.jpg"));
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 900, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 11, 656, 444);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {                                    
		        model = (DefaultTableModel) table.getModel();
		        int selected = table.getSelectedRow();
		        textField_1.setText(model.getValueAt(selected, 0).toString());
		        textField_2.setText(model.getValueAt(selected, 1).toString());
		         textField_3.setText(model.getValueAt(selected, 2).toString());
		         textField_4.setText(model.getValueAt(selected, 3).toString());
		         textField_5.setText(model.getValueAt(selected, 4).toString());
		         textField_6.setText(model.getValueAt(selected, 5).toString());
		      //   textField_7.setText(model.getValueAt(selected, 6).toString());
		        load();
		    }
		    });

		table.setBackground(new Color(211, 211, 211));
	    model=new DefaultTableModel();
	    Object[] column= {"Student_Id", "Tamil", "English", "Maths", "Science", "Social", "Total"};
	    Object[] row=new Object[7];
	    model.setColumnIdentifiers(column);
	    table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		
		JLabel lblNewLabel_1 = new JLabel("Student_Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 56, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
	
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(250, 235, 215));
		textField_1.setBounds(122, 55, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
			      
			    	PreparedStatement p=con.prepareStatement("insert into studentmarks values(?,?,?,?,?,?,?)");
			    	
			    	p.setString(1,textField_1.getText());
			    	p.setString(2,textField_2.getText());
			    	p.setString(3,textField_3.getText());
			    	p.setString(4,textField_4.getText());
			    	p.setString(5,textField_5.getText());
			    	p.setString(6,textField_6.getText());
			    	p.setString(7,textField_7.getText());
			    	p.executeUpdate();
			    	JOptionPane.showMessageDialog(null, "Register Successfull");   	
					}
								 catch (Exception ex) {
						ex.printStackTrace();
								 }

				
				row[0]=textField_1.getText();
				row[1]=Integer.parseInt(textField_2.getText());
				row[2]=Integer.parseInt(textField_3.getText());
				row[3]=Integer.parseInt(textField_4.getText());
				row[4]=Integer.parseInt(textField_5.getText());
				row[5]=Integer.parseInt(textField_6.getText());
				x=((Integer.parseInt(textField_2.getText()))+(Integer.parseInt(textField_3.getText()))+(Integer.parseInt(textField_4.getText()))+(Integer.parseInt(textField_5.getText()))+(Integer.parseInt(textField_6.getText())));
				row[6]=x;
				model.addRow(row);
			
		    	textField_1.setText(null);
		    	textField_2.setText(null);
		    	textField_3.setText(null);
		    	textField_4.setText(null);
		    	textField_5.setText(null);
		    	textField_6.setText(null);
		    	textField_7.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(17, 408, 95, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField_7.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_2.setBounds(64, 437, 95, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Tamil:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 104, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("English:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 144, 65, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Maths:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 197, 65, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Science:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 240, 76, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Social:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 284, 65, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(250, 235, 215));
		textField_2.setBounds(97, 103, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(250, 235, 215));
		textField_3.setBounds(97, 146, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(250, 235, 215));
		textField_4.setBounds(97, 196, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(250, 235, 215));
		textField_5.setBounds(97, 239, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(250, 235, 215));
		textField_6.setBounds(97, 283, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
	}
}
