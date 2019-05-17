package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Inscription1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription1);
    }

    private void launchSubPart2(){
            Intent intent = new Intent(getApplicationContext(), Inscription2.class);
            startActivity(intent);
            finish();
    }

    public void checkInputs(View o){
        EditText emailInput = findViewById(R.id.inscr_emailInput);
        EditText passwd = findViewById(R.id.inscr_passwdInput);
        EditText passwd2 = findViewById(R.id.inscr_passwdInput2);

        String email = emailInput.getText().toString();
        String password = passwd.getText().toString();
        String password2 = passwd2.getText().toString();

        if(email.length()<1 || password.length() < 1 || password2.length()<1){
            Toast.makeText(this.getApplicationContext(),"Un ou plusieurs champs ne sont pas remplis.", Toast.LENGTH_LONG).show();
            return;
        }


        if(isEmailSyntax(email)){
            if(matchPasswords(password,password2)){
                launchSubPart2();
            } else {
                Toast.makeText(this.getApplicationContext(),"Vos mots de passe ne correspondent pas.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this.getApplicationContext(),"La syntaxe de l'email est incorrecte.", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isEmailSyntax(String email) {
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    private boolean matchPasswords(String password, String password2){
        return  password.equals(password2);
    }
}
