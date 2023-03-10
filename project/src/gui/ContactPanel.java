package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ContactPanel 
{
	private int i=0;
	private JPanel mainPanel;	

	public JPanel getContactPanel()
	{
		return mainPanel;
	}

	ContactPanel(int num,String contactNumber,String contactname,String contactabout,BufferedImage Image) 
	{
	RelativeLayout rl=new RelativeLayout(RelativeLayout.X_AXIS);
	rl.setFill(true);
	mainPanel=new JPanel(rl);
	mainPanel.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null,"conversationpanel");
		}
	});		
		mainPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, (50*(num-1)),334, 50);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setLayout(new BorderLayout(0, 0));
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.setIcon(new ImageIcon(Image));
		leftPanel.add(label);
		mainPanel.add(leftPanel, new Float(25));
			
		RelativeLayout rl2 = new RelativeLayout(RelativeLayout.Y_AXIS);
		rl2.setFill( true );
		
		JPanel rightPanel = new JPanel(rl2);		
		rightPanel.setBackground(Color.WHITE);		
		
		JLabel name = new JLabel(contactname);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));		
		rightPanel.add(name,new Float(50));
		
		JLabel about = new JLabel(contactabout);
		about.setFont(new Font("Roboto", Font.PLAIN, 12));
		about.setForeground(Color.BLACK);		
		rightPanel.add(about, new Float(50));
		
		mainPanel.add(rightPanel, new Float(75));
	}


		
}