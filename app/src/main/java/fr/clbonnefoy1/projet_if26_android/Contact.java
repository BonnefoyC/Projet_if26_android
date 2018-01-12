package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Contact extends AppCompatActivity {

    private Context mContext;

    private Proprietaire proprietaire;

    private TextView tv_proprio;

    private EditText et_nom;
    private EditText et_email;
    private EditText et_message;

    private Button bt_envoyer;

    private LinearLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mContext = this;

        Intent intent = getIntent();
        String id_proprio = intent.getStringExtra("id_proprio");

        ModulePersistance mp = new ModulePersistance(this);

        proprietaire = mp.getProprietaire(id_proprio);

        tv_proprio = (TextView)findViewById(R.id.tv_proprio);
        tv_proprio.setText(String.format("Envoyer un email à \"%s\" :", proprietaire.getNom()));

        et_nom = (EditText)findViewById(R.id.et_nom);
        et_email = (EditText)findViewById(R.id.et_email);
        et_message = (EditText)findViewById(R.id.et_message);

        mRootView = (LinearLayout) findViewById(R.id.ll_layout);

        bt_envoyer = (Button)findViewById(R.id.bt_valider);
        bt_envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mRootView, "Message bien envoyé !", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                bt_envoyer.setText("Retour");
                bt_envoyer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });

    }
}
