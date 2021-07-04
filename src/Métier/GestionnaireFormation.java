package Métier;

import java.util.ArrayList;

import Persistance.DAOFormation;


public class GestionnaireFormation {
	public static int ajouterFormation(Formation formation){
		 
        return DAOFormation.addFormation(formation);
    }

    public static ArrayList<Formation> getAllFormations(){
	    return DAOFormation.getAllFormations();
    }

     public static int supprimerFormation(int id) {

        return DAOFormation.delFormation(id);
     }

     public static int modifierFormation(Formation formation, int id){

	     return DAOFormation.updateFormation(formation,id);
    }

    public static Formation getFormation(int id) {
	      return DAOFormation.getFormation(id);
    }

}
