package Persistance;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Métier.User;

public class DAOUser  {
	public DAOUser(){}

    public static int addUser(User user) {
    	int result;
		try {
			user.setMdp_usr("mdp");
		Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
		String query = "insert into user values('"+user.getCin()+"','"+user.getMdp_usr()+"','"+user.getStatut()+"','"+user.getNom()+"','"+user.getPrenom()+"','"+user.getEmail()+"')";
		result = st.executeUpdate(query);
		return result;}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	
    }


    public static int delUser(String cin){

        int result;

        try{
            Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
            String query = "delete from User where cin='"+cin+"'";
            result = st.executeUpdate(query);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ArrayList<User> getAllUsers(){

    ArrayList<User> users = new ArrayList<User>();
    try {
        Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
        String query = "select * from user";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            User user = new User();
         
            user.setCin(rs.getString("cin"));
            user.setMdp_usr(rs.getString(2));
            user.setStatut(rs.getString(3));
            user.setNom(rs.getString(4));
            user.setPrenom(rs.getString(5));
            user.setEmail(rs.getString(6)); 
            
            users.add(user);
        }
        }
    catch (Exception e) {
        e.printStackTrace();
    }
    return users;
}

public static User getUser(String cin){
        User user = new User();
        ResultSet rs;
        try {
            Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
            String query = "select *from User where cin='"+cin+"'";
            rs = st.executeQuery(query);

            user.setCin(rs.getString(1));
            user.setMdp_usr(rs.getString(2));
            user.setStatut(rs.getString(3));
            user.setNom(rs.getString(4));
            user.setPrenom(rs.getString(5));
            user.setEmail(rs.getString(6));
          return user;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
}
public static int existUser(String cin){

    ResultSet rs = null;
    try {
        Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
        String query = "select * from User where cin='"+cin+"'";
        rs = st.executeQuery(query);
        if (!rs.next())
            return 0;
        return 1;}
    catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
}


public static int updateUser(User user,String cin){
    int result;
    try {
        Statement st = (Statement) ConnexionBD.getInstance().getConnexion().createStatement();
        System.out.println(user.getStatut());
        String query = "update user set cin='"+user.getCin()+"',nom='"+user.getNom()+"',prenom='"+user.getPrenom()
                +"',email='"+user.getEmail()+"',statut='"+user.getStatut()+"'where cin ='"+cin+"'";
        result = st.executeUpdate(query);
        return result;
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return -1;
}
}
