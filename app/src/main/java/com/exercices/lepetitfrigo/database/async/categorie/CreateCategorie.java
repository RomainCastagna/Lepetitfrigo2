package com.exercices.lepetitfrigo.database.async.categorie;

import android.app.Application;
import android.os.AsyncTask;

import com.exercices.lepetitfrigo.BaseApp;
import com.exercices.lepetitfrigo.database.entity.CategorieEntity;
import com.exercices.lepetitfrigo.database.util.OnAsyncEventListener;

import ch.hevs.aislab.demo.BaseApp;
import ch.hevs.aislab.demo.database.entity.ClientEntity;
import ch.hevs.aislab.demo.util.OnAsyncEventListener;

public class CreateCategorie extends AsyncTask<CategorieEntity, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public CreateCategorie(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(CategorieEntity... params) {
        try {
            for (CategorieEntity client : params)
                ((BaseApp) application).getDatabase().cate()
                        .insert(client);
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
