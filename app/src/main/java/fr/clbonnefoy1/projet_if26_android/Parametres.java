package fr.clbonnefoy1.projet_if26_android;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Parametres extends AppCompatActivity {

    private Context mContext;

    private TextView tv_nom;
    private TextView tv_email;
    private TextView tv_tel;

    private Button bt_modifier;
    private Button bt_mdp;
    private Button bt_supprimer;
    private Button bt_deconnexion;

    private Proprietaire proprietaire;

    private ModulePersistance mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        mContext = this;

        mp = new ModulePersistance(this);

        proprietaire = mp.getProprietaire(Compte.getId());

        tv_email = (TextView)findViewById(R.id.tv_email);
        tv_email.setText(String.format("Email : %s", proprietaire.getEmail()));
        tv_nom = (TextView)findViewById(R.id.tv_nom);
        tv_nom.setText(String.format("Nom : %s", proprietaire.getNom()));
        tv_tel = (TextView)findViewById(R.id.tv_tel);
        tv_tel.setText(String.format("Tel : %s", proprietaire.getTel()));

        bt_modifier = (Button)findViewById(R.id.bt_modifier);
        bt_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ModifierCompte.class);
                startActivity(intent);
            }
        });

        bt_mdp = (Button)findViewById(R.id.bt_mdp);
        bt_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ModifierMdp.class);
                startActivity(intent);
            }
        });

        bt_supprimer = (Button) findViewById(R.id.bt_supprimer);
        bt_supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d = onCreateDialog();

                d.show();
            }
        });

        bt_deconnexion = (Button) findViewById(R.id.bt_deconnexion);
        bt_deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compte.setId("-1");

                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }

    private Dialog onCreateDialog() {
        Dialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Êtes-vous sûr ? (Cette action est irreversible)");
        builder.setCancelable(false);
        builder.setTitle("Confirmation");

        builder.setPositiveButton("Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ModulePersistance mp = new ModulePersistance(mContext);
                        mp.removeProprietaire(Compte.getId());

                        dialog.cancel();
                        LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_param);
                        Snackbar.make(mRootView,"Votre compte a bien été supprimé !", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        Compte.setId("-1");

                        Intent i = getBaseContext().getPackageManager()
                                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                });

        builder.setNegativeButton("Non",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        dialog = builder.create();
        return dialog;
    }

}
