package presentation.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.Vue.VueGestionSoutenance;

public class ControleurSoutenance {

private VueGestionSoutenance myView;
	
	public void afficheSoutenance()
	{
		this.myView = new VueGestionSoutenance();
		this.myView.btnBackClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ControleurMenu().afficheMenu();
        		myView.dispose();
            }
        });
		myView.setVisible(true);
	}
}
