package com.exercices.lepetitfrigo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;
import android.database.sqlite.SQLiteConstraintException;

import com.exercices.lepetitfrigo.database.entity.CategorieEntity;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;

import java.util.List;

@Dao
public interface ProduitDao {

    @Query("SELECT * FROM produits WHERE id = :id")
    LiveData<ProduitEntity> getById(int id);

    @Query("SELECT * FROM produits")
    LiveData<List<ProduitEntity>> getAll();

    /**
     * This method is used to populate the transaction activity.
     * It returns all OTHER users and their accounts.
     * @param id Id of the client who should be excluded from the list.
     * @return A live data object containing a list of ClientAccounts with
     * containing all clients but the @id.
     */
    @Transaction
    @Query("SELECT * FROM produits WHERE id != :id")
    LiveData<List<CategorieEntity>> getOtherProductWithCategorie(int id);

    @Insert
    long insert(ProduitEntity produit) throws SQLiteConstraintException;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProduitEntity> produits);

    @Update
    void update(ProduitEntity produit);

    @Delete
    void delete(ProduitEntity produit);

    @Query("DELETE FROM clients")
    void deleteAll();
}
