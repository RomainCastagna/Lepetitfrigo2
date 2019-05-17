package com.exercices.lepetitfrigo.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "categories", primaryKeys = {"id"})
public class CategorieEntity implements Comparable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nom")
    private String nomCategorie;

    @ColumnInfo(name = "image")
    private String image;


    @Ignore
    public CategorieEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomCategorie;
    }

    public void setNomProduit(String nomProduit) {
        this.nomCategorie = nomCategorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public CategorieEntity(String nomCategorie, String image) {
        this.nomCategorie = nomCategorie;
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof ProduitEntity)) return false;
        ProduitEntity o = (ProduitEntity) obj;
        return o.getId()==(this.getId());
    }

    @Override
    public String toString() {
        return nomCategorie + " " + image;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return toString().compareTo(o.toString());
    }
}

