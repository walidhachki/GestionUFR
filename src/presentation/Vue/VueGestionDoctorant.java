package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueGestionDoctorant extends JFrame{
	private JButton manageEncadrant, manageAffectation,back;
	
	public VueGestionDoctorant() {
        setTitle("Control Panel");
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
        manageEncadrant = new JButton("Création des encadrants");
        manageAffectation = new JButton("Affectation des encadrants");
        back = new JButton("Retour");
    }
	
	private void draw() {
        JPanel pan = (JPanel)this.getContentPane();
        manageEncadrant.setBounds(95, 105, 300, 100);
        manageAffectation.setBounds(95, 228, 300, 100);
        back.setBounds(380, 11, 100, 50);
        pan.add(manageEncadrant);
        pan.add(manageAffectation);
        pan.setBackground(SystemColor.inactiveCaptionBorder);
        pan.add(back);
    }
	public void btnBackClick(ActionListener e)
	{
		 back.addActionListener(e);
	}
	
	private void listeners() {
		manageEncadrant.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });
		
		manageAffectation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });
		
	}

}
