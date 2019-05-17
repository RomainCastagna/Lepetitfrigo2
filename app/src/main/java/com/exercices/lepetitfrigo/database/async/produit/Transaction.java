package com.exercices.lepetitfrigo.database.async.produit;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Pair;

/*
public class Transaction extends AsyncTask<Pair<AccountEntity, AccountEntity>, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public Transaction(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Pair<AccountEntity, AccountEntity>... params) {
        try {
            for (Pair<AccountEntity, AccountEntity> accountPair : params)
                ((BaseApp) application).getDatabase().accountDao()
                        .transaction(accountPair.first, accountPair.second);
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
*/