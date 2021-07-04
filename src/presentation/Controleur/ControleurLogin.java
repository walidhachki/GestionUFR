package presentation.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Métier.GestionnaireLogin;
import presentation.Vue.VueConnexion;
import presentation.Vue.VueControlPanel;

public class ControleurLogin {
	
	private VueConnexion myView;
	//private GestionnaireLogin gestionnaire;
	
	public void afficheLogin()
	{
		this.myView = new VueConnexion();
		this.myView.btnConnectClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(new GestionnaireLogin().isValide(myView.getUsername(),myView.getPassword()) == 1) 
            	{
            		ControleurMenu c = new ControleurMenu();
            		c.afficheMenu();
            		//new VueControlPanel().setVisible(true);
                    myView.dispose();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(myView,"informations invalides");
            	}
               
            }
        });
		this.myView.setVisible(true);
	}
	
	

}
