package com.exercices.lepetitfrigo.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "produits", primaryKeys = {"id"},
        foreignKeys =
        @ForeignKey(
                entity = CategorieEntity.class,
                parentColumns = "name",
                childColumns = "categoriename",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {
                @Index(
                        value = {"categoriename"}
                )}
)
public class ProduitEntity  implements  Comparable{


        @PrimaryKey(autoGenerate = true)
        private int id;

        @ColumnInfo(name = "nom")
        private String nomProduit;

    @ColumnInfo(name = "categoriename")
    private String categoriename;

        @ColumnInfo(name = "prix")
        private double prix;

        @ColumnInfo(name = "qatRestente")
        private int quantité;


        @ColumnInfo(name = "image")
        private String image;


        @Ignore
        public ProduitEntity() {
        }

        public int getQuantité() {
                return quantité;
        }

        public void setQuantité(int quantité) {
                this.quantité = quantité;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNomProduit() {
                return nomProduit;
        }

        public void setNomProduit(String nomProduit) {
                this.nomProduit = nomProduit;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public double getPrix() {
                return prix;
        }

        public void setPrix(double prix) {
                this.prix = prix;
        }


    public String getCategoriename() {
        return categoriename;
    }

    public void setCategoriename(String categoriename) {
        this.categoriename = categoriename;
    }

    public ProduitEntity(String nomProduit, String image, double prix, int quantité) {

                this.nomProduit = nomProduit;
                this.image = image;
                this.prix=prix;
                this.quantité=quantité;
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
                return nomProduit + " " + prix;
        }

        @Override
        public int compareTo(@NonNull Object o) {
                return toString().compareTo(o.toString());
        }
}
