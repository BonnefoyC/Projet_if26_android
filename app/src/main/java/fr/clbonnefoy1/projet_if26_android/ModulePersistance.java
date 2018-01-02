package fr.clbonnefoy1.projet_if26_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.webkit.ConsoleMessage;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.util.ArrayList;

import static android.R.attr.label;

/**
 * Created by Clément on 07/11/2017.
 */

public class ModulePersistance extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Logements.db";

    //LOGEMENTS
    private static final String TABLE_LOGEMENTS="logement";
    private static final String ATTRIBUT_LABEL = "label";
    private static final int NUM_COL_LABEL = 0;
    private static final String ATTRIBUT_NB_PIECES = "nb_pieces";
    private static final int NUM_COL_NB_PIECES = 1;
    private static final String ATTRIBUT_PRIX = "prix";
    private static final int NUM_COL_PRIX = 2;
    private static final String ATTRIBUT_DESCRIPTION = "description";
    private static final int NUM_COL_DESCRIPTION = 3;
    private static final String ATTRIBUT_VILLE = "ville";
    private static final int NUM_COL_VILLE = 4;
    private static final String ATTRIBUT_ADRESSE = "adresse";
    private static final int NUM_COL_ADRESSE = 5;
    private static final String ATTRIBUT_LATITUDE = "latitude";
    private static final int NUM_COL_LATITUDE = 6;
    private static final String ATTRIBUT_LONGITUDE = "longitude";
    private static final int NUM_COL_LONGITUDE = 7;
    private static final String ATTRIBUT_IMAGE_URI = "image_uri";
    private static final int NUM_COL_IMAGE_URI = 8;
    private static final String ATTRIBUT_ID_PROPRIO = "id_proprio";
    private static final int NUM_COL_ID_PROPRIO = 9;

    //PROPRIETAIRES
    private static final String TABLE_PROPRIETAIRES="proprietaire";
    private static final String ATTRIBUT_ID = "id";
    private static final int NUM_COL_ID = 0;
    private static final String ATTRIBUT_NOM = "nom";
    private static final int NUM_COL_NOM = 1;
    private static final String ATTRIBUT_EMAIL = "email";
    private static final int NUM_COL_EMAIL = 2;
    private static final String ATTRIBUT_TEL = "tel";
    private static final int NUM_COL_TEL = 3;

    public ModulePersistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_module_create =
                "CREATE TABLE " + TABLE_LOGEMENTS + "(" +
                        ATTRIBUT_LABEL + " TEXT primary key," +
                        ATTRIBUT_NB_PIECES + " TEXT, " +
                        ATTRIBUT_PRIX + " INTEGER, " +
                        ATTRIBUT_DESCRIPTION + " TEXT," +
                        ATTRIBUT_VILLE + " TEXT," +
                        ATTRIBUT_ADRESSE + " TEXT," +
                        ATTRIBUT_LATITUDE + " TEXT," +
                        ATTRIBUT_LONGITUDE + " TEXT," +
                        ATTRIBUT_IMAGE_URI + " INTEGER," +
                        ATTRIBUT_ID_PROPRIO + " TEXT" +
                        ")";
        db.execSQL(table_module_create);

        table_module_create =
                "CREATE TABLE " + TABLE_PROPRIETAIRES + "(" +
                        ATTRIBUT_ID + " TEXT primary key," +
                        ATTRIBUT_NOM + " TEXT, " +
                        ATTRIBUT_EMAIL + " TEXT, " +
                        ATTRIBUT_TEL + " TEXT" +
                        ")";
        db.execSQL(table_module_create);
    }

    public void addLogement(Logement l) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(ATTRIBUT_LABEL, l.getLabel());
        cv.put(ATTRIBUT_NB_PIECES, l.getNb_pieces());
        cv.put(ATTRIBUT_PRIX, l.getPrix());
        cv.put(ATTRIBUT_DESCRIPTION, l.getDescription());
        cv.put(ATTRIBUT_VILLE, l.getVille());
        cv.put(ATTRIBUT_ADRESSE, l.getAdresse());
        cv.put(ATTRIBUT_LATITUDE, Double.toString(l.getLat()));
        cv.put(ATTRIBUT_LONGITUDE, Double.toString(l.getLng()));
        cv.put(ATTRIBUT_IMAGE_URI, l.getImage_uri());
        cv.put(ATTRIBUT_ID_PROPRIO, l.getId_proprio());

        db.insert(TABLE_LOGEMENTS, null, cv);

        db.close();
    }

    private byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_LOGEMENTS + ";");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PROPRIETAIRES + ";");
        onCreate(db);
    }

    public Logement getLogement(String label) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_LOGEMENTS, new String[] {ATTRIBUT_LABEL, ATTRIBUT_NB_PIECES, ATTRIBUT_PRIX, ATTRIBUT_DESCRIPTION,ATTRIBUT_VILLE,ATTRIBUT_ADRESSE,ATTRIBUT_LATITUDE,ATTRIBUT_LONGITUDE,ATTRIBUT_IMAGE_URI, ATTRIBUT_ID_PROPRIO}, ATTRIBUT_LABEL + " LIKE \"%" + label + "%\"",null, null, null, null);
        return cursorToLogement(c);
    }

    private Logement cursorToLogement(Cursor c) {
        if (c.getCount() == 0) {
            return null;
        }

        c.moveToFirst();



        Logement l = new Logement(c.getString(NUM_COL_LABEL),
                c.getString(NUM_COL_DESCRIPTION),
                c.getInt(NUM_COL_PRIX),
                c.getInt(NUM_COL_NB_PIECES),
                c.getString(NUM_COL_VILLE),
                c.getString(NUM_COL_ADRESSE),
                c.getDouble(NUM_COL_LATITUDE),
                c.getDouble(NUM_COL_LONGITUDE),
                c.getInt(NUM_COL_IMAGE_URI),
                c.getString(NUM_COL_ID_PROPRIO));
        c.close();

        return l;
    }

    public ArrayList<Logement> getAllLogements() {

        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(TABLE_LOGEMENTS, new String[] {ATTRIBUT_LABEL, ATTRIBUT_NB_PIECES, ATTRIBUT_PRIX, ATTRIBUT_DESCRIPTION, ATTRIBUT_VILLE, ATTRIBUT_ADRESSE, ATTRIBUT_LATITUDE, ATTRIBUT_LONGITUDE,ATTRIBUT_IMAGE_URI, ATTRIBUT_ID_PROPRIO}, null, null, null, null, null);

        ArrayList<Logement> liste_logement= new ArrayList<>();


        if (c.moveToFirst()) {
            do {
                Logement l = new Logement(c.getString(NUM_COL_LABEL),
                        c.getString(NUM_COL_DESCRIPTION),
                        c.getInt(NUM_COL_PRIX),
                        c.getInt(NUM_COL_NB_PIECES),
                        c.getString(NUM_COL_VILLE),
                        c.getString(NUM_COL_ADRESSE),
                        c.getDouble(NUM_COL_LATITUDE),
                        c.getDouble(NUM_COL_LONGITUDE),
                        c.getInt(NUM_COL_IMAGE_URI),
                        c.getString(NUM_COL_ID_PROPRIO));
                // Adding contact to list
                liste_logement.add(l);
            } while (c.moveToNext());
        }

        c.close();

        db.close();

        return liste_logement;
    }

    public void deleteLogement(String label){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_LOGEMENTS, ATTRIBUT_LABEL + " = " + label, null);
    }

    public int getLogementCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_LOGEMENTS, new String[] {ATTRIBUT_LABEL, ATTRIBUT_NB_PIECES, ATTRIBUT_PRIX, ATTRIBUT_DESCRIPTION,ATTRIBUT_VILLE,ATTRIBUT_ADRESSE,ATTRIBUT_LATITUDE,ATTRIBUT_LONGITUDE,ATTRIBUT_IMAGE_URI, ATTRIBUT_ID_PROPRIO}, null,null, null, null, null);
        int nb_module = c.getCount();
        c.close();
        return nb_module;
    }

    public void addProprietaire(Proprietaire p){
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(ATTRIBUT_ID, p.getId_proprio());
        cv.put(ATTRIBUT_NOM, p.getNom());
        cv.put(ATTRIBUT_EMAIL, p.getEmail());
        cv.put(ATTRIBUT_TEL, p.getTel());

        db.insert(TABLE_PROPRIETAIRES, null, cv);

        db.close();
    }

    public Proprietaire getProprietaire(String id_proprio) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_PROPRIETAIRES, new String[] {ATTRIBUT_ID, ATTRIBUT_NOM, ATTRIBUT_EMAIL, ATTRIBUT_TEL}, ATTRIBUT_ID + " LIKE \"%" + id_proprio + "%\"",null, null, null, null);
        return cursorToProprietaire(c);
    }

    private Proprietaire cursorToProprietaire(Cursor c) {
        if (c.getCount() == 0) {
            return null;
        }

        c.moveToFirst();

        Proprietaire p = new Proprietaire(c.getString(NUM_COL_ID),
                c.getString(NUM_COL_NOM),
                c.getString(NUM_COL_EMAIL),
                c.getString(NUM_COL_TEL));
        c.close();

        return p;
    }
}
