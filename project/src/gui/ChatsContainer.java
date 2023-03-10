package gui;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class ChatsContainer 
{
	private JScrollPane scrollPane;
	private int i;
	private static JPanel mainPanel;
		
	private static ChatsContainer singleInstance;	
	public static ChatsContainer getInstance()
	{
		if(singleInstance==null)
		{
			singleInstance= new ChatsContainer();
		}
		return singleInstance;
	}	
	public JScrollPane getChatsContainer()
	{
		return scrollPane; 
	}	
	private ChatsContainer()
	{
		mainPanel = new JPanel();		
		mainPanel.setBackground(Color.DARK_GRAY);
		scrollPane = new JScrollPane();		
		scrollPane.setViewportView(mainPanel);
		scrollPane.setBounds(0, 110, 334, 470);
		mainPanel.setLayout(null);	
		
	}
public JPanel addChatPanel(int num,String chatName,String time,String chat,String number,String about,BufferedImage Image) {
	ChatPanel cp=new ChatPanel(num,chatName,time,chat,number,about,Image);
	JPanel temp=cp.getChatPanel();
	return temp;
}
public void setChatonGUI(String chatName,String time,String chat,String number,String about,BufferedImage Image) {
	BufferedImage dummyImage;
	try {
	dummyImage=ImageIO.read(ChatsContainer.class.getResource(""));
	mainPanel.add(addChatPanel(i, chatName, time, chat, number, about, dummyImage));
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
