package com.exercices.lepetitfrigo.database.async.produit;

import android.app.Application;
import android.os.AsyncTask;

import com.exercices.lepetitfrigo.BaseApp;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;
import com.exercices.lepetitfrigo.database.util.OnAsyncEventListener;

public class DeleteProduit extends AsyncTask<ProduitEntity, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public DeleteProduit(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(ProduitEntity... params) {
        try {
            for (ProduitEntity account : params)
                ((BaseApp) application).getDatabase().produitDao()
                        .delete(account);
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