package fr.clbonnefoy1.projet_if26_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Random;

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
    private int image_uri;
    private String id_proprio;
    private MarkerOptions markerOptions;

    private static Random r = new Random();

    public Logement(String label, String description, int prix, int nb_pieces, String ville, String adresse, double lat, double lng, int image_uri, String id_proprio) {
        this.label = label;
        this.description = description;
        this.prix = prix;
        this.nb_pieces = nb_pieces;
        this.ville = ville;
        this.adresse = adresse;
        this.lat = lat;
        this.lng = lng;
        this.image_uri = image_uri;
        this.id_proprio = id_proprio;
        markerOptions = new MarkerOptions().position(new LatLng(lat, lng)).title(label).snippet(String.format("Prix : %d", prix));
    }

    @Override
    public String toString() {
        return String.format("%s(%d, %d, %s, %s)", label, prix, nb_pieces, ville, adresse);
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

    public int getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(int image_uri) {
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
        liste.add(new Logement("Superbe T1", "Beau T1 dans résidence sécurisée.", 425, 1, "Troyes", "26 rue de la fédération", 48.302470, 4.054154, R.drawable.logement1, "1"));
        liste.add(new Logement("Studio neuf", "Studio rénové dans résidence récente avce garage.\nPossibilité de brancher une machine à laver.", 340, 1, "Troyes", "32 avenue de la république", 48.297058, 4.080536, R.drawable.logement2, "2"));
        liste.add(new Logement("Grand T2", "Particulier loue grand T2 dans résidence sécurisée avec vue sur le quai.\nPlein centre de Troyes et proche de toutes commoditées.", 520, 2, "Troyes", "Quai de Dampierre", 48.300852, 4.074747, R.drawable.logement2, "3"));
        liste.add(new Logement("Apt 70m2 résidence standing", "A louer appartement T3 rénové, en rez de chaussée surélevé de 70m2, très lumineux, sans vis-à-vis, dans une résidence standing avec gardien.", 465, 2, "Troyes", "26 rue du général leclerc", 48.299146, 4.077627, R.drawable.logement2, "4"));
        liste.add(new Logement("Belle grange centre ville", "Belle grange d'une surface de 175 m² proche centre ville des Noes près Troyes située rue Alexandre Lecorché.", 425, 1, "Troyes", "rue Alexandre Lecorché", 48.298682, 4.065992, R.drawable.logement2, "5"));
        liste.add(new Logement("Beau T1 + garage", "Loue appartement T1\nDans résidence de standing\nAvec parking privatif, portail, digicode, et ascenseur.", 425, 1, "Troyes", "42 rue de la cité", 48.299146, 4.077627, R.drawable.logement2, "6"));
        liste.add(new Logement("Spacieux Studio + garage", "Loue studio spacieux et lumineux à deux pas du centre ville.\nDeux grandes placards.\nCuisine équipée, salle de bain avec sèche serviette, digicode, et WC séparé.", 400, 1, "Troyes", "4 Rue Brunneval", 48.280408, 4.080018, R.drawable.logement2, "7"));
        liste.add(new Logement("Beau studio", "Studio meublé de 28 m² dans construction neuve, proche centre-ville, proche arrêt de bus.\nCuisine équipée (four, plaque de cuisson, table, chaises, placard penderie\nDisponible toute de suite.", 460, 1, "Troyes", "12 Rue Godard Pillaveine ", 48.278347, 4.078822, R.drawable.logement2, "8"));
        liste.add(new Logement("Superbe F2 ", "Belle pièce à vivre avec 2 doubles fenêtres, Cuisine ouverte aménagée avec plaques électriques, proche arrêt de bus.\nréfrigérateur, lave-vaisselle, éléments de rangements.\nLibre au 31/01/2018.", 450, 2, "Troyes", "22 rue Georges Clemenceau ", 48.2777806, 4.081190, R.drawable.logement2, "9"));
        liste.add(new Logement("Parking à louer ", "A louer, place de parking.\nLibre 1er janvier.", 110, 1, "Troyes", "9 Rue des Murots ", 48.278692, 4.082840, R.drawable.logement2, "10"));
        liste.add(new Logement("Grand Studio ", "Dans un petit immeuble ancien, au premier étage sans ascenseur, grand studio refait à neuf.\n.", 700, 1, "Troyes", "9 Rue Jean Neveu ", 48.280958, 4.077142, R.drawable.logement2, "11"));
        liste.add(new Logement("Joli et lumineux appartement ", "Ce studio est très lumineux , Cuisine ouverte aménagée avec plaques électriques\nIl se trouve au 7ème étage avec ascenseur dans une résidence sécurisée \nLibre au 31/02/2018.", 750, 2, "Troyes", "4 Rue Sancey ", 48.276937, 4.077549, R.drawable.logement2, "12"));
        liste.add(new Logement("F1 rénové", "Ce studio est très lumineux , Une chambre, pièce de vie avec grand espace cuisine tout équipé, verrière.\nDeuxième étage. Cave. Libre toute de suite.", 500, 1, "Troyes", "8 Avenue Général de Gaulle ", 48.276741, 4.081819, R.drawable.logement2, "13"));
        liste.add(new Logement("Studio rénové pour 2 personnes", "Cet appartement est situé au 2ème étage sans ascenseur d’un immeuble du quartier de la Bastille.\nCet appartement de style contemporain a été récemment entièrement rénové\nL’entrée s’ouvre sur un couloir menant à la pièce à vivre\nDisponible toute de suite.", 630, 3, "Troyes", "9 Rue Michel Ange", 48.277304, 4.077106, R.drawable.logement2, "14"));
        liste.add(new Logement("Beau F4", "Appartement lumineux proche centre-ville, commerces, écoles, troisième étage sans ascenseur.\nEntrée, cuisine indépendante, aménagée et équipée (hotte, four plaque vitro), 2 chambres séparées par salle de bain (baignoire) et WC, séjour, salon. Sol carrelé, volets roulants et fenêtres double vitrage, placards.\nInterphone, cave, local vélos. Libre au 31.12.2017.", 620, 3, "Troyes", "7 Rue Preize ", 48.274764, 4.079449, R.drawable.logement2, "15"));
        liste.add(new Logement("Joli F2", "Appartement T2 60 m2 lumineux avec cave dans petite copropriété au 1er étage dans quartier calme et agréable.\nEntrée avec placard, cuisine aménagée et équipée (four, plaque cuisson, hotte, frigo, lave-linge).\nParking privatif et ascenseur.", 510, 3, "Saint André Les vergers", "9 Rue Agenor Cortier", 48.272066, 4.079207, R.drawable.logement2, "24"));
        liste.add(new Logement("Location garage", "A louer Garage Box de stockage d’environ 14m2.\nIls disposent d'une porte métallique très solide (serrure neuve).\nGarage Bétonné au sol ce qui peut permettre de stocker des meubles ou des affaires.", 200, 1, "Troyes", "5 Rue Edouard Herriot", 48.274415, 4.076462, R.drawable.logement2, "16"));
        liste.add(new Logement("Maisonnette avec terrace", "Une maisonnette indépendante F1 de 35 m2.\nMeublé ou non à votre choix tout confort.\nRéfrigérateur, lave-vaisselle, éléments de rangements\nUne terrasse privée et place de parking dans cour ferméeLibre au 30/02/2018.", 600, 3, "Troyes", "10 Rue Rocade ", 48.273881, 4.078674, R.drawable.logement2, "13"));
        liste.add(new Logement("Neuf appartement ", "Belle pièce à vivre avec 2 doubles fenêtres, A LOUER T1 de 25 m2 à Troyes à proximité de L'ESC, de l'école d'infirmiers et des IUT et UTT\nréfrigérateur, lave-vaisselle, éléments de rangements.\nL'IMMEUBLE est sécurisé, propre et calme.", 450, 2, "Troyes", "2 Rue Edouard Herriot ", 48.272665, 4.077363, R.drawable.logement2, "14"));
        liste.add(new Logement("Beau T2 centre-ville ", "Beau T2 dans copropriété close au 2ème étage avec ascenseur comprenant une superficie de 36 m2.\nChauffage électrique individuel et eau chaude par cumulus.\nLibre le premier février 2018.", 410, 2, "Troyes", "26 Rue de la fédération", 48.273659, 4.076474, R.drawable.logement2, "20"));
        liste.add(new Logement("Pavillon 4 pièces", "Proche de tous commerces, dans un environnement calme, maison de 74 m² sur sous-sol complet, composé d'une entrée, séjour double, cuisine, 2 chambres, salle de bains, WC, rangements\nCuisine équipée (four, plaque de cuisson, table, chaises.\nDisponible toute de suite.", 800, 4, "Troyes", "13 Rue Baltet ", 48.273333, 4.073667, R.drawable.logement2, "15"));
        liste.add(new Logement("Appartement T2", "Appartement refais à neuf\n" + "Cuisine équipée.\n, proche centre-ville, proche arrêt de bus.\nDisponible toute de suite.", 380, 2, "Troyes", "11 Rue Nicolas Siret ", 48.273440, 4.078541, R.drawable.logement2, "11"));
        liste.add(new Logement("Agréable Studio", "À louer un joli T1 dans la commune de Saint André les Vergers , Il est composé d'une entrée donnant sur une salle d'eau, un WC séparé et menant vers la pièces principale à vivre avec kitchenette.", 390, 3, "Saint-André Les Vergers", "5 Rue de la Paix", 48.277789, 4.077682, R.drawable.logement2, "10"));

        return liste;

    }

    public static int getRessourceImageId() {

        int n = Logement.r.nextInt(24);

        Log.i("alea", String.format("%d",n));

        switch(n) {
            case 1 :
                return R.drawable.logement1;
            case 2 :
                return R.drawable.logement2;
            case 3 :
                return R.drawable.logement3;
            case 4 :
                return R.drawable.logement4;
            case 5 :
                return R.drawable.logement5;
            case 6 :
                return R.drawable.logement6;
            case 7 :
                return R.drawable.logement7;
            case 8 :
                return R.drawable.logement8;
            case 9 :
                return R.drawable.logement9;
            case 10 :
                return R.drawable.logement10;
            case 11 :
                return R.drawable.logement11;
            case 12 :
                return R.drawable.logement12;
            case 13 :
                return R.drawable.logement13;
            case 14 :
                return R.drawable.logement14;
            case 15 :
                return R.drawable.logement15;
            case 16 :
                return R.drawable.logement16;
            case 17 :
                return R.drawable.logement17;
            case 18 :
                return R.drawable.logement18;
            case 19 :
                return R.drawable.logement19;
            case 20 :
                return R.drawable.logement20;
            case 21 :
                return R.drawable.logement21;
            default:
                return R.drawable.logement22;
        }
    }

}