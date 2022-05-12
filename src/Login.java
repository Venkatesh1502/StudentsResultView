import java.awt.Color;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
int c=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\laptop files\\venkatesh\\new phone all images\\Camera\\IMG_20200926_145645.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(69, 50, 108, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student_Id:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(69, 98, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(250, 235, 215));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(206, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(250, 235, 215));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBounds(206, 95, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 20, 147));
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
			
					Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
	
		  	PreparedStatement p=con.prepareStatement("select * from registration where student_id=? and name=?");  
		  	p.setString(1,textField_1.getText());
		  	p.setString(2,textField.getText());
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
				c=1;
			
			}
			if(c==1) {

				PreparedStatement p1=con.prepareStatement("select * from studentmarks where student_id=?");
				p1.setString(1,  textField_1.getText());
				ResultSet rs1=p1.executeQuery();
				if(rs1.next()){
					String tamil=rs1.getString("tamil");
					String english=rs1.getString("english");
					String maths=rs1.getString("maths");
					String science=rs1.getString("science");
					String social=rs1.getString("social");
					String total=rs1.getString("total");
					textField_2.setText(tamil);
					textField_3.setText(english);
					textField_4.setText(maths);
					textField_5.setText(science);
					textField_6.setText(social);
					textField_7.setText(total);
						}
			
				
			
			else
			{
				JOptionPane.showMessageDialog(null,"Student Name & ID is incorrect");
				textField.setText(null);
				textField_1.setText(null);
			
			}
			}
				}
		
			catch(Exception ex)
			{
			System.out.println(ex);
			}
			}

		
	});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(149, 154, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(250, 235, 215));
		textField_2.setBounds(162, 226, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(250, 235, 215));
		textField_3.setBounds(162, 268, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(250, 235, 215));
		textField_4.setBounds(162, 303, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(250, 235, 215));
		textField_5.setBounds(162, 345, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(250, 235, 215));
		textField_6.setBounds(162, 387, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(250, 235, 215));
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_7.setBounds(162, 432, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tamil :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(69, 226, 61, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("English :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(69, 268, 73, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Maths :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(69, 302, 63, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Science :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(64, 345, 78, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Social :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(69, 386, 73, 17);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Total :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(69, 432, 61, 14);
		contentPane.add(lblNewLabel_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(250, 235, 215));
		//textArea.setForeground(Color.RED);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textArea.setBounds(320, 46, 435, 363);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setBackground(new Color(250, 235, 215));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t XYZ University Result \n\n" +
						"Name:  " + textField.getText() + "\t Student ID:  " + textField_1.getText() +
						"\n============================================\n" +
						"Tamil:   \t\t\t" + textField_2.getText()  + "\n\n" +
						"English: \t\t\t" + textField_3.getText() + "\n\n" +
						"Maths:    \t\t\t" + textField_4.getText() + "\n\n" +
						"Science: \t\t\t" + textField_5.getText() + "\n\n" +
						"Social: \t\t\t" + textField_6.getText() + "\n\n" +
						"\n==========================================\n" +
						"Total Marks: \t\t\t" + textField_7.getText() + "\n\n" +
						 
						"==========================================\n\n"
						);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(491, 433, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setForeground(new Color(255, 20, 147));
		btnNewButton_2.setBackground(new Color(250, 235, 215));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText(null);
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			textField_5.setText(null);
			textField_6.setText(null);
			textField_7.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(631, 433, 89, 23);
		contentPane.add(btnNewButton_2);
		
			}
}
