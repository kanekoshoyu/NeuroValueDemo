package com.example.shoyu.neurovaluedemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
static final int REQUEST_CAMERA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
private Button buttonView;
    public void cameraIntent(View view) {
        System.out.println("Camera Intent here!!");
        Intent cameraI = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        buttonView = (Button)view;
        startActivityForResult(cameraI, REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBMP = (Bitmap) extras.get("data");
            //iv.setImageBitmap(imageBMP);
            Drawable d = new BitmapDrawable(getResources(), imageBMP);
            buttonView.setBackgroundDrawable(d);
            buttonView.setTextColor(Color.WHITE);
        }
    }

    public void confirmationActivity(View view) {
        Intent intent = new Intent(this, ConfirmationActivity.class);
        startActivity(intent);
    }
}
