package com.exercices.lepetitfrigo.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.exercices.lepetitfrigo.database.entity.CategorieEntity;

import java.util.List;

public abstract class CategorieDao {
    @Query("SELECT * FROM categories WHERE id = :id")
    public abstract LiveData<CategorieEntity> getById(Long id);

    @Query("SELECT * FROM categories")
    public abstract LiveData<List<CategorieEntity>> getAll();

    @Query("SELECT * FROM categories WHERE nom=:nom")
    public abstract LiveData<List<CategorieEntity>> getOwned(String nom);

    @Insert
    public abstract long insert(CategorieEntity categorie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertAll(List<CategorieEntity> categories);

    @Update
    public abstract void update(CategorieEntity categorie);

    @Delete
    public abstract void delete(CategorieEntity categorie);

    @Query("DELETE FROM categories")
    public abstract void deleteAll();

    /**
     * There's currently no way to add additional constraints (beside ForeignKey) to columns.
     *
     * This means we currently cannot check on a DB level if the balance of a client will be
     * updated with a negative value.
     * So we need to ensure that the sender has enough money on his client BEFORE we call this
     * method because we want to ensure that people cannot get into debt.
     *
     * @param sender AccountEntity that sends the money
     * @param recipient AccountEntity that receives the money
     */
  /*  @Transaction
    public void transaction(AccountEntity sender, AccountEntity recipient) {
        update(sender);
        update(recipient);
    }*/
}
