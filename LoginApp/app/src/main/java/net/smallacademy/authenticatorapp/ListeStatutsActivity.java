package net.smallacademy.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeStatutsActivity extends AppCompatActivity {

    ListView listView;
    String statutproduit, nomproduit;

    HashMap<String,String> map;
    Params2 p=new Params2();
    SimpleAdapter adapter;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_statuts);


        listView=(ListView)findViewById(R.id.listv);

        //Recuperation du statu et nomproduit pour les afficher sous forme de liste
        Bundle extras=getIntent().getExtras();
        if(extras !=null)
        {
            statutproduit=extras.getString("statut");
            nomproduit=extras.getString("nomprod");
            map=new HashMap<String, String>();
            map.put("statut", statutproduit);
            map.put("nomprod" , nomproduit);
            p.values2.add(map);

        }

        adapter= new SimpleAdapter(ListeStatutsActivity.this, this.p.values2, R.layout.itemstat,
                new String[]{"nomprod" , "statut"},
                new int[]{  R.id.id_textview3,  R.id.id_textview4});

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(getApplicationContext(), ModifStatut.class);
                i.putExtra("position", position);
                startActivity(i);

            }
        });


    }
}