package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_mdp);

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

                //descativate ll_mpd components
                et_ancien_mdp.setEnabled(false);
                et_nouveau_mdp.setEnabled(false);
                bt_mdp.setClickable(false);

                ll_num_temp.setVisibility(View.VISIBLE);

            }
        });

        bt_num_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void sendEmail(){
        //TODO
    }

}
