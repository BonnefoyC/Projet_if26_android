package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_mdp);

        mContext = this;

        ll_mdp = (LinearLayout)findViewById(R.id.ll_mdp);
        et_ancien_mdp = (EditText)findViewById(R.id.et_ancien_mdp);
        et_nouveau_mdp = (EditText)findViewById(R.id.et_nouveau_mdp);
        bt_mdp = (Button)findViewById(R.id.bt_mdp);

        ll_num_temp = (LinearLayout)findViewById(R.id.ll_num_temp);
        et_num_temp = (EditText)findViewById(R.id.et_num_temp);
        bt_num_temp = (Button)findViewById(R.id.bt_num_temp);
        bt_mail = (Button)findViewById(R.id.bt_mail);

        bt_mdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ancien_mdp = et_ancien_mdp.getText().toString();
                String nouveau_mdp = et_nouveau_mdp.getText().toString();


                if(!ancien_mdp.equals(nouveau_mdp)) {
                    //descativate ll_mpd components
                    et_ancien_mdp.setEnabled(false);
                    et_nouveau_mdp.setEnabled(false);
                    bt_mdp.setClickable(false);

                    ll_num_temp.setVisibility(View.VISIBLE);

                    sendSms();

                } else {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.LinearLayout);
                    Snackbar.make(mRootView,"Les deux mots de passe sont identiques", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }




            }
        });

        bt_num_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num_temp = et_num_temp.getText().toString();
                if ( code == Integer.parseInt(num_temp)){
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.LinearLayout);
                    Snackbar.make(mRootView,"Le mot de passe est modifié", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    LinearLayout mRootView = (LinearLayout) findViewById(R.id.LinearLayout);
                    Snackbar.make(mRootView,"Le code n'est pas bon", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        bt_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
                LinearLayout mRootView = (LinearLayout) findViewById(R.id.LinearLayout);
                Snackbar.make(mRootView,"SMS envoyé", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void sendSms(){
        //TODO
        Random r = new Random();
        code = r.nextInt(8999) + 1000;
        Log.i("code", "" + code);

        //SMS
    }

}
