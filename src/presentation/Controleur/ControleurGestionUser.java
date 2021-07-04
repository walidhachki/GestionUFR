package presentation.Controleur;

import java.util.ArrayList;

import Métier.GestionnaireUser;
import Métier.User;
import presentation.Beans.userBean;
import presentation.Models.ModelUser;
import presentation.Vue.VueAddUser;
import presentation.Vue.VueGestionUser;
import presentation.Vue.VueModifierUser;
import Persistance.DAOUser;

public class ControleurGestionUser {
	 private VueGestionUser vueGestionUser;
     private VueAddUser vueAddUser;
     private VueModifierUser vueModifierUser;
     private ArrayList<User> users;
     private ModelUser model;


     public ControleurGestionUser() {
    	 
         users = GestionnaireUser.getAllUsers();
         model = new ModelUser(users);
         vueGestionUser = new VueGestionUser(model);
     }
     
     
    public void genererVueAjout(){
         vueAddUser = new VueAddUser();
         vueAddUser.setControleur(this);
         vueAddUser.setVisible(true);
     }
    
     public void genereVueModification(int rowIndex){
         this.vueModifierUser = new VueModifierUser();
         vueModifierUser.setControleur(this);
         displayUserInfos(users.get(rowIndex));
         vueModifierUser.setVisible(true);
     }



     public int ajouterUser(userBean bean)
     {
         int result = GestionnaireUser.ajouterUser(beanToUser(bean));
         if(result == 1) {
             users = GestionnaireUser.getAllUsers();
             model.setUsers(users);
             model.fireTableRowsInserted(0,users.size()-1);
             model.fireTableDataChanged();
         }
         return result;
     }

    public void supprimerUser(String cin) {

         GestionnaireUser.supprimerUser(cin);
         users = GestionnaireUser.getAllUsers();
         model.setUsers(users);
         model.fireTableRowsDeleted(0,users.size()-1);
         model.fireTableDataChanged();
     }

     public int modifierUser(userBean bean,String cin)
     {
         int result = GestionnaireUser.modifierUser(beanToUser(bean), cin);
         if (result == 1) {
             users = GestionnaireUser.getAllUsers();
             model.setUsers(users);
             model.fireTableDataChanged();
         }
         return result;
     }

     


    public void displayUserInfos(User user){
         vueModifierUser.getTxtCin().setText(user.getCin());
         vueModifierUser.getTxtNom().setText(user.getNom());
         vueModifierUser.getTxtPrenom().setText(user.getPrenom());
         vueModifierUser.getTxtEmail().setText(user.getEmail());
         if (user.getStatut().equals("Professeur"))
             vueModifierUser.getcStatut().setSelectedIndex(2);
         else if (user.getStatut().equals("Doctorant"))
             vueModifierUser.getcStatut().setSelectedIndex(1);
         else if (user.getStatut().equals("Etudiant"))
             vueModifierUser.getcStatut().setSelectedIndex(0);
     }
     public User beanToUser(userBean bean) {

         User user = new User();
         user.setCin(bean.getCin());
         user.setNom(bean.getNom());
         user.setPrenom(bean.getPrenom());
         user.setEmail(bean.getEmail());
         user.setStatut(bean.getStatut());
         return user;
     }

     public VueGestionUser getVueGestionUser() {
         return vueGestionUser;
     }

     public void setVueGestionUser(VueGestionUser vueGestionUser) {
         this.vueGestionUser = vueGestionUser;
     }

    public VueAddUser getVueAddUser() {
         return vueAddUser;
     }

     public void setVueAddUser(VueAddUser vueAddUser) {
         this.vueAddUser = vueAddUser;
     }


}
