package presentation.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.Vue.VueGestionDoctorant;

public class ControleurDoctorant {

	private VueGestionDoctorant myView;
	
	public void afficheDoctorant()
	{
		this.myView = new VueGestionDoctorant();
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
