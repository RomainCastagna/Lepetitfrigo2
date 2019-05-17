package com.exercices.lepetitfrigo.database;

import android.os.AsyncTask;
import android.util.Log;

import com.exercices.lepetitfrigo.database.entity.CategorieEntity;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;

public class DatabaseInitializer {

    public static final String TAG = "DatabaseInitializer";

    public static void populateDatabase(final AppDatabase db) {
        Log.i(TAG, "Inserting demo data.");
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static void addProduit(final AppDatabase db,String nomProduit, String image, double prix,int quantité) {
        ProduitEntity product = new ProduitEntity(nomProduit, image, prix, quantité);
        db.produitDao().insert(product);
    }

    private static void addCategorie(final AppDatabase db, final String nomCategorie,
                                   final String image) {
        CategorieEntity account = new CategorieEntity(nomCategorie, image);
        db.categorieDao().insert(account);
    }

    private static void populateWithTestData(AppDatabase db) {
        db.produitDao().deleteAll();

        addProduit(db,
                "Pomme de terre", "Michel", 3.4, 5
        );


        try {
            // Let's ensure that the clients are already stored in the database before we continue.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addCategorie(db,
                "Legume", ""
        );

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase database;

        PopulateDbAsync(AppDatabase db) {
            database = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(database);
            return null;
        }

    }
}
