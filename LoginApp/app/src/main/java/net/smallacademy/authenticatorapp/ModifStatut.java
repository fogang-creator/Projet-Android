package net.smallacademy.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class ModifStatut extends AppCompatActivity {

    //Cette activité permet de modofier les infos du statut notamment la mise à jour du statut

    EditText nom, prod;
    Button mod, sup, statut;
    int position;

    Params2 p = new Params2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_statut);



        nom=findViewById(R.id.edit_id1);
        prod=findViewById(R.id.edit_id2);
        mod=findViewById(R.id.modifier);
        sup=findViewById(R.id.supprimer);

        Bundle extras= getIntent().getExtras();
        if(extras !=null)
        {
            position =extras.getInt("position");

        }

        final HashMap<String, String> m = p.values2.get(position);
        nom.setText(m.get("statut"));
        prod.setText(m.get("nomprod"));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("statut", nom.getText().toString());
                m.put("nomprod", prod.getText().toString());

                Intent i = new Intent(getApplicationContext(), ListeStatutsActivity.class);
                startActivity(i);
                finish();
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.values2.remove(position);
                Intent i = new Intent(getApplicationContext(), ListeStatutsActivity.class);
                startActivity(i);
                finish();
            }

        });



    }
}