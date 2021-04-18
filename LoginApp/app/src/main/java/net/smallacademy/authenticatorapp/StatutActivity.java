package net.smallacademy.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class StatutActivity extends AppCompatActivity {

    Button  afficher;
    EditText statut, nomproduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statut);

        afficher=findViewById(R.id.afficher);
        nomproduit= findViewById(R.id.reponse);
        statut= findViewById(R.id.statutcmd);



        //L'intent qi afficher la liste des statuts
        final Intent intent = new Intent(getApplicationContext(), ListeStatutsActivity.class);

//Envoyer les données : nomproduit et statut vers l'activité ListeStatut
afficher.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        intent.putExtra("nomprod", nomproduit.getText().toString());
        intent.putExtra("statut", statut.getText().toString());
        startActivity(intent);
    }
});

    }


}