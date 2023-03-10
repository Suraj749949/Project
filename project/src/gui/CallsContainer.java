package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;


public class CallsContainer 
{
	
	
	private JScrollPane scrollPane;
	private static JPanel mainPanel;
	private static CallsContainer singleInstance;	
	public static CallsContainer getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance= new CallsContainer();
		}
		return singleInstance;
	}	
	public JScrollPane getCallsContainer()
	{
		return scrollPane; 
	}
	
	private CallsContainer()
	{
		mainPanel = new JPanel();		
		mainPanel.setBackground(Color.BLACK);
		scrollPane = new JScrollPane();		
		scrollPane.setViewportView(mainPanel);
		scrollPane.setBounds(0, 110, 334, 470);
		mainPanel.setLayout(null);	
	}
	
	
	
	
	
}
