package presentation.Vue;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.PatternSyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import presentation.Controleur.ControleurGestionFormation;
import presentation.Controleur.ControleurGestionUser;
import presentation.Controleur.ControleurMenu;
import presentation.Models.ModelFormation;
import presentation.Models.ModelUser;

public class VueGestionFormation extends JFrame {
	private JButton back,add,edit,del;
	private JTextField search;
	private ControleurGestionFormation controleur;
	private ModelFormation model;
	private JTable tableFormation;
	TableRowSorter<ModelFormation> sorter;
	
    public VueGestionFormation(ModelFormation model) {
		
		setTitle("Gestion des Formations");
		setSize(700,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		this.model = model;
		init();
		draw();
		ajouterListeners();
	}
    
    private void init() {
		back = new JButton("Retour");
		add = new JButton("Ajouter");
		search = new JTextField();
		tableFormation = new JTable(model);
		sorter = new TableRowSorter<>(model);
        tableFormation.setRowSorter(sorter);
		edit = new JButton("Modifier");
		del = new JButton("Supprimer");
	}
    
    private void draw() {
		JScrollPane scrollPane;
		JLabel searchlabel = new JLabel("recherche: ");
		
		JPanel pan = (JPanel) getContentPane();
		pan.setLayout(null);
		back.setBounds(600,430,80,25);
		JPanel panel = new JPanel(null);
		panel.setBounds(30,80,635,330);
		panel.setBorder(BorderFactory.createTitledBorder("Formations"));
		add.setBounds(547,295,80,25);
		edit.setBounds(470,295,80,25);
		del.setBounds(392, 295,80, 25);
		searchlabel.setBounds(10, 295, 80, 25);
		search.setBounds(70,295,220,25);
		panel.add(search);
		panel.add(searchlabel);
		panel.add(add);
		panel.add(del);
		panel.add(edit);
		//tableUser.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane = new JScrollPane(tableFormation);
		scrollPane.setBounds(7,25,620,270);
		panel.add(scrollPane);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		pan.setBackground(SystemColor.inactiveCaptionBorder);
		pan.add(panel);
		pan.add(back);
	}
    
    private void ajouterListeners(){
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.genererVueAjout();
            }
        });

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedRowIndex;
				selectedRowIndex = tableFormation.getSelectedRow();
				if (selectedRowIndex == -1) {
					JOptionPane.showMessageDialog(VueGestionFormation.this, "aucune ligne selectionée");
					return;
				}
				tableFormation.convertRowIndexToModel(selectedRowIndex);
				controleur.genereVueModification(tableFormation.convertRowIndexToModel(selectedRowIndex));
			}
		});
    	
    	del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id;
				int selectedRowIndex;
				selectedRowIndex = tableFormation.getSelectedRow();
				if (selectedRowIndex == -1) {
					JOptionPane.showMessageDialog(VueGestionFormation.this, "aucune ligne selectionée");
					return;
				}
				selectedRowIndex = tableFormation.convertRowIndexToModel(selectedRowIndex);
				int reponse = JOptionPane.showConfirmDialog(VueGestionFormation.this, "vous voulez vraiment supprimer cette formation?","confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(reponse == JOptionPane.YES_OPTION)
				{
					id = (int) model.getValueAt(selectedRowIndex, 3);
					controleur.supprimerFormation(id);
				}
			}
		});
    	
       search.addKeyListener(new KeyAdapter() {
			
			@Override
            public void keyTyped(KeyEvent e) {
                String text = search.getText();
                try{
                sorter.setRowFilter(RowFilter.regexFilter(text));}
                catch (PatternSyntaxException pse){
                    pse.getMessage();
                }
            }
		});
    	
    	back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ControleurMenu().afficheMenu();
                dispose();
            }
        });
     }

	public ControleurGestionFormation getControleur() {
		return controleur;
	}

	public void setControleur(ControleurGestionFormation controleur) {
		this.controleur = controleur;
	}

}
