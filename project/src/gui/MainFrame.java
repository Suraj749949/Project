package gui;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	private static MainFrame singleInstance;
	public static MainFrame getInstance() {
		if(singleInstance==null)
		{
			singleInstance=new MainFrame();
		}
		return singleInstance;
	}
JFrame frame;
JPanel panel;
private MainFrame() {
	frame=new JFrame();
	frame.setTitle("whatsuponjava");
	frame.getContentPane();
	frame.setBounds(100, 70, 350, 620);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false);
	panel=new JPanel();
	panel.setBounds(0, 0, 340, 580);
	frame.getContentPane().add(panel);
	panel.setBackground(Color.GRAY);
	panel.setLayout(null);
	frame.setVisible(true);
	
}
public void addRibbon() {
	panel.add(Ribbon.getInstance().getRibbon());
}
public void addChatsContainer() {
	panel.add(ChatsContainer.getInstance().getChatsContainer());
}
public void addContactsContainer() {
	panel.add(ContactsContainer.getInstance().getContactsContainer());
}
public void addCallsContainer() {
	panel.add(CallsContainer.getInstance().getCallsContainer());
}
public void addVerificationPanel() {
	panel.add(VerificationPanel.getInstance().getVerificationPanel());
}
public void addRegistrationPanel() {
	panel.add(RegistrationPanel.getInstance().getRegistrationPanel());
}
public void activateChatContainer() {
	Ribbon.getInstance().getRibbon().setVisible(true);
	ChatsContainer.getInstance().getChatsContainer().setVisible(true);
	CallsContainer.getInstance().getCallsContainer().setVisible(false);
	ContactsContainer.getInstance().getContactsContainer().setVisible(false);
}
public void activateContactContainer() {
	Ribbon.getInstance().getRibbon().setVisible(true);
	ChatsContainer.getInstance().getChatsContainer().setVisible(false);
	CallsContainer.getInstance().getCallsContainer().setVisible(false);
	ContactsContainer.getInstance().getContactsContainer().setVisible(true);
}
public void activateCallsContainer() {
	Ribbon.getInstance().getRibbon().setVisible(true);
	ChatsContainer.getInstance().getChatsContainer().setVisible(false);
	CallsContainer.getInstance().getCallsContainer().setVisible(true);
	ContactsContainer.getInstance().getContactsContainer().setVisible(false);
}
public void activateVerificationPanel() {
	VerificationPanel.getInstance().getVerificationPanel().setVisible(true);
	Ribbon.getInstance().getRibbon().setVisible(false);
	ChatsContainer.getInstance().getChatsContainer().setVisible(false);
	CallsContainer.getInstance().getCallsContainer().setVisible(false);
	ContactsContainer.getInstance().getContactsContainer().setVisible(false);
}
public void activateRegistrationPanel() {
	RegistrationPanel.getInstance().getRegistrationPanel().setVisible(true);
	VerificationPanel.getInstance().getVerificationPanel().setVisible(false);
	Ribbon.getInstance().getRibbon().setVisible(false);
	ChatsContainer.getInstance().getChatsContainer().setVisible(false);
	CallsContainer.getInstance().getCallsContainer().setVisible(false);
	ContactsContainer.getInstance().getContactsContainer().setVisible(false);
}

public static void main(String[] args) {
	MainFrame mf=MainFrame.getInstance();
	mf.addRibbon();
	mf.addCallsContainer();
	mf.addChatsContainer();
	mf.addContactsContainer();
	mf.addVerificationPanel();
	mf.activateVerificationPanel();
	mf.addRegistrationPanel();
	
}
}
