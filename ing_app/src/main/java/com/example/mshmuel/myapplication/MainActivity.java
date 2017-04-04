package com.example.mshmuel.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.hardware.camera2.*;
import android.provider.MediaStore;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button picButton = (Button)findViewById(R.id.picButton);
        Button ingSearch = (Button)findViewById(R.id.ingridient);
        Button prodSearch = (Button)findViewById(R.id.product);
        Button ocrButton = (Button)findViewById(R.id.ocr);


        picButton.setOnClickListener(
                new Button.OnClickListener(){

                    public void onClick(View v){
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                        }
                    }
                }
        );


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView thumbnail = (ImageView)findViewById(R.id.picThumb);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            thumbnail.setImageBitmap(imageBitmap);
        }
    }

    public void ingSearch(View view){
        Intent ingSearchIntent = new Intent(this,ingSearchActivity.class);
        startActivity(ingSearchIntent);
    }
    public void prodSearch(View view){
        Intent prodSearchIntent = new Intent(this,prodSearchActivity.class);
        startActivity(prodSearchIntent);
    }
    public void ocrSearch(View view){
        Intent ocrSearchIntent = new Intent(this,OcrSearchActivity.class);
        startActivity(ocrSearchIntent);
    }
}
