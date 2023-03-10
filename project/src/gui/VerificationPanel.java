package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VerificationPanel 
{
	private JPanel mainPanel;
	private static VerificationPanel singleInstance;
	public static VerificationPanel getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance= new VerificationPanel();
		}
		return singleInstance;
	}
	public JPanel getVerificationPanel()
	{
		return mainPanel;
	}
	private VerificationPanel()
	{
		mainPanel = new JPanel();		
		mainPanel.setBounds(0, 0, 335, 585);
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);		
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 108, 97));
		header.setBounds(0, 0, 354, 60);
		mainPanel.add(header);
		header.setLayout(null);
		
		JLabel heading = new JLabel("WhatsAppOnJava");
		heading.setBounds(7, 5, 203, 24);
		header.add(heading);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel verificationLabel = new JLabel("User Verification");
		verificationLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		verificationLabel.setForeground(Color.WHITE);
		verificationLabel.setBounds(8, 31, 130, 14);
		header.add(verificationLabel);
		
		JPanel panelBody = new JPanel();
		panelBody.setBounds(0, 47, 336, 528);
		mainPanel.add(panelBody);
		panelBody.setLayout(null);
		
		JLabel mobileLabel = new JLabel("Enter registered mobile number");
		mobileLabel.setBounds(71, 366, 169, 14);
		panelBody.add(mobileLabel);
		
		JTextField mobileNumber = new JTextField();
		mobileNumber.setFont(new Font("Arial", Font.BOLD, 15));
		mobileNumber.setOpaque(false);
		mobileNumber.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 51, 51)));
		mobileNumber.setBounds(71, 392, 106, 20);
		mobileNumber.setColumns(10);
		panelBody.add(mobileNumber);
		
		JButton newUserButton = new JButton("New User?");
		newUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"RegistrationPanel");
				MainFrame.getInstance().activateRegistrationPanel();
			}
		});
		newUserButton.setForeground(Color.WHITE);
		newUserButton.setBackground(Color.GRAY);
		newUserButton.setBorder(null);
		newUserButton.setBounds(245, 472, 81, 23);
		panelBody.add(newUserButton);
		
		JLabel appIcon = new JLabel("");
		appIcon.setHorizontalAlignment(SwingConstants.CENTER);
		//appIcon.setIcon(new ImageIcon(VerificationPanel.class.getResource("/img/chat (1).png")));
		appIcon.setBounds(10, 25, 316, 330);
		panelBody.add(appIcon);
		
		JLabel loginButton = new JLabel(">>");		
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setHorizontalAlignment(SwingConstants.CENTER);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(0, 51, 51));
		loginButton.setOpaque(true);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				JOptionPane.showMessageDialog(null,"you are logged in");
				MainFrame.getInstance().activateChatContainer();
			}
		});
		loginButton.setBounds(172, 388, 41, 24);
		panelBody.add(loginButton);
		
	}
}