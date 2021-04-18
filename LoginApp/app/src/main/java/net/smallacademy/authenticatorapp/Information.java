package net.smallacademy.authenticatorapp;

public class Information {


 String nomFournisseur, entreprise, nomClient,nomProduit,   prenomClient, email ;

 String telephone, numCommande, poids;
/*
    private String nomFournisseur;
    private String entreprise;
    private String nomClient;
    private String prenomClient;
    private String email;
    private int telephone;
    private int numCommande;
    private String nomProduit;
    private int poids;
*/
    public Information() {
    }

    public Information(String nomFournisseur, String entreprise, String nomClient, String nomProduit, String prenomClient, String email, String telephone, String numCommande, String poids) {
        this.nomFournisseur = nomFournisseur;
        this.entreprise = entreprise;
        this.nomClient = nomClient;
        this.nomProduit = nomProduit;
        this.prenomClient = prenomClient;
        this.email = email;
        this.telephone = telephone;
        this.numCommande = numCommande;
        this.poids = poids;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }
}
