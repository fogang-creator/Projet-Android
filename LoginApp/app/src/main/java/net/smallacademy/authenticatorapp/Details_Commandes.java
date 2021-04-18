package net.smallacademy.authenticatorapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Details_Commandes extends AppCompatActivity {

    Button modifier;
    TextView nomfournisseur;
    TextView  entreprise;
    TextView  nomclient;
    TextView  prenomclient;
    TextView  emailclient;
    TextView  telclient;
    TextView  numcomand;
    TextView  nomproduit;
    TextView  poidsproduits;
    Intent intent1;
    Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details__commandes);


        modifier=findViewById(R.id.modifier);
        nomfournisseur=findViewById(R.id.textNom);
        entreprise=findViewById(R.id.textEntre);
        nomclient=findViewById(R.id.textNomcli);
        prenomclient =findViewById(R.id.textPrenom);
        emailclient=findViewById(R.id.textEmail);
        telclient=findViewById(R.id.textTel);
        numcomand=findViewById(R.id.textNum);
        nomproduit=findViewById(R.id.textProd);
        poidsproduits=findViewById(R.id.textPoids);

        Intent intent = getIntent(); //getIntent pour recuperer les données  venant de l'activité Ajouter_commande

        final String nom = intent.getStringExtra("nom"); //getStringExtra pour récuperer et afficher les données
        nomfournisseur.setText(nom);

        final String entrepri= intent.getStringExtra("entreprise");
        entreprise.setText(entrepri);

        final String nomcliet = intent.getStringExtra("nomCli");
        nomclient.setText(nomcliet);


        final String prenom = intent.getStringExtra("prenom");
        prenomclient.setText(prenom);


        final String email = intent.getStringExtra("email");
        emailclient.setText(email);


        final String telephone = intent.getStringExtra("telephone");
        telclient.setText(telephone);


        final String numero = intent.getStringExtra("numero");
        numcomand.setText(numero);


        final String produit = intent.getStringExtra("produit");
        nomproduit.setText(produit);


        final String poids = intent.getStringExtra("poids");
        poidsproduits.setText(poids);
        //créer l'intension d'ou je suis vers ou je vais
        intent1= new Intent(this, Ajouter_Commandes.class);

        //Le listener sur le bouton modifier permet de retourner sur l'activité Ajouter_Commandes
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //commencer l'activité
                startActivity(intent1);

            }
        });

        //Intent redirige vers l'activité Liste_Commandes
        intent2 = new Intent(this, Liste_Commandes.class);


    }
}