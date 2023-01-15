package fr.be2.gsb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;



import java.util.Random;

public class connexion extends menu {
    EditText codeVisiteur;
    EditText email;
    EditText codeVerif;
    LinearLayout verification;
    Integer codeAleatoire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);
        codeVisiteur = findViewById(R.id.Codevisiteur);
        email = findViewById(R.id.email);
        verification = findViewById(R.id.linear);
        codeVerif= findViewById(R.id.codeVerif);
    }

    public void click_code(View v){
        Random r = new Random();
        int min = 1000;
        int max = 9999;
        codeAleatoire = r.nextInt((max - min) + 1) + min;
        Toast.makeText(this,"code="+codeAleatoire.toString(),Toast.LENGTH_SHORT).show();
        verification.setVisibility(View.VISIBLE);

    }
    public void Valide_code (View v){
        String codeAleatoireStr = codeAleatoire.toString();
        String codeverifStr = codeVerif.getText().toString();
        if (codeAleatoireStr.equals(codeverifStr)){
            Toast.makeText(this, "Réussite", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
        }
    }

}