package fr.be2.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
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
                break;
    }
        startActivity(intent);

       // Toast.makeText();


}
    public void fermer(View v){

        this.finish();
    }
}

