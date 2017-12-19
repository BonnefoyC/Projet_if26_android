package fr.clbonnefoy1.projet_if26_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsLogement extends AppCompatActivity {

    private TextView tv_label;
    private TextView tv_nbre_pieces;
    private TextView tv_ville;
    private TextView tv_prix;
    private TextView tv_description;

    @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_logement);

        Intent intent = getIntent();

        Log.i("DetailsLogement", intent.getStringExtra("label"));

        tv_label = (TextView)findViewById(R.id.tv_label);
        tv_prix =  (TextView)findViewById(R.id.tv_prix);
        tv_nbre_pieces = (TextView)findViewById(R.id.tv_nbre_pieces);
        tv_description = (TextView)findViewById(R.id.tv_description);
        tv_ville = (TextView)findViewById(R.id.tv_ville);

    }
}
