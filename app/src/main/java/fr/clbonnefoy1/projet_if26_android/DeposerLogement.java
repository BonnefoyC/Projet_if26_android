package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeposerLogement extends AppCompatActivity {

    private Context mContext;

    private EditText et_label;
    private EditText et_prix;
    private EditText et_nb_pieces;
    private EditText et_ville;
    private EditText et_adresse;
    private EditText et_description;

    private Button bt_annuler;
    private Button bt_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposer_logement);

        mContext = this;

        et_label = (EditText)findViewById(R.id.et_label);
        et_prix = (EditText)findViewById(R.id.et_prix);
        et_nb_pieces = (EditText)findViewById(R.id.et_nb_pieces);
        et_ville = (EditText) findViewById(R.id.et_ville);
        et_adresse = (EditText)findViewById(R.id.et_adresse);
        et_description = (EditText)findViewById(R.id.et_description);

        bt_annuler = (Button)findViewById(R.id.bt_annuler);
        bt_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);

            }
        });
        bt_valider = (Button)findViewById(R.id.bt_valider);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModulePersistance mp = new ModulePersistance(mContext);

                String label = et_label.getText().toString();
                String description = et_description.getText().toString();
                int prix = Integer.parseInt(et_prix.getText().toString());
                int nb_pieces = Integer.parseInt(et_nb_pieces.getText().toString());
                String adresse = et_adresse.getText().toString();
                String ville = et_ville.getText().toString();
                double lat = 2.253656;
                double lng = 2.265356;
                int image_uri = R.drawable.logement1;
                String id_proprio = "4";


                Logement l = new Logement(
                        label,
                        description,
                        prix,
                        nb_pieces,
                        ville,
                        adresse,
                        lat,
                        lng,
                        image_uri,
                        id_proprio
                );

                mp.addLogement(l);

            }
        });
    }
}
