package presentation.Controleur;

import java.util.ArrayList;

import Métier.Formation;
import Métier.GestionnaireFormation;
import Métier.GestionnaireUser;
import Métier.User;
import presentation.Beans.userBean;
import presentation.Models.ModelFormation;
import presentation.Models.ModelUser;
import presentation.Vue.VueAddFormation;
import presentation.Vue.VueAddUser;
import presentation.Vue.VueGestionFormation;
import presentation.Vue.VueGestionUser;
import presentation.Vue.VueModifierFormation;
import presentation.Vue.VueModifierUser;

public class ControleurGestionFormation {
	private ModelFormation model;
	private VueAddFormation vueAddFor;
	private VueGestionFormation vueGestionFormation;
	private VueModifierFormation vueModifierFormation;
	private ArrayList<Formation> formations;
	
     public ControleurGestionFormation() {  	 
         formations = GestionnaireFormation.getAllFormations();
         //System.out.println(formations.get(0).getLibelle());
         model = new ModelFormation(formations);
         vueGestionFormation = new VueGestionFormation(model);
     }
     
     public void genererVueAjout(){
         vueAddFor = new VueAddFormation();
         vueAddFor.setControleur(this);
         vueAddFor.setVisible(true);
     }

    public void genereVueModification(int rowIndex){
        this.vueModifierFormation = new VueModifierFormation();
        //this.vueModifierFormation.setControleur(this);
        displayFormationInfos(formations.get(rowIndex));
        vueModifierFormation.setId(formations.get(rowIndex).getId());
        vueModifierFormation.setVisible(true);
    }

    public void displayFormationInfos(Formation formation){
        vueModifierFormation.getTxtLibelle().setText(formation.getLibelle());
        vueModifierFormation.getTxtCharge().setText(formation.getChargeHoraire().toString());
        vueModifierFormation.getTxtNum().setText(formation.getNumSemestre().toString());
    }

    public int ajouterFormation(Formation formation)
     {
         int result = GestionnaireFormation.ajouterFormation(formation);
         if(result == 1) {
             formations = GestionnaireFormation.getAllFormations();
             model.setFormations(formations);
             model.fireTableRowsInserted(0,formations.size()-1);
             model.fireTableDataChanged();
         }
         else
         {
             System.out.println("non");
         }
         return result;
     }

    public int modifierFormation(Formation formation, int id)
    {
        int result = GestionnaireFormation.modifierFormation(formation, id);
        if (result == 1) {
            formations = GestionnaireFormation.getAllFormations();
            model.setFormations(formations);
            model.fireTableDataChanged();
        }
        return result;
    }

     public void supprimerFormation(int id) {

         GestionnaireFormation.supprimerFormation(id);
         formations = GestionnaireFormation.getAllFormations();
         model.setFormations(formations);
         model.fireTableRowsDeleted(0,formations.size()-1);
         model.fireTableDataChanged();
     }

	public VueGestionFormation getVueGestionFormation() {
		return vueGestionFormation;
	}

	public void setVueGestionFormation(VueGestionFormation vueGestionFormation) {
		this.vueGestionFormation = vueGestionFormation;
	}
	
	
     
	

}
