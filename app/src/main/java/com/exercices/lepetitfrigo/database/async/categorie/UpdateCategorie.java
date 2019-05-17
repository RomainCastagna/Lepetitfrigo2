package com.exercices.lepetitfrigo.database.async.categorie;

import android.app.Application;
import android.os.AsyncTask;

import com.exercices.lepetitfrigo.BaseApp;
import com.exercices.lepetitfrigo.database.entity.CategorieEntity;
import com.exercices.lepetitfrigo.database.util.OnAsyncEventListener;

import ch.hevs.aislab.demo.BaseApp;
import ch.hevs.aislab.demo.database.entity.ClientEntity;
import ch.hevs.aislab.demo.util.OnAsyncEventListener;

public class UpdateCategorie extends AsyncTask<CategorieEntity, Void, Void> {

    private Application application;
    private OnAsyncEventListener calback;
    private Exception exception;

    public UpdateCategorie(Application application, OnAsyncEventListener callback) {
        this.application = application;
        calback = callback;
    }

    @Override
    protected Void doInBackground(CategorieEntity... params) {
        try {
            for (CategorieEntity categorie : params)
                ((BaseApp) application).getDatabase().produitDao()
                        .update(client);
        } catch (Exception e) {
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (calback != null) {
            if (exception == null) {
                calback.onSuccess();
            } else {
                calback.onFailure(exception);
            }
        }
    }
}