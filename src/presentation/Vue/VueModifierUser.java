package presentation.Vue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Utils.Utils;
import presentation.Beans.userBean;

public class VueModifierUser extends VueAddUser{
	
	private JButton edit;
	private String cin;
	private String statut;
	
	public VueModifierUser() {
		super();
		JPanel panel = (JPanel)this.getContentPane();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		this.setTitle("modifier l'utilisateur");
		panel.remove(this.getAdd());
		edit = new JButton("modifier");
		edit.setBounds(240,382,90,25);
		panel.add(edit);
		ajouterListenerss();
	}
	
	public void ajouterListenerss() {
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = 0;
				userBean bean;
				String msg = "Utilisateur modifie avec succes\n";
				bean = initBean();
				cin = bean.getCin();				
				result = getControleur().modifierUser(bean, cin);
				if (result != 1) {
					Utils.displayMessage(VueModifierUser.this, result);
					return;
				}
				dispose();
			}
		});
	}

	
	

}
