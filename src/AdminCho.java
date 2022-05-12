import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class AdminCho {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCho window = new AdminCho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminCho() {
		initialize();
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\laptop files\\venkatesh\\new phone all images\\Camera\\IMG_20200926_145645.jpg"));
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton(".....Student's Registration Form Entry");
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new studreg();
			
			}
		});
		btnNewButton.setBounds(10, 90, 373, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(".....Student's Mark Entry Form");
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Box();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(10, 189, 373, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Admin Area\r\n");
		lblNewLabel.setForeground(new Color(60, 179, 113));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(113, 11, 192, 37);
		frame.getContentPane().add(lblNewLabel);
	}
}
