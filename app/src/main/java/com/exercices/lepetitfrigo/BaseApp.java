package com.exercices.lepetitfrigo;

import android.app.Application;

import com.exercices.lepetitfrigo.database.AppDatabase;
import com.exercices.lepetitfrigo.database.repository.CategorieRepository;
import com.exercices.lepetitfrigo.database.repository.ProductRepository;


/**
 * Android Application class. Used for accessing singletons.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }

    public ProductRepository getProductRepository() {
        return ProductRepository.getInstance();
    }

    public CategorieRepository getCategorieRepository() {
        return CategorieRepository.getInstance();
    }
}