package net.smallacademy.authenticatorapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static android.text.PrecomputedText.*;

public class Liste_Commandes extends AppCompatActivity {

    ListView listView;
    String numcomand1;
    String nomproduit1;

    HashMap<String,String> map;  //Pour stocker le numcommande et nompdt
    Params p=new Params();  //Instance de la classe Params >>arrayList contenant un Hashmap

    SimpleAdapter adapter;

    Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__commandes);


        listView=(ListView)findViewById(R.id.listv);

        Bundle extras=getIntent().getExtras();

        //Recuperer le numcommande et nomPdt pour les afficher dans la liste
        if(extras !=null)
        {
            numcomand1=extras.getString("numcomand");  //Recuperation des clés mises dans l'activité Ajouter_Commandes
            nomproduit1 =extras.getString("nomproduit");
            map=new HashMap<String, String>();  //instanciation d'un Haspmp pour stocker le numcommande et nomproduit
            map.put("numcomand", numcomand1);
            map.put("nomproduit" , nomproduit1 );
            p.values.add(map);  //Ajout de la map qui contient les informations dans l'ArrayList pour les afficher

        }

        adapter= new SimpleAdapter(Liste_Commandes.this, this.p.values, R.layout.item,
                new String[]{"numcomand", "nomproduit" },  //Stockage de numcommand et nomproduit dans textview1 et textview1 respectivement
                new int[]{ R.id.id_textview1, R.id.id_textview2}); //R.id.id_textview1, R.id.id_textview2  c'est id qui se trouve dans item.xml

        listView.setAdapter(adapter);


        //Rendre chaque element de la iste cliquable pour pouvoir modifier ou supprimer les infos
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //position est une variable
                Intent i=new Intent(getApplicationContext(), detail.class); //ENvoie des données vers l'activité detail pour modifier le numcommande ou nomproduit
                i.putExtra("position", position);
                startActivity(i);

            }
        });


}




}