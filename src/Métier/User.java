package Métier;

public class User {
	    private String nom;
	    private String prenom;
	    private String cin;
	    private String email;
	    private String mdp_usr;
	    private String statut;

	    public User(String cin,String mdp_usr,String statut,String nom, String prenom,
	                String email) {
	        this.cin = cin;
	        this.nom = nom;
	        this.mdp_usr = mdp_usr;
	        this.prenom = prenom;
	        this.email = email;
	        this.statut = statut;
	    }

	    public User() {}

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public String getCin() {
	        return cin;
	    }

	    public void setCin(String cin) {
	        this.cin = cin;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getMdp_usr() {
	        return mdp_usr;
	    }

	    public void setMdp_usr(String mdp_usr) {
	        this.mdp_usr = mdp_usr;
	    }

	   

	    public String getStatut() {
	        return statut;
	    }

	    public void setStatut(String statut) {
	        this.statut = statut;
	    }

}
