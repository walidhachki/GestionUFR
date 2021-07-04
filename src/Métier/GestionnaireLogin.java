package Métier;

public class GestionnaireLogin {

	public int isValide(String username, String password) 
	{
		if(username.equals("admin") && password.equals("admin"))
			return 1;
		else
			return -1;
	}
}
