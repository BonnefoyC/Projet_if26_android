package fr.clbonnefoy1.projet_if26_android;

/**
 * Created by Clément on 02/01/2018.
 */

public class Compte {

    private static String nom = "Clément BONNEFOY";

    private static String email = "clement.bonnefoy@utt.fr";

    private static String tel = "0653262448";

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        Compte.nom = nom;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Compte.email = email;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        Compte.tel = tel;
    }
}
