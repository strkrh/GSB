package fr.be2.gsb_rs;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.AdapterView.OnItemClickListener;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;

public class historiqueenvois extends menu {
    private SimpleCursorAdapter dataAdapter;
    private SQLHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historiqueenvois);
        //j'instancie la classe SQLHelper avec la variable db
        db = new SQLHelper(this);
        db.open();

        displayListView();
    }

    /**
     * Permet de remplir le list view des frais
     */
    private void displayListView() {

        Cursor cursor = db.fetchAllFrais();

        // Les colonnes que l’on veut lier
        String[] columns = new String[]{
                SQLHelper.LIBELLE,
                SQLHelper.MONTANT,
                SQLHelper.DATE_FRAIS,
                SQLHelper.DATE_SAISIE,
                SQLHelper.QUANTITE,
                SQLHelper.ID_FRAIS

        };

        // Les éléments defnis dans le XML auxquels les données sont liées
        int[] to = new int[]{
                R.id.libelleFrais,
                R.id.montant,
                R.id.dateFrais,
                R.id.dateActu,
                R.id.txtQte,
                R.id.idFrais

        };
        //On crée l'adaptateur à l'aide du curseur pointant sur les données souhaitées
        // ainsi que les informations de mise en page
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.frais_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Attribuer l’adapter au ListView
        listView.setAdapter(dataAdapter);

        //Pour que l'id du frais s'affiche quand on clique dessus, et pour supprimer le frais
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // On obtient le curseur, positionne sur la ligne correspondante dans le jeu de résultats
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                //On obtient l'id du frais en cliquant sur le frais
                String myId = cursor.getString(cursor.getColumnIndexOrThrow("ID"));
                Toast.makeText(getApplicationContext(), myId, Toast.LENGTH_SHORT).show();
                db.deleteData (parseInt (myId));
            }
        });
    }

    public void clique_retour(View view) {
        finish();
    }

}