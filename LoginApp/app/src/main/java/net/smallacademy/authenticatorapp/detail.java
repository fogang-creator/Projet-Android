package net.smallacademy.authenticatorapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import static android.text.PrecomputedText.*;

public class detail extends AppCompatActivity {

    EditText numcomand, nomproduit;
    Button modifier, supprimer, statut;
    int position;
    Params p = new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Récuperation des ID

        numcomand=findViewById(R.id.edit_id1);
        nomproduit=findViewById(R.id.edit_id2);
        modifier=findViewById(R.id.modifier);
        supprimer=findViewById(R.id.supprimer);
        statut= findViewById(R.id.statut);

        Bundle extras= getIntent().getExtras();

        //Recuperer la position de l'item dans la liste

        if(extras !=null)
        {
            position =extras.getInt("position");

        }

        //Afficher les données dans les EditText pour les modifier
        final HashMap<String, String> m = p.values.get(position);
        numcomand.setText(m.get("numcomand"));
        nomproduit.setText(m.get("nomproduit"));

        //Mettre les nouveles infos dans la liste
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("numcomand", numcomand.getText().toString());
                m.put("nomproduit", nomproduit.getText().toString());

                Intent i = new Intent(getApplicationContext(), Liste_Commandes.class);
                startActivity(i);
                finish();
            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.values.remove(position);   //On supprimer l'item
                Intent i = new Intent(getApplicationContext(), Liste_Commandes.class);  //On retourne sur l liste
                startActivity(i);
                finish();
            }

        });

        //Ajouter le statut de la commande qui renvoie sur l'activité StatutActivity
        statut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), StatutActivity.class);
                startActivity(intent);
            }
        });

    }
}