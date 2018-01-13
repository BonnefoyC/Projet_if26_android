package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Field;

import static fr.clbonnefoy1.projet_if26_android.R.drawable.logement1;
import static fr.clbonnefoy1.projet_if26_android.R.id.tv_label;

public class Details extends AppCompatActivity {

    private Context mContext;

    private Logement logement_courant;

    private TextView tv_label;
    private TextView tv_prix;
    private TextView tv_ville;
    private TextView tv_nb_pieces;
    private TextView tv_adresse;
    private TextView tv_description;
    private ImageView im_logement;

    private Button bt_contact;
    private Button bt_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mContext = this;

        Intent intent = getIntent();
        String label= intent.getStringExtra("label");

        ModulePersistance mp=new ModulePersistance(this);
        logement_courant = mp.getLogement(label);

        tv_label = (TextView)findViewById(R.id.tv_label);
        tv_label.setText(logement_courant.getLabel());

        tv_prix = (TextView)findViewById(R.id.tv_prix);
        tv_prix.setText(String.format("%d€", logement_courant.getPrix()));

        tv_ville = (TextView)findViewById(R.id.tv_ville);
        tv_ville.setText(logement_courant.getVille());

        tv_nb_pieces = (TextView)findViewById(R.id.tv_nb_pieces);
        tv_nb_pieces.setText(String.format("%d",logement_courant.getNb_pieces()));

        tv_adresse = (TextView)findViewById(R.id.tv_adresse);
        tv_adresse.setText(logement_courant.getAdresse());

        tv_description = (TextView)findViewById(R.id.tv_description);
        tv_description.setText(logement_courant.getDescription());

        im_logement = (ImageView)findViewById(R.id.im_logement);

        im_logement.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(),
                logement_courant.getImage_uri()));

        bt_contact = (Button)findViewById(R.id.bt_contact);
        bt_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Contact.class);
                intent.putExtra("id_proprio",logement_courant.getId_proprio());
                startActivity(intent);
            }
        });

        bt_retour = (Button)findViewById(R.id.bt_retour);
        bt_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
