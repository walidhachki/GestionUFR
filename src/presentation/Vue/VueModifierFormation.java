package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Métier.Formation;

import presentation.Beans.userBean;
import presentation.Controleur.ControleurGestionFormation;

public class VueModifierFormation extends VueAddFormation {

	private JButton edit;
	private int id;
	private Formation formation;

	public VueModifierFormation() {
		super();
		JPanel panel = (JPanel)this.getContentPane();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		this.setTitle("modifier formation");
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
				String msg = "Formation modifie avec succées\n";
				formation = new Formation();
				ControleurGestionFormation controleurGestionFormation = new ControleurGestionFormation();
				formation.setLibelle(getTxtLibelle().getText());
				formation.setChargeHoraire(Double.parseDouble(getTxtCharge().getText()));
				formation.setNumSemestre(Integer.parseInt(getTxtNum().getText()));
				result = controleurGestionFormation.modifierFormation(formation, id);


				dispose();
			}
		});

	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
