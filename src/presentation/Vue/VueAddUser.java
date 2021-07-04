package presentation.Vue;

import javax.swing.*;

import Utils.Utils;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;


import presentation.Beans.userBean;
import presentation.Controleur.ControleurGestionUser;

import java.awt.*;


public class VueAddUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2168283605819928222L;
	private JButton add,cancel;
    private JLabel cin,nom,prenom,email,statut;
    private JTextField txtCin,txtNom,txtPrenom,txtEmail;
    private JComboBox<String> cStatut;
    private ControleurGestionUser controleur;

    public VueAddUser(){
        setTitle("Ajouter Un utilisateur");
        setSize(450,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        init();
        draw();
        ajouterListeners();
    }
    private void init(){
        add = new JButton("Ajouter");
        cancel = new JButton("Annuler");
        nom = new JLabel("Nom :");
        prenom = new JLabel("Prenom :");
        cin = new JLabel("Cin :");
        email = new JLabel("Email :");
        statut = new JLabel("Statut :");
        txtNom = new JTextField();
        txtPrenom = new JTextField();
        txtCin = new JTextField();
        txtEmail = new JTextField();
        cStatut = new JComboBox<String>();
        cStatut.addItem("Etudiant");
        cStatut.addItem("Professeur");
        cStatut.addItem("Doctorant");


        txtCin.setToolTipText("un ou deux lettres et 6 chiffres");
        txtNom.setToolTipText("lettres et espaces seulement");
        txtPrenom.setToolTipText("lettres et espaces seulement");
    }

    private void draw(){
        JPanel panel = (JPanel)this.getContentPane();
        panel.setLayout(null);

        nom.setBounds(75,30,114,25);
        panel.add(nom);
        txtNom.setBounds(235,30,146,25);
        panel.add(txtNom);

        prenom.setBounds(75,75,114,25);
        panel.add(prenom);
        txtPrenom.setBounds(235,75,146,25);
        panel.add(txtPrenom);

        cin.setBounds(75,120,114,25);
        panel.add(cin);
        txtCin.setBounds(235,120,146,25);
        panel.add(txtCin);

        email.setBounds(75,165,114,25);
        panel.add(email);
        txtEmail.setBounds(235,165,146,25);
        panel.add(txtEmail);

        statut.setBounds(75,210,114,25);
        panel.add(statut);
        cStatut.setBounds(235,210,146,25);
        panel.add(cStatut);

        
        add.setBounds(240,307,90,25);
        cancel.setBounds(338,307,90,25);
        panel.add(add);
        panel.add(cancel);
        panel.setBackground(SystemColor.inactiveCaptionBorder);

    }
    
    public void ajouterListeners() {
    	add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result;
                userBean usrBean;
                if (checkFieldIsEmpty() == 0)
                    return;
                /**
                if (checkRegex() == false)
                    return;**/
                usrBean = initBean();
                result = controleur.ajouterUser(usrBean);
                if (result != 1){
                    Utils.displayMessage(VueAddUser.this,result);
                    return;
                }
                JOptionPane.showMessageDialog(VueAddUser.this,"utilisateur ajouté avec succées\n");
                dispose();
            }
        });
    	cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
    }
  
    public int checkFieldIsEmpty(){

		if (txtNom.getText().length() == 0 || txtPrenom.getText().length() == 0 || txtCin.getText().length() == 0
				|| txtEmail.getText().length() == 0) {
			JOptionPane.showMessageDialog(VueAddUser.this, "information(s) manquante(s)");
			return 0;
		}
		return 1;
	}
    public userBean initBean() {
		
		userBean bean = new userBean();
		
        bean.setCin(txtCin.getText());
        bean.setEmail(txtEmail.getText());
        bean.setStatut(cStatut.getItemAt(cStatut.getSelectedIndex()));
        bean.setNom(txtNom.getText());
        bean.setPrenom(txtPrenom.getText());
		
		return bean;
	}
    
	public JButton getAdd() {
		return add;
	}
	public void setAdd(JButton add) {
		this.add = add;
	}
	public JButton getCancel() {
		return cancel;
	}
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	public JLabel getCin() {
		return cin;
	}
	public void setCin(JLabel cin) {
		this.cin = cin;
	}
	public JLabel getNom() {
		return nom;
	}
	public void setNom(JLabel nom) {
		this.nom = nom;
	}
	public JLabel getPrenom() {
		return prenom;
	}
	public void setPrenom(JLabel prenom) {
		this.prenom = prenom;
	}
	public JLabel getEmail() {
		return email;
	}
	public void setEmail(JLabel email) {
		this.email = email;
	}

	public JLabel getStatut() {
		return statut;
	}
	public void setStatut(JLabel statut) {
		this.statut = statut;
	}
	public JTextField getTxtCin() {
		return txtCin;
	}
	public void setTxtCin(JTextField txtCin) {
		this.txtCin = txtCin;
	}
	public JTextField getTxtNom() {
		return txtNom;
	}
	public void setTxtNom(JTextField txtNom) {
		this.txtNom = txtNom;
	}
	public JTextField getTxtPrenom() {
		return txtPrenom;
	}
	public void setTxtPrenom(JTextField txtPrenom) {
		this.txtPrenom = txtPrenom;
	}
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}
	public JComboBox<String> getcStatut() {
		return cStatut;
	}
	public void setcStatut(JComboBox<String> cStatut) {
		this.cStatut = cStatut;
	}
	public ControleurGestionUser getControleur() {
		return controleur;
	}
	public void setControleur(ControleurGestionUser controleur) {
		this.controleur = controleur;
	}
    


}
