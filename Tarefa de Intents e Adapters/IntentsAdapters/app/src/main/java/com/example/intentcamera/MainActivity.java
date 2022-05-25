package com.example.intentcamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagem;
    private Button btnCamara;
    private Button btnUrl;
    private Button btnGps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara = (Button) findViewById(R.id.btnCamara);
        btnUrl = (Button) findViewById(R.id.btnUrl);
        btnGps = (Button) findViewById(R.id.btnGps);


        imagem = (ImageView) findViewById(R.id.Camera);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v.getId() == R.id.btnCamara){
                    Intent testeCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(testeCamera, 1);
                }
            }
        });

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btnUrl) {
                    String url = "https://g1.globo.com/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
        });

        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnGps) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:-30.888230744366837, -55.522713236734425"));
                    startActivity(intent);
                }
            }
        });

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagem = (ImageView) findViewById(R.id.Camera);
            imagem.setImageBitmap(imageBitmap);
        }
    }
}