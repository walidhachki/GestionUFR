package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Utils.StoreData;
import presentation.Controleur.ControleurGestionFormation;
import presentation.Controleur.ControleurGestionUser;

public class VueControlPanel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972778005131615806L;
	private JButton manageUser, manageFormation,manageDoctorant,manageSoutenance,deconnect;
	
	public VueControlPanel() {
        setTitle("Espace Responsable UFR");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        init();
        draw();
        listeners();
    }
	
	private void init() {
        manageFormation = new JButton("Gestion des Formations");
        manageDoctorant = new JButton("Gestion des doctorants");
        manageSoutenance = new JButton ("Gestion des soutenances");
        manageUser = new JButton("Gestion des utilisateurs");
        deconnect = new JButton();
    }
	
	private void draw() {
        JPanel pan = (JPanel)this.getContentPane();
        manageUser.setBounds(40, 105, 200, 100);
        manageFormation.setBounds(250, 105, 200, 100);
        manageDoctorant.setBounds(40, 220, 200, 100);
        manageSoutenance.setBounds(250, 220 , 200, 100);
        deconnect.setBounds(434, 11, 50, 50);
        deconnect.setIcon(new ImageIcon("./icons/0.png"));
        pan.add(manageFormation);
        pan.add(manageUser);
        pan.add(manageDoctorant);
        pan.add(manageSoutenance);
        pan.setBackground(SystemColor.inactiveCaptionBorder);
        pan.add(deconnect);
    }
	
	public void btnFormationClick(ActionListener e)
    {
		manageFormation.addActionListener(e);
    }
	public void btnUserClick(ActionListener e)
    {
		manageUser.addActionListener(e);
    }
	public void btnDoctorantClick(ActionListener e)
    {
		manageDoctorant.addActionListener(e);
    }
	public void btnSoutenanceClick(ActionListener e)
    {
		manageSoutenance.addActionListener(e);
    }
	 private void listeners() {

	        deconnect.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new VueConnexion().setVisible(true);
	                StoreData.store();
	                dispose();
	            }
	        });

	    }
	
	
}
