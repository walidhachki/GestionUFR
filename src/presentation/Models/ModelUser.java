package presentation.Models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Métier.User;

public class ModelUser extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<User> users;
	
	public ModelUser() {
		super();
		this.users = new ArrayList<User>();
	}

	public ModelUser(ArrayList<User> users) {
		super();
		this.users=users;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0 : return users.get(rowIndex).getCin();
		case 1 : return users.get(rowIndex).getStatut();
		case 2 : return users.get(rowIndex).getNom();
		case 3 : return users.get(rowIndex).getPrenom();
		case 4 : return users.get(rowIndex).getEmail();
		default : return null;
		}	
	}
	
	@Override
	public String getColumnName(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return "Cin";
		case 1 : return "Statut";
		case 2 : return "Nom";
		case 3 : return "Prenom";
		case 4 : return "Email";
		default : return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex ) {
		switch(columnIndex) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		default : return Object.class;
		}
	}

	public void setUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		this.users = users;
		
	}

	/**public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		
		this.users = users;
	}**/
}
