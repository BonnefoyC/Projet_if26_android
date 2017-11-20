package fr.clbonnefoy1.projet_if26_android;

import android.graphics.Bitmap;

/**
 * Created by Clément on 20/11/2017.
 */

public class Logement {

    private String label;
    private String description;
    private int prix;
    private int nb_pieces;
    private String ville;
    private String adresse;
    private long lat;
    private long lng;
    private Bitmap image;

    public Logement(String label, String description, int prix, int nb_pieces, String ville, String adresse, long lat, long lng, Bitmap image) {
        this.label = label;
        this.description = description;
        this.prix = prix;
        this.nb_pieces = nb_pieces;
        this.ville = ville;
        this.adresse = adresse;
        this.lat = lat;
        this.lng = lng;
        this.image = image;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNb_pieces() {
        return nb_pieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
