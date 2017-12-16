package fr.clbonnefoy1.projet_if26_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

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
    private double lat;
    private double lng;
    private String image_uri;
    private String id_proprio;
    private MarkerOptions markerOptions;

    public Logement(String label, String description, int prix, int nb_pieces, String ville, String adresse, double lat, double lng, String image_uri, String id_proprio) {
        this.label = label;
        this.description = description;
        this.prix = prix;
        this.nb_pieces = nb_pieces;
        this.ville = ville;
        this.adresse = adresse;
        this.lat = lat;
        this.lng = lng;
        this.image_uri = image_uri; //TODO Test les uris
        this.id_proprio = id_proprio;
        markerOptions = new MarkerOptions().position(new LatLng(lat, lng)).title(label).snippet(String.format("Prix : %d", prix));
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d, %s, %s)",label, prix, nb_pieces, ville, adresse);
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public MarkerOptions getMarkerOptions() {
        return markerOptions;
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        this.markerOptions = markerOptions;
    }

    public String getId_proprio() {
        return id_proprio;
    }

    public void setId_proprio(String id_proprio) {
        this.id_proprio = id_proprio;
    }

    public static ArrayList<Logement> getInitialLogements() {
        ArrayList<Logement> liste = new ArrayList<>();
        liste.add(new Logement("Superbe T1", "Beau T1 dans résidence sécurisée.", 425, 1, "Troyes", "26 rue de la fédération", 48.302470, 4.054154, "uri", "1"));
        liste.add(new Logement("Studio neuf", "Studio rénové dans résidence récente avce garage.\nPossibilité de brancher une machine à laver.", 340, 1, "Troyes", "32 avenue de la république", 48.297058, 4.080536, "uri", "2"));
        liste.add(new Logement("Grand T2", "Particulier loue grand T2 dans résidence sécurisée avec vue sur le quai.\nPlein centre de Troyes et proche de toutes commoditées.", 520, 2, "Troyes", "Quai de Dampierre", 48.300852, 4.074747, "uri", "1"));
        liste.add(new Logement("Apt 70m2 résidence standing", "A louer appartement T3 rénové, en rez de chaussée surélevé de 70m2, très lumineux, sans vis-à-vis, dans une résidence standing avec gardien.", 465, 2, "Troyes", "26 rue du général leclerc", 48.299146, 4.077627, "uri", "3"));
        liste.add(new Logement("Belle grange centre ville", "Belle grange d'une surface de 175 m² proche centre ville des Noes près Troyes située rue Alexandre Lecorché.", 425, 1, "Troyes", "rue Alexandre Lecorché", 48.298682, 4.065992, "uri", "2"));
        liste.add(new Logement("Beau T1 + garage", "Loue appartement T1\nDans résidence de standing\nAvec parking privatif, portail, digicode, et ascenseur.", 425, 1, "Troyes", "42 rue de la cité", 48.299146, 4.077627, "uri", "4"));
        return liste;
    }
}
