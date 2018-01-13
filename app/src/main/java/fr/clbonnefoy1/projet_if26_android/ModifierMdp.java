package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class ModifierMdp extends AppCompatActivity {

    private Context mContext;

    private LinearLayout ll_mdp;
    private EditText et_ancien_mdp;
    private EditText et_nouveau_mdp;
    private Button bt_mdp;

    private LinearLayout ll_num_temp;
    private EditText et_num_temp;
    private Button bt_num_temp;
    private Button bt_mail;
    private Button bt_retour;

    private int code;
    private SmsManager smsManager;
    private String mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_mdp);

        mContext = this;

        smsManager = SmsManager.getDefault();

        final ModulePersistance mp = new ModulePersistance(mContext);


        ll_mdp = (LinearLayout)findViewById(R.id.ll_mdp);
        et_ancien_mdp = (EditText)findViewById(R.id.et_ancien_mdp);
        //et_ancien_mdp.setText(p.getPass());
        //et_ancien_mdp.setEnabled(false);

        et_nouveau_mdp = (EditText)findViewById(R.id.et_nouveau_mdp);
        bt_mdp = (Button)findViewById(R.id.bt_mdp);

        ll_num_temp = (LinearLayout)findViewById(R.id.ll_num_temp);
        et_num_temp = (EditText)findViewById(R.id.et_num_temp);
        bt_num_temp = (Button)findViewById(R.id.bt_num_temp);
        bt_mail = (Button)findViewById(R.id.bt_mail);
        bt_retour = (Button)findViewById(R.id.bt_retour);

        bt_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ancien_mdp = et_ancien_mdp.getText().toString();
                String nouveau_mdp = et_nouveau_mdp.getText().toString();

                Proprietaire p = mp.getProprietaire(Compte.getId());

                if(!ancien_mdp.equals(p.getPass())) {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                    Snackbar.make(mRootView,"L'ancien mot de passe est inexacte !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                if(!ancien_mdp.equals(nouveau_mdp)) {
                    et_nouveau_mdp.setEnabled(false);
                    bt_mdp.setClickable(false);

                    ll_num_temp.setVisibility(View.VISIBLE);

                    mdp = nouveau_mdp;

                    sendSms();

                } else {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                    Snackbar.make(mRootView,"Les deux mots de passe sont identiques !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        bt_num_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num_temp = et_num_temp.getText().toString();

                if (num_temp.equals("")) {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                    Snackbar.make(mRootView,"Veuillez entrer le code !", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }

                if ( code == Integer.parseInt(num_temp)){

                    ModulePersistance mp = new ModulePersistance(mContext);

                    Proprietaire p = mp.getProprietaire(Compte.getId());

                    p.setPass(mdp);

                    mp.updateProprietaire(p);

                    bt_num_temp.setClickable(false);
                    bt_mail.setClickable(false);
                    et_num_temp.setEnabled(false);

                    bt_retour.setVisibility(View.VISIBLE);

                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                    Snackbar.make(mRootView,"Le mot de passe a été modifié.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                    Snackbar.make(mRootView,"Le code n'est pas bon.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        bt_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
                LinearLayout mRootView = (LinearLayout) findViewById(R.id.ll_modifier_mdp);
                Snackbar.make(mRootView,"SMS envoyé", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        bt_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void sendSms(){
        Random r = new Random();
        code = r.nextInt(8999) + 1000;

        Log.i("code", "" + code);

        String message = String.format("Voici le code pour modifier votre mot de passe : %d", code);

        //Log.i("message", message);

        try {
            smsManager.sendTextMessage("+33647798507", null, message, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
