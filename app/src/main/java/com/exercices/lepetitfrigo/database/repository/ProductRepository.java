package com.exercices.lepetitfrigo.database.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.exercices.lepetitfrigo.BaseApp;
import com.exercices.lepetitfrigo.database.async.produit.CreatProduit;
import com.exercices.lepetitfrigo.database.async.produit.DeleteProduit;
import com.exercices.lepetitfrigo.database.async.produit.UpdateProduit;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;
import com.exercices.lepetitfrigo.database.util.OnAsyncEventListener;

import java.util.List;

public class ProductRepository {
        private static ProductRepository instance;

        private ProductRepository() {

        }

        public static ProductRepository getInstance() {
            if (instance == null) {
                synchronized (ProductRepository.class) {
                    if (instance == null) {
                        instance = new ProductRepository();
                    }
                }
            }
            return instance;
        }

        public LiveData<ProduitEntity> getAccount(final int produitId, Application application) {
            return ((BaseApp) application).getDatabase().produitDao().getById(produitId);
        }

        public LiveData<List<ProduitEntity>> getProducts(Application application) {
            return ((BaseApp) application).getDatabase().produitDao().getAll();
        }

       /* public LiveData<List<ProduitEntity>> getByCategorie(final String categorie, Application application) {
            return ((BaseApp) application).getDatabase().produitDao().getOtherProductWithCategorie(categorie);
        }*/

        public void insert(final ProduitEntity product, OnAsyncEventListener callback,
                           Application application) {
            new CreatProduit(application, callback).execute(product);
        }

        public void update(final ProduitEntity product, OnAsyncEventListener callback,
                           Application application) {
            new UpdateProduit(application, callback).execute(product);
        }

        public void delete(final ProduitEntity product, OnAsyncEventListener callback,
                           Application application) {
            new DeleteProduit(application, callback).execute(product);
        }


}
