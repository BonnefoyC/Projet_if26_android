package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class DeposerLogement extends AppCompatActivity {

    private Context mContext;

    private EditText et_label;
    private EditText et_prix;
    private EditText et_nb_pieces;
    private EditText et_ville;
    private EditText et_adresse;
    private EditText et_description;

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

        bt_valider = (Button)findViewById(R.id.bt_valider);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ModulePersistance mp = new ModulePersistance(mContext);

                String label = et_label.getText().toString();
                String description = et_description.getText().toString();
                String sprix = et_prix.getText().toString();
                String snb_pieces = et_nb_pieces.getText().toString();
                String adresse = et_adresse.getText().toString();
                String ville = et_ville.getText().toString();
                String id_proprio = Compte.getId();

                if (label.equals("") || description.equals("") || sprix.equals("") || snb_pieces.equals("") || adresse.equals("") || ville.equals("") || id_proprio.equals("")) {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_deposer);
                    Snackbar.make(mRootView, "Tous les champs sont obligatoires !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }


                int prix = Integer.parseInt(et_prix.getText().toString());

                if (prix < 1 || prix > 200000) {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_deposer);
                    Snackbar.make(mRootView, "Prix invalides !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                int nb_pieces = Integer.parseInt(et_nb_pieces.getText().toString());
                if (nb_pieces < 1 || nb_pieces > 20) {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_deposer);
                    Snackbar.make(mRootView, "Nombre de pièces invalides !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
                double lat = 2.253656;
                double lng = 2.265356;
                int image_uri = R.drawable.logo_small;


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

                et_label.setEnabled(false);
                et_prix.setEnabled(false);
                et_nb_pieces.setEnabled(false);
                et_ville.setEnabled(false);
                et_adresse.setEnabled(false);
                et_description.setEnabled(false);

                LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_deposer);
                Snackbar.make(mRootView, "Votre annonce a bien été ajoutée !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                bt_valider.setText("Retour");
                bt_valider.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
