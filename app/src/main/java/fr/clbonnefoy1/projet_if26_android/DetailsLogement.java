package fr.clbonnefoy1.projet_if26_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailsLogement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_logement);

        Intent intent = getIntent();

        Log.i("DetailsLogement", intent.getStringExtra("label"));

    }
}
