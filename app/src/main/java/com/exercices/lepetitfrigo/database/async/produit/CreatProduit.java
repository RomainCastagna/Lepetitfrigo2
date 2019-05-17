package com.exercices.lepetitfrigo.database.async.produit;

import android.app.Application;
import android.os.AsyncTask;

import com.exercices.lepetitfrigo.BaseApp;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;
import com.exercices.lepetitfrigo.database.util.OnAsyncEventListener;


public class CreatProduit extends AsyncTask<ProduitEntity, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public CreatProduit(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(ProduitEntity... params) {
        try {
            for (ProduitEntity produit : params)
                ((BaseApp) application).getDatabase().produitDao()
                        .insert(produit);
        } catch (Exception e) {
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (callback != null) {
            if (exception == null) {
                callback.onSuccess();
            } else {
                callback.onFailure(exception);
            }
        }
    }
}