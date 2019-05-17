package com.exercices.lepetitfrigo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class QRScannerActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);
        imageView = findViewById(R.id.camera_input);

        Intent takeImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takeImageIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takeImageIntent,REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitamp = (Bitmap) extras.get("data");

            imageView.setImageBitmap(imageBitamp);
        }
    }
}
