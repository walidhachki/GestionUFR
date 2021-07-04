package presentation.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Métier.GestionnaireLogin;
import presentation.Vue.VueControlPanel;

public class ControleurMenu {
	
	private VueControlPanel myView;
	
	public void afficheMenu()
	{
		this.myView = new VueControlPanel();
		this.myView.btnUserClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ControleurGestionUser controleurGestionUser = new ControleurGestionUser();
                controleurGestionUser.getVueGestionUser().setControleur(controleurGestionUser);
                controleurGestionUser.getVueGestionUser().setVisible(true);
	            myView.dispose();
            }
        });
		this.myView.btnFormationClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ControleurGestionFormation controleurGestionFormation = new ControleurGestionFormation();
	            controleurGestionFormation.getVueGestionFormation().setControleur(controleurGestionFormation);
	            controleurGestionFormation.getVueGestionFormation().setVisible(true);
	            myView.dispose();
            }
        });
		this.myView.btnDoctorantClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ControleurDoctorant().afficheDoctorant();
        		myView.dispose();
               
            }
        });
		this.myView.btnSoutenanceClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ControleurSoutenance().afficheSoutenance();
            	myView.dispose();
            }
        });
		this.myView.setVisible(true);
	}

}
