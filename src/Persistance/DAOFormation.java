package Persistance;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Métier.Formation;
import Métier.User;

public class DAOFormation {
	public DAOFormation() {};
	
	public static int addFormation(Formation formation) {
    	int result;
		try {
		Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
		String query = "insert into formation(libelle, chargeHoraire, numSemestre) values('" + formation.getLibelle() + "','"+formation.getChargeHoraire()+"','"+formation.getNumSemestre()+"')";
		result = st.executeUpdate(query);
		return result;}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	
    }
	
	public static int delFormation(int id){

        int result;

        try{
            Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
            String query = "delete from formation where id ='"+id+"'";
            result = st.executeUpdate(query);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
	
	public static ArrayList<Formation> getAllFormations(){

	    ArrayList<Formation> formations = new ArrayList<Formation>();
	    try {
	        Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
	        String query = "select * from formation";
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next()) {
	            Formation formation = new Formation();

	            formation.setId(rs.getInt("id"));
	            formation.setNumSemestre(rs.getInt("numSemestre"));
	            formation.setChargeHoraire(rs.getDouble("chargeHoraire"));
	            formation.setLibelle(rs.getString("libelle"));
	      
	            formations.add(formation);
	        }
	        }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return formations;
	}
	
	public static Formation getFormation(int id){

		Formation formation = new Formation();
	    try {
	        Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
	        String query = "select * from formation where id = '"+id+"'";
	        ResultSet rs = st.executeQuery(query);
	       
	            formation.setNumSemestre(rs.getInt(1));
	            formation.setChargeHoraire(rs.getDouble(2));
	            formation.setLibelle(rs.getString(3));
	        
	        }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return formation;
	}

	public static int updateFormation(Formation formation, int id){
		int result;

		try {
			Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
			String query = "update formation set libelle='"+ formation.getLibelle() +"',chargeHoraire='"+formation.getChargeHoraire()+"',numSemestre='"+formation.getNumSemestre()+
					"' where id='"+id+"'";
			result = st.executeUpdate(query);
			return result;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}
	
	
	


