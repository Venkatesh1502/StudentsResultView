import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class AdminLog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminLog() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\laptop files\\venkatesh\\new phone all images\\Camera\\IMG_20200926_145645.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Id:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(90, 39, 86, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(89, 95, 87, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(250, 235, 215));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(200, 41, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(250, 235, 215));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(200, 94, 101, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Go->");
		btnNewButton.setBackground(new Color(250, 235, 215));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
			
					Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venk","venk");
		Statement st=con.createStatement();
			    	//PreparedStatement p=con.prepareStatement("select * from registration");       
			ResultSet rs=st.executeQuery("select * from admin");
			int ch=0;
			String u=textField.getText();
			String p=passwordField.getText();
			while(rs.next())
			{
			String du=rs.getString(1);
			String dp=rs.getString(2);
			
			if(du.equals(u) && dp.equals(p))
			ch=1;
			
			if(ch==1)
			{
			new AdminCho(); 
			dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Admin & Password is Incorrect");
				textField.setText(null);
				passwordField.setText(null);
			
			}
			}
		}
			catch(Exception ex)
			{
			System.out.println(ex);
			}
			}
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(144, 152, 89, 23);
		contentPane.add(btnNewButton);
	}
}
