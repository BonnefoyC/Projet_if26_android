package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModifierCompte extends AppCompatActivity {

    private Context mContext;

    private EditText et_nom;
    private EditText et_email;
    private EditText et_tel;

    private Button bt_valider;

    private Proprietaire proprietaire;

    private ModulePersistance mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_compte);

        mContext = this;

        mp = new ModulePersistance(this);

        proprietaire = mp.getProprietaire(Compte.getId());

        et_nom = (EditText) findViewById(R.id.et_nom);
        et_nom.setText(String.format("%s", proprietaire.getNom()));

        et_email = (EditText) findViewById(R.id.et_email);
        et_email.setText(String.format("%s", proprietaire.getEmail()));

        et_tel = (EditText) findViewById(R.id.et_tel);
        et_tel.setText(String.format("%s", proprietaire.getTel()));

        bt_valider = (Button)findViewById(R.id.bt_valider);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificationChamps()) {

                    String id = proprietaire.getId_proprio();
                    String nom = et_nom.getText().toString();
                    String email = et_email.getText().toString();
                    String tel = et_tel.getText().toString();
                    String pass = "";

                    mp.updateProprietaire(new Proprietaire(id, nom, email, tel, pass));

                    Intent intent = new Intent(mContext, Parametres.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean verificationChamps() {
        boolean check = true;

        if(et_nom.getText().toString() == "" || et_nom.getText().toString() == null) {
            check = false;
        }

        if(et_tel.getText().toString() == "" || et_tel.getText().toString() == null) {
            check = false;
        }

        if(et_email.getText().toString() == "" || et_email.getText().toString() == null) {
            check = false;
        }

        return check;
    }

}
