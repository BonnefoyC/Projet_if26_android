package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;

import static android.R.attr.password;
import static fr.clbonnefoy1.projet_if26_android.R.string.email;

public class Authentification extends AppCompatActivity {

    private Context mContext;

    private EditText et_email;
    private EditText et_password;
    private Button bt_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        mContext = this;

        ModulePersistance mp = new ModulePersistance(this);

        //TODO commenter

        ArrayList<Proprietaire> liste_p = Proprietaire.getInitialProprietaires();
        for (Proprietaire p : liste_p) {
            mp.addProprietaire(p);
        }

        ArrayList<Logement> liste = Logement.getInitialLogements();

        for (Logement l: liste) {
            mp.addLogement(l);
        }

        et_email = (EditText)findViewById(R.id.et_email);
        et_email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                return false;
            }
        });
        et_password = (EditText)findViewById(R.id.et_password);
        et_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                return false;
            }
        });

        bt_valider = (Button)findViewById(R.id.bt_valider);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    ModulePersistance mp = new ModulePersistance(mContext);

                    String email = et_email.getText().toString();
                    String password = et_password.getText().toString();

                    Proprietaire p = mp.getProprietaire(email, password);

                    if(p == null) {
                        LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_auth);
                        Snackbar.make(mRootView, "Ce compte n'existe pas !", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        return;
                    }

                    if (password.equals(p.getPass())) {


                        Compte.setId(p.getId_proprio());

                        Intent intent = new Intent(mContext, MainActivity.class);
                        startActivity(intent);
                    } else {
                        LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_auth);
                        Snackbar.make(mRootView, "Impossible de vous identifier !", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
