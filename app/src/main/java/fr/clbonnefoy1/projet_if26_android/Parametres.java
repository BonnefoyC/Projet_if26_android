package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Parametres extends AppCompatActivity {

    private Context mContext;

    private TextView tv_nom;
    private TextView tv_email;
    private TextView tv_tel;

    private Button bt_modifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        mContext = this;

        tv_email = (TextView)findViewById(R.id.tv_email);
        tv_email.setText(String.format("Email : %s", Compte.getEmail()));
        tv_nom = (TextView)findViewById(R.id.tv_nom);
        tv_nom.setText(String.format("Nom : %s", Compte.getNom()));
        tv_tel = (TextView)findViewById(R.id.tv_tel);
        tv_tel.setText(String.format("Tel : %s", Compte.getTel()));

        bt_modifier = (Button)findViewById(R.id.bt_modifier);
        bt_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ModifierCompte.class);
                startActivity(intent);
            }
        });

    }
}
