package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.exercices.lepetitfrigo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductShopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Product> legumes = new ArrayList<>();
    private List<Product> fruits = new ArrayList<>();
    private List<Product> epicerie = new ArrayList<>();
    private List<Product> pain = new ArrayList<>();
    private List<Product> produitslaitiers = new ArrayList<>();
    private List<Product> oeufs = new ArrayList<>();
    Button cButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cButton= findViewById(R.id.legumes_btn);
        cButton.setOnClickListener(view -> {
            Intent intent = new Intent(ProductShopActivity.this, CategorieActivity.class);
            startActivity(intent);
        }
);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void instantiateLegumes(View o){
        legumes.add(new Product("COURGE butternut",2,R.drawable.courgette));
        legumes.add(new Product("ASPERGES VERTES",2,R.drawable.courgette));
        legumes.add(new Product("ASPERGES VERTES Mini",2,R.drawable.courgette));
        legumes.add(new Product("COTE DE BETTE",2,R.drawable.courgette));
        legumes.add(new Product("BETTERAVES CHIOGGIA",2,R.drawable.courgette));
        legumes.add(new Product("CONCOMBRES",2.20,R.drawable.courgette));
        legumes.add(new Product("POIVRON",5,R.drawable.courgette));
        legumes.add(new Product("AUBERGINES",2,R.drawable.courgette));
        legumes.add(new Product("COURGETTES",3,R.drawable.courgette));
        legumes.add(new Product("TOMATES Grandes (500g)",3.5,R.drawable.courgette));
        legumes.add(new Product("TOMATES Grandes",3,R.drawable.courgette));
        legumes.add(new Product("TOMATES Mélange petites (300g)",3.5,R.drawable.courgette));
        legumes.add(new Product("TOMATES Mélange petites (500g)",5.5,R.drawable.courgette));
        legumes.add(new Product("CAROTTES",2,R.drawable.courgette));
        legumes.add(new Product("OIGNONS frais en botte",2.5,R.drawable.courgette));
        legumes.add(new Product("ECHALOTES",2,R.drawable.courgette));


    }

    public void instantiateFruits(View o){
        fruits.add(new Product("FRAISES",2,R.drawable.courgette));
        fruits.add(new Product("FRAMBOISES",2,R.drawable.courgette));
        fruits.add(new Product("POMMES Royal",2,R.drawable.courgette));
        fruits.add(new Product("POMMES Boskoop",2,R.drawable.courgette));
        fruits.add(new Product("POIRES Conférences",2,R.drawable.courgette));
        fruits.add(new Product("POIRES HARROW sweet",2,R.drawable.courgette));
    }

    public void instantiateEpicerie(View o){
        epicerie.add(new Product("CONFITURES Maison - ORANGES douces bio",2,R.drawable.courgette));
        epicerie.add(new Product("CONFITURES Maison - FRAISES-COINGS",2,R.drawable.courgette));
        epicerie.add(new Product("CONFITURES Maison - FRAISES",2,R.drawable.courgette));
        epicerie.add(new Product("CONFITURES Maison - Framboises",2,R.drawable.courgette));
        epicerie.add(new Product("CONFITURES Maison - Framboises-pruneaux",2,R.drawable.courgette));
        epicerie.add(new Product("GELEES Maison - Fraises-Coings",2,R.drawable.courgette));
        epicerie.add(new Product("GELEES Maison - Coings",2,R.drawable.courgette));
        epicerie.add(new Product("CONCENTRE DE TOMATES Maison",2,R.drawable.courgette));
        epicerie.add(new Product("CHUTNEY OIGNONS Maison",2,R.drawable.courgette));
        epicerie.add(new Product("SIRPOS FRAISE Maison",2,R.drawable.courgette));
        epicerie.add(new Product("BOURGEONS d'origan",2,R.drawable.courgette));
        epicerie.add(new Product("FLEUR DE SEL - 5 herbettes, origan, nature",2,R.drawable.courgette));
        epicerie.add(new Product("HUILES D'OLIVE BIO",2,R.drawable.courgette));
        epicerie.add(new Product("FARINE DE SARRASIN",2,R.drawable.courgette));
    }

    public void instantiatePain(View o){
        pain.add(new Product("PAIN - Boulangerie de DENENS",3,R.drawable.courgette));
        pain.add(new Product("PAIN SANS GLUTEN",3,R.drawable.courgette));
    }

    public void instantiatePL(View o){
        produitslaitiers.add(new Product("FROMAGES DE CHEVRES, mi-dur",10,R.drawable.courgette));
        produitslaitiers.add(new Product("FROMAGES FRAIS Nature",4,R.drawable.courgette));
        produitslaitiers.add(new Product("FROMAGES FRAIS Poivre",4,R.drawable.courgette));
        produitslaitiers.add(new Product("FROMAGES FRAIS Herbe de Provence",4,R.drawable.courgette));
        produitslaitiers.add(new Product("LAITSPOIR",6,R.drawable.courgette));
        produitslaitiers.add(new Product("GRUYERE",5,R.drawable.courgette));
        produitslaitiers.add(new Product("TOMMES natures",5,R.drawable.courgette));
        produitslaitiers.add(new Product("PRODUITS de la fromagerie du Moléson",2,R.drawable.courgette));
    }

    public void instantiateOeufs(View o){
        oeufs.add(new Product("OEUFS FRAIS bio de Villars-sous-Yens x6",5,R.drawable.courgette));
        oeufs.add(new Product("OEUFS FRAIS gros SRPA de Pampigny x6",4.5,R.drawable.courgette));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product_shop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_shop) {
            // Handle the camera action
        } else if (id == R.id.nav_scanner) {
            Intent intent = new Intent(getApplicationContext(), QRScannerActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_stock) {

        } else if (id == R.id.nav_parametres) {

        } else if (id == R.id.nav_profile) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
