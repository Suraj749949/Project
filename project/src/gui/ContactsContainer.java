package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ContactsContainer 
{
	
	
	private JScrollPane scrollPane;
	private static JPanel mainPanel;
	
	private static ContactsContainer singleInstance;	
	public static ContactsContainer getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance= new ContactsContainer();
		}
		return singleInstance;
	}	
	public JScrollPane getContactsContainer()
	{
		return scrollPane; 
	}
	
	private ContactsContainer()
	{
		mainPanel = new JPanel();		
		mainPanel.setBackground(Color.YELLOW);
		scrollPane = new JScrollPane();		
		scrollPane.setViewportView(mainPanel);
		scrollPane.setBounds(0, 110, 334, 470);
		mainPanel.setLayout(null);	
	}
	
	
	
	public JPanel addcontactPanel(int num,String number,String name,String about,BufferedImage image) {
		ContactPanel cp=new ContactPanel(num,number,name,about,image);
		JPanel temp=cp.getContactPanel();
		return temp;
	}
	public void setContactonGUI(String name,String number,String about, int i) {
	BufferedImage dummyImage;
		try {
			 dummyImage=ImageIO.read(ContactsContainer.class.getResource(""));
			mainPanel.add(addcontactPanel(i,number, name, about, dummyImage));
			i++;
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	
}
	

	}
