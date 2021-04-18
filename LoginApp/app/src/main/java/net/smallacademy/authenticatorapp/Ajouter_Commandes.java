package net.smallacademy.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ajouter_Commandes extends AppCompatActivity {

    Button ajoutercommande, afficherdetailscommande;
    EditText nomfournisseur;
    EditText entreprise;
    EditText nomclient;
    EditText prenomclient;
    EditText emailclient;
    EditText telclient;
    EditText numcomand;
    EditText nomproduit;
    EditText poidsproduits;
    DatabaseReference reference;
    FirebaseDatabase root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter__commandes);

        ajoutercommande=findViewById(R.id.ajouter);
        afficherdetailscommande= findViewById(R.id.afficher);
        nomfournisseur=findViewById(R.id.editNom);
        entreprise=findViewById(R.id.editEntre);
        nomclient=findViewById(R.id.editNomCli);
        prenomclient =findViewById(R.id.editPrenom);
        emailclient=findViewById(R.id.editEmail);
        telclient=findViewById(R.id.editTel);
        numcomand=findViewById(R.id.editNum);
        nomproduit=findViewById(R.id.editProd);
        poidsproduits=findViewById(R.id.editPoids);

        //créer un intent pour aller d'une activité à une autre
        final Intent intent = new Intent(getApplicationContext(), Details_Commandes.class);

        //Le click sur le bouton afficher envoie des données vers l'activité Details_Commandes
        afficherdetailscommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nom", nomfournisseur.getText().toString());
                intent.putExtra("entreprise", entreprise.getText().toString());
                intent.putExtra("nomcli", nomclient.getText().toString());
                intent.putExtra("prenom", prenomclient.getText().toString());
                intent.putExtra("email", emailclient.getText().toString());
                intent.putExtra("telephone", telclient.getText().toString());
                intent.putExtra("numero", numcomand.getText().toString());
                intent.putExtra("produit", nomproduit.getText().toString());
                intent.putExtra("poids", poidsproduits.getText().toString());
                startActivity(intent);

//inserer dans la base de données
                root=FirebaseDatabase.getInstance();
                reference=root.getReference().child("info");
                //Obtenir toutes les valeurs;
                String enom=nomfournisseur.getText().toString();
                String enom1= entreprise.getText().toString();
                String enom2=  nomclient.getText().toString();
                String enom3=  prenomclient.getText().toString();
                String enom4=  emailclient.getText().toString();
                String enom5=  telclient.getText().toString();
                String enom6=  numcomand.getText().toString();
                String enom7=  nomproduit.getText().toString();
                String enom8=  poidsproduits.getText().toString();

                Information information = new Information(enom, enom1, enom2, enom3, enom4, enom5, enom6, enom7, enom8);
                reference.setValue(information);



                //inserer dans la base de données
               // insertInfoData();

            }
        });


        //Le click sur le bouton ajouter envoie des données vers l'activité Liste_Commandes
        ajoutercommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), Liste_Commandes.class);
                i.putExtra( "numcomand", numcomand.getText().toString());
                i.putExtra( "nomproduit", nomproduit.getText().toString());
                startActivity(i);
            }
        });
    }


}