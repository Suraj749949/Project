
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GFG {
public static void convert() {
	JFrame f=new JFrame("CONVERTER");
	JLabel l1,l2;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5; 
	l1=new JLabel("INR :");
	l1.setBounds(20, 40, 60, 30);
	l2=new JLabel("CONVERSION :");
	l2.setBounds(170, 40, 60, 30);
	t1=new JTextField("0");
	t1.setBounds(80, 40, 50, 30);
	t2=new JTextField("0");
	t2.setBounds(240, 40, 50, 30);
	b1=new JButton("RUPEES");
	b1.setBounds(50,80,60,15);
	b2=new JButton("DOLLER");
	b2.setBounds(190,80,60,15);
	b3=new JButton("close");
	b3.setBounds(310,230,60,30);
	b4=new JButton("POUND");
	b4.setBounds(50, 100, 60, 15);
b5=new JButton("YOUN");
b5.setBounds(190, 100, 60, 15);
	b1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			double d=Double.parseDouble(t1.getText());
			double d1=(d/65.25);
			String str1=String.valueOf(d1);
			t2.setText(str1);
			
		}
	});
	
b2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			double d2=Double.parseDouble(t1.getText());
			double d3=(d2*65.25);
			String str2=String.valueOf(d3);
			t2.setText(str2);
			
		}
	});
b4.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		double d4=Double.parseDouble(t1.getText());
		double d5=(d4+65.25);
		String str3=String.valueOf(d5);
		t2.setText(str3);
		
	}
});
b5.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		double d6=Double.parseDouble(t1.getText());
		double d7=(d6-65.25);
		String str3=String.valueOf(d7);
		t2.setText(str3);
		
	}
});

b3.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		f.dispose();
		
	}
});
f.addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
});
	
f.add(l1);
f.add(t1);	
f.add(l2);	
f.add(t2);
f.add(b1);	
f.add(b2);	
f.add(b3);
f.add(b4);
f.add(b5);

f.setLayout(null);
f.setSize(400,300);
f.setVisible(true);
}
public static void main(String[] args) {
	convert();
}
}