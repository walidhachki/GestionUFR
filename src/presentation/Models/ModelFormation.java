package presentation.Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Métier.Formation;
import Métier.User;

public class ModelFormation extends AbstractTableModel{
	private ArrayList<Formation> formations;
	
	public ModelFormation() {
		super();
		this.formations = new ArrayList<Formation>();
	}

	public ModelFormation(ArrayList<Formation> formations) {
		super();
		this.formations = formations;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return formations.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0 : return formations.get(rowIndex).getNumSemestre();
		case 1 : return formations.get(rowIndex).getChargeHoraire();
		case 2 : return formations.get(rowIndex).getLibelle();
		case 3 : return formations.get(rowIndex).getId();
		default : return null;
		}
	}
		
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Num Semestre";
		case 1 : return "Charge Horaire";
		case 2 : return "Libelle";
		case 3 : return "ID";
		default : return null;
	    }
	}

	public ArrayList<Formation> getFormations() {
		return formations;
	}

	public void setFormations(ArrayList<Formation> formations) {
		this.formations = formations;
	}
}
