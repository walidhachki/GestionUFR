package presentation.Vue;

import javax.swing.*;

import Métier.Formation;
import Utils.Utils;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.*;

import presentation.Beans.userBean;
import presentation.Controleur.ControleurGestionFormation;

public class VueAddFormation extends JFrame{
	private static final long serialVersionUID = 2168283605819928222L;
	private JButton add,cancel;
    private JLabel numSemestre,chargeHoraire,libelle;
    private JTextField txtNum,txtCharge,txtLibelle;
    private ControleurGestionFormation controleur;

    public VueAddFormation(){
        setTitle("Ajouter une formation");
        setSize(450,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        init();
        draw();
        //ajouterListeners();
    }
    
    private void init(){
        add = new JButton("Ajouter");
        cancel = new JButton("Annuler");
        numSemestre = new JLabel("Numéro de semestre :");
        chargeHoraire = new JLabel("Charge Horaire :");
        libelle = new JLabel("Libelle :");
        txtNum = new JTextField();
        txtCharge = new JTextField();
        txtLibelle = new JTextField();
        

        /**txtCin.setToolTipText("un ou deux lettres et 6 chiffres");
        txtNom.setToolTipText("lettres et espaces seulement");
        txtPrenom.setToolTipText("lettres et espaces seulement");**/
    }
    
    private void draw(){
        JPanel panel = (JPanel)this.getContentPane();
        panel.setLayout(null);

        numSemestre.setBounds(75,30,114,25);
        panel.add(numSemestre);
        txtNum.setBounds(235,30,146,25);
        panel.add(txtNum);

        chargeHoraire.setBounds(75,75,114,25);
        panel.add(chargeHoraire);
        txtCharge.setBounds(235,75,146,25);
        panel.add(txtCharge);

        libelle.setBounds(75,120,114,25);
        panel.add(libelle);
        txtLibelle.setBounds(235,120,146,25);
        panel.add(txtLibelle);
        
        add.setBounds(140,250,90,25);
        cancel.setBounds(238,250,90,25);
        panel.add(add);
        panel.add(cancel);
        panel.setBackground(SystemColor.inactiveCaptionBorder);
        listeners();

    }
    
    public void listeners() {
    	add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result;
                Formation formation ;
                if (checkFieldIsEmpty() == 0)
                    return;
                /**
                if (checkRegex() == false)
                    return;**/
                formation = new Formation(getNumSemestre(),getCharge(),getLibelle());
				System.out.println(getLibelle());
                result = controleur.ajouterFormation(formation);
                if (result != 1){
                    Utils.displayMessage(VueAddFormation.this,result);
                    return;
                }
                JOptionPane.showMessageDialog(VueAddFormation.this,"Formation ajoutée avec succées\n");
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

		if (txtNum.getText().length() == 0 || txtCharge.getText().length() == 0 || txtLibelle.getText().length() == 0) {
			JOptionPane.showMessageDialog(VueAddFormation.this, "information(s) manquante(s)");
			return 0;
		}
		return 1;
	}

	public int getNumSemestre()
	{
		return Integer.parseInt(txtNum.getText());
	}
	public String getLibelle()
	{
		return txtLibelle.getText();
	}
	public Double getCharge()
	{
		return Double.parseDouble(txtCharge.getText());
	}
	public ControleurGestionFormation getControleur() {
		return controleur;
	}

	public void setControleur(ControleurGestionFormation controleur) {
		this.controleur = controleur;
	}

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public JTextField getTxtNum() {
        return txtNum;
    }

    public void setTxtNum(JTextField txtNum) {
        this.txtNum = txtNum;
    }

    public JTextField getTxtCharge() {
        return txtCharge;
    }

    public void setTxtCharge(JTextField txtCharge) {
        this.txtCharge = txtCharge;
    }

    public JTextField getTxtLibelle() {
        return txtLibelle;
    }

    public void setTxtLibelle(JTextField txtLibelle) {
        this.txtLibelle = txtLibelle;
    }
}
