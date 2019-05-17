package com.exercices.lepetitfrigo.database.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.exercices.lepetitfrigo.database.entity.CategorieEntity;
import com.exercices.lepetitfrigo.database.entity.ProduitEntity;

import java.util.List;

public class CategorieWithProducts {
    @Embedded
    public CategorieEntity categorie;

    @Relation(parentColumn = "name", entityColumn = "categoriename", entity = CategorieEntity.class)
    public List<ProduitEntity> produits;
}
