package Utils;

import java.awt.Component;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Utils {
	 //private static MessageDigest md;




	   /* public static Boolean regexVerifier(String regex,String ex) {

	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(ex);

	        if(matcher.matches() == true)
	            return true;
	        return false;
	    }*/


	    public static  void displayMessage(Component c,int i) {

	        if (i == 0)
	            JOptionPane.showMessageDialog(c, "*un utilisateur avec ce cin existe deja");
	        else if(i == -1)
	            JOptionPane.showMessageDialog(c, "*une erreur s'est produite lors de l'operation");
	    }

}
