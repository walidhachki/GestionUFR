package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueGestionSoutenance extends JFrame {
private JButton manageArch, manageVal,back;
	
	public VueGestionSoutenance() {
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
        manageArch = new JButton("Archiver les théses");
        manageVal = new JButton("Valider les soutenances");
        back = new JButton("Retour");
    }
	
	private void draw() {
        JPanel pan = (JPanel)this.getContentPane();
        manageArch.setBounds(95, 105, 300, 100);
        manageVal.setBounds(95, 228, 300, 100);
        back.setBounds(380, 11, 100, 50);
        pan.add(manageArch);
        pan.add(manageVal);
        pan.setBackground(SystemColor.inactiveCaptionBorder);
        pan.add(back);
    }
	
	public void btnBackClick(ActionListener e)
	{
		 back.addActionListener(e);
	}
	private void listeners() {
		manageArch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });
		
		manageVal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();

            }
        });
		
	}

	

}
