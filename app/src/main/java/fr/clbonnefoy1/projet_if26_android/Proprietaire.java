package fr.clbonnefoy1.projet_if26_android;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by Clément on 10/12/2017.
 */

public class Proprietaire {

    private String id_proprio;
    private String nom;
    private String email;
    private String tel;
    private String pass;

    public Proprietaire(String id_proprio, String nom, String email, String tel, String pass) {
        this.id_proprio = id_proprio;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", id_proprio, nom, email, tel, pass);
    }

    public static ArrayList<Proprietaire> getInitialProprietaires(){
        ArrayList<Proprietaire> liste = new ArrayList<>();
        liste.add(new Proprietaire("1", "Marc LEMERCIER", "marc.lemercier@utt.fr", "0456899636", "utt"));
        liste.add(new Proprietaire("2", "Jean-Marc NIGRO", "jean_marc.nigro@utt.fr", "0425358595", ""));
        liste.add(new Proprietaire("3", "Guillaume DOYEN", "guillaume.doyen@utt.fr", "0423512867", ""));
        liste.add(new Proprietaire("4", "Clément BONNEFOY", "clement.bonnefoy@utt.fr", "0464532621", "if2617"));
        liste.add(new Proprietaire("5", "Céline georges", "céline.georges@gmail.com", "0464535555", ""));
        liste.add(new Proprietaire("6", "Christine Dupond", "christine.dupond@gmail.com", "0461245621", ""));
        liste.add(new Proprietaire("7", "Michel Pakiry", "michel.pakiry@hotmail.fr", "0763532621", ""));
        liste.add(new Proprietaire("8", "Sarra Chatelet", "sarra.chatelet@gmail.com", "0461290621", ""));
        liste.add(new Proprietaire("9", "Chloé Robert", "chloé.robert@hotmail.fr", "0461782391", ""));
        liste.add(new Proprietaire("10", "Sarra Petit", "sarra.petit@gmail.com", "0464536634", ""));
        liste.add(new Proprietaire("11", "Marie Girard", "marie.Girard@utt.fr", "0461767621", ""));
        liste.add(new Proprietaire("12", "Philippe Roux", "philippe.roux@gmail.com", "0462220621", ""));
        liste.add(new Proprietaire("13", "Sandra Joly", "sandra.joly@gmail.com", "1678032621", ""));
        liste.add(new Proprietaire("14", "Philippe Roux", "philippe.roux@gmail.com", "0462220621", ""));
        liste.add(new Proprietaire("15", "Michel Laurant ", "michel.laurant@gmail.com", "0465534621", ""));
        liste.add(new Proprietaire("16", "Clement Lambert ", "Clement.lambert@gmail.com", "0765534621", ""));
        return liste;
    }
}
