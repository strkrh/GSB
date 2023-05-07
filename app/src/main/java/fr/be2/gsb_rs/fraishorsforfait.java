package fr.be2.gsb_rs;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class fraishorsforfait extends menu {

    //declaration des variables
    Button btnAjouter, btnModifier, btnSupprimer;
    EditText libelle;
    EditText montant;
    TextView date;
    SQLHelper database; //variable qui permet d'accéder à la classe SQLHelper pr pouvoir accéder à ses méthodes.
    Calendar calendrier = Calendar.getInstance(); //on declare une classe d'un calendrier qui existe deja
    int jj=calendrier.get(Calendar.DAY_OF_MONTH);
    int mm=calendrier.get(Calendar.MONTH);
    int aaaa=calendrier.get(Calendar.YEAR);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fraishorsforfait);
        database=new SQLHelper(this); //j'instancie la classe SQLHelper avec la variable database
        init();
    }

    /**
     * Permet de relier les boutons avec leur objet graphique
     */
    public void init(){
        btnAjouter=findViewById(R.id.main_button_10);
        btnModifier=findViewById(R.id.main_button_6);
        btnSupprimer=findViewById(R.id.main_button_7);
        libelle=findViewById(R.id.libelle_FHF);
        montant=findViewById(R.id.Montant_FHF);
        date=findViewById(R.id.txtdatefrais);
        DatePickerDialog picker;
    }

    /**
     * Affiche un calendrier avec les dates à jour
     * @param vv
     */
    public void ShowCal(View vv)
    {
        DatePickerDialog picker = new DatePickerDialog(fraishorsforfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, aaaa, mm, jj);
        picker.show();
    }

    /**
     * Ajoute le libelle, la date et le montant d'un frais hors forfait
     * @param view
     */
    public void MyClick(View view){
        switch (view.getId()){
            case R.id.main_button_10:
                String libelle1= libelle.getText().toString();
                double montant1 = Double.parseDouble(montant.getText().toString());//conversion d'un text
                // en string et d'un string en double
                String date1=date.getText().toString();
                if(libelle1.trim().length()==0 || montant1==0 || date1.length()==0) { //test si les champs
                    // libelle, montant et date sont renseignes
                    afficherMessage("Erreur!", "Champs vides.");
                    return;
                } else{
                    database.insertData("Hors Forfait", null, date1, montant1, libelle1);
                    afficherMessage("Succès!", "Informations ajoutées.");
                    return;
                }
        }
    }

    /**
     * Permet le retour à la page précédente
     * @param view
     */
    public void clique_retour(View view) {
        finish();
    }

}
