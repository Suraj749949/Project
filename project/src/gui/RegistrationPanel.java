package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.MatteBorder;


public class RegistrationPanel
{
	private JPanel mainPanel;	
	private static RegistrationPanel singleInstance;
	public static RegistrationPanel getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance= new RegistrationPanel();
		}
		return singleInstance;
	}
	public JPanel getRegistrationPanel()
	{
		return mainPanel;	
	}
	private RegistrationPanel() 
	{
		mainPanel = new JPanel();		
		mainPanel.setBounds(0, 00, 335, 585);
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 108, 97));
		header.setBounds(0, 0, 354, 60);
		mainPanel.add(header);
		header.setLayout(null);
		
		JLabel WhatsApp = new JLabel("WhatsApp");
		WhatsApp.setBounds(7, 5, 89, 24);
		header.add(WhatsApp);
		WhatsApp.setForeground(Color.WHITE);
		WhatsApp.setFont(new Font("Roboto", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("New User Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(8, 31, 130, 14);
		header.add(lblNewLabel);
		
		JPanel panelBody = new JPanel();
		panelBody.setBackground(Color.WHITE);
		panelBody.setBounds(0, 60, 336, 503);
		mainPanel.add(panelBody);
		panelBody.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLabel.setBounds(56, 183, 76, 14);
		panelBody.add(nameLabel);
		
		JTextField name = new JTextField();
		name.setOpaque(false);
		name.setBackground(new Color(0, 102, 51));
		name.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 102, 51)));
		name.setBounds(131, 180, 154, 20);
		panelBody.add(name);
		name.setColumns(10);
		
		JLabel mobileLabel = new JLabel("Mobile");
		mobileLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		mobileLabel.setBounds(56, 225, 76, 14);
		panelBody.add(mobileLabel);
		
		JTextField mobile = new JTextField();
		mobile.setOpaque(false);
		mobile.setBackground(new Color(0, 102, 51));
		mobile.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 102, 51)));
		mobile.setColumns(10);
		mobile.setBounds(131, 222, 154, 20);
		panelBody.add(mobile);
		
		JLabel emailLabel = new JLabel("E-mail ");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailLabel.setBounds(56, 267, 76, 14);
		panelBody.add(emailLabel);
		
		JTextField email = new JTextField();
		email.setOpaque(false);
		email.setBackground(new Color(0, 102, 51));
		email.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 102, 51)));
		email.setColumns(10);
		email.setBounds(131, 267, 154, 20);
		panelBody.add(email);
		
		JLabel aboutLabel = new JLabel("About");
		aboutLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		aboutLabel.setBounds(56, 338, 76, 14);
		panelBody.add(aboutLabel);
		
		JTextArea about = new JTextArea("Hey There! I am using WhatsAppOnJava");
		about.setWrapStyleWord(true);
		about.setLineWrap(true);
		about.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 102, 51)));
		about.setBounds(131, 311, 154, 58);
		panelBody.add(about);
		
		JButton registerButton = new JButton("Register");
		registerButton.setForeground(Color.WHITE);
		registerButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Registered successfully");
				MainFrame.getInstance().activateVerificationPanel();
				
			}
		});
		registerButton.setBackground(new Color(0, 102, 51));
		registerButton.setBorder(null);
		registerButton.setBounds(56, 393, 229, 23);
		panelBody.add(registerButton);
		
		JLabel profilePcLabel = new JLabel("");
		profilePcLabel.setHorizontalAlignment(SwingConstants.CENTER);		
		profilePcLabel.setBounds(97, 22, 150, 144);
		panelBody.add(profilePcLabel);		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MainFrame.getInstance().activateVerificationPanel();				
			}
		});
		backButton.setBorder(null);
		backButton.setBackground(new Color(0, 102, 51));
		backButton.setBounds(265, 469, 61, 23);
		panelBody.add(backButton);
		
		
		JLabel addImage = new JLabel("Add");
		addImage.addMouseListener(new MouseAdapter() 
		{	
			@Override
			public void mouseClicked(MouseEvent arg0)
			{				
				JOptionPane.showMessageDialog(null,"Add image");						
			}
		});
		addImage.setFont(new Font("Tahoma", Font.BOLD, 12));
		addImage.setBounds(198, 155, 49, 14);
		panelBody.add(addImage);
	}
}