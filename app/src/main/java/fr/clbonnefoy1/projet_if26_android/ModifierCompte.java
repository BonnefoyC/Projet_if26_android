package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ModifierCompte extends AppCompatActivity {

    private Context mContext;

    private EditText et_nom;
    private EditText et_email;
    private EditText et_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_compte);

        et_nom = (EditText) findViewById(R.id.et_nom);
        et_email = (EditText) findViewById(R.id.et_email);
        et_tel = (EditText) findViewById(R.id.et_tel);


    }
}
