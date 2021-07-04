package Métier;

import java.util.ArrayList;

import Persistance.DAOUser;

public class GestionnaireUser {
	
	 public static int ajouterUser(User user){
	        int exist;
	        exist = GestionnaireUser.existUser(user.getCin());
	        if (exist == 1)
	            return 0;
	        else if(exist == -1)
	            return -1;
	       else
	            return DAOUser.addUser(user);
	 }
	 
	 public static ArrayList<User> getAllUsers(){

	        return DAOUser.getAllUsers();

	 }
	 
	 public static int supprimerUser(String cin) {

	        return DAOUser.delUser(cin);
	 }

	 public static User getUser(String cin) {

	        return DAOUser.getUser(cin);
	 }

	 public static int existUser(String cin) {

	        return DAOUser.existUser(cin);
	 }
	 public static int modifierUser(User user,String cin){
	        int exist;
	        if (!cin.equals(user.getCin())){
	            exist = DAOUser.existUser(user.getCin());
	            if (exist == 1)
	                return 0;
	            else if (exist == -1)
	                return -1;
	        }
	        return DAOUser.updateUser(user,cin);
     }
}
