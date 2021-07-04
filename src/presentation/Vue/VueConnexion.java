package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VueConnexion extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin ;
    private JPasswordField txtPass;
    private JButton connect,cancel;
    private JLabel login,pass;
    
    public VueConnexion() {
		setTitle("Identification");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);
		init();
		draw();
		setListeners();
	}
    
    private void init() {

        login = new JLabel("Login :");
        pass = new JLabel("Password :");
        txtLogin = new JTextField();
        txtPass = new JPasswordField();
        connect = new JButton("Sign in");
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
    }
    
    private void draw() {
        JPanel pan = (JPanel) this.getContentPane();
        login.setBounds(50,70,80,25);

        pass.setBounds(50,100,80,25);
        txtLogin.setBounds(150,70,160,25);
        txtPass.setBounds(150,100,160,25);
        connect.setBounds(200,230,90,25);
        cancel.setBounds(300,230,80,25);
        pan.add(login);
        pan.setBackground(SystemColor.inactiveCaptionBorder);
        pan.add(txtLogin);
        pan.add(txtPass);
        pan.add(connect);
        pan.add(pass);
        pan.add(cancel);
    }
    public void btnConnectClick(ActionListener e)
    {
    	connect.addActionListener(e);
    }
    private void setListeners(){
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    public String getUsername()
    {
    	return txtLogin.getText();
    }
    
    public String getPassword() 
    {
    	return String.valueOf(txtPass.getPassword());
    }
    
    
    
}
