package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChatPanel 
{
	private JPanel mainPanel;	
	public JPanel getChatPanel() 
	{
		return mainPanel;
	}	
		ChatPanel(int num,String chatName,String time,String chat,String number,String about,BufferedImage image)
	{
		RelativeLayout rl = new RelativeLayout(RelativeLayout.X_AXIS);
		 rl.setFill( true );
		
		mainPanel = new JPanel(rl);
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(SwingUtilities.isRightMouseButton(e) || e.isControlDown())
				{	
					JOptionPane.showMessageDialog(null,"Right click!");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Left click!");					
				}
			}
		});		
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, (80*(num-1)),334, 80);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);		
		leftPanel.setLayout(new BorderLayout(0, 0));
		JLabel profileIcon = new JLabel("");
		profileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		profileIcon.setIcon(new ImageIcon(image));
		leftPanel.add(profileIcon);
		mainPanel.add(leftPanel, new Float(25));
		
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(null);
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		
		JLabel name = new JLabel(chatName);
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setBounds(10, 12, 139, 25);
		middlePanel.add(name);
		JLabel recentMsg = new JLabel(chat);
		recentMsg.setForeground(Color.BLACK);
		recentMsg.setFont(new Font("Roboto", Font.PLAIN, 12));
		recentMsg.setBounds(10, 40, 163, 14);
		middlePanel.add(recentMsg);
		mainPanel.add(middlePanel, new Float(55));
		
	
		JPanel rigthPanel = new JPanel();
		rigthPanel.setLayout(null);
		rigthPanel.setBackground(Color.WHITE);
		rigthPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		
		JLabel timeLabel = new JLabel(time);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		timeLabel.setBounds(44, 15, 104, 14);
		rigthPanel.add(timeLabel);
		mainPanel.add(rigthPanel, new Float(20));
	}	
	
}
