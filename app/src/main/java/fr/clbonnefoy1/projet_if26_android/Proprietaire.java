package fr.clbonnefoy1.projet_if26_android;

import java.util.ArrayList;

/**
 * Created by Clément on 10/12/2017.
 */

public class Proprietaire {

    private String id_proprio;
    private String nom;
    private String email;
    private String tel;

    public Proprietaire(String id_proprio, String nom, String email, String tel) {
        this.id_proprio = id_proprio;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
    }

    public String getId_proprio() {
        return id_proprio;
    }

    public void setId_proprio(String id_proprio) {
        this.id_proprio = id_proprio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public static ArrayList<Proprietaire> getInitialProprietaires(){
        ArrayList<Proprietaire> liste = new ArrayList<>();
        liste.add(new Proprietaire("1", "Marc LEMERCIER", "marc.lemercier@utt.fr", "0456899636"));
        liste.add(new Proprietaire("2", "Jean-Marc NIGRO", "jean_marc.nigro@utt.fr", "0425358595"));
        liste.add(new Proprietaire("3", "Guillaume DOYEN", "guillaue.doyen@utt.fr", "0423512867"));
        liste.add(new Proprietaire("4", "Clément BONNEFOY", "clement.bonnefoy@utt.fr", "0464532621"));
        return liste;
    }
}
