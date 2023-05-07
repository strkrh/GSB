package fr.be2.gsb_rs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class menu extends AppCompatActivity {
    Intent intent;
    EditText codeVisiteur;
    Context context;
    private static final String monFichier = "GSB_PREF_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        secure();
    }

    public void click_menu(View v){
        String msg= " ";
        switch (v.getId()){
            case R.id.main_button_1:
                 intent = new Intent(menu.this, fraisforfait.class);
                break;
            case R.id.main_button_2:
                 intent = new Intent(menu.this, fraishorsforfait.class);
                break;
            case R.id.main_button_3:
                 intent = new Intent(menu.this, consultationfrais.class);
                break;
            case R.id.main_button_4:
                 intent = new Intent(menu.this, parametres.class);
                break;
            case R.id.main_button_15:
                intent = new Intent(menu.this,connexion.class);
                context.getSharedPreferences("PreferencesName", Context.MODE_PRIVATE).edit().clear().commit();
                break;
    }
        startActivity(intent);

       // Toast.makeText();


}
    public void fermer(View v){

        this.finish();
    }
    public void secure(){
        String cvisiteur= getSharedPreferences("GSB_PREF_USER", MODE_PRIVATE).getString("CodeVisiteur","pas authentifie");
            if (cvisiteur.equals("pas authentifie")) {
            Intent intent = new Intent(menu.this,connexion.class);
            startActivity(intent);
    }}
    public void afficherMessage(String titre, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this); //classe qui constuit une boite de dialogue
        builder.setCancelable(true); //pr que la boite de dialogue soit refermable
        builder.setTitle(titre);
        builder.setMessage(message);
        builder.show();

    }

}

