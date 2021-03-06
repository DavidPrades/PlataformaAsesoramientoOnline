package com.example.plataformaasesoramientoonline;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.OpenableColumns;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class AdministrarUser extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    private FloatingActionButton floatingActionButton;
    private  FloatingActionButton floatingActionButton2;

    private String pdfLinkEntrenamiento = "https://drive.google.com/file/d/1sx6H_ZeY5ko0FSoD62jprzbdaxBgXmVp/view?usp=sharing";
    private String pdfLinkDieta= "https://drive.google.com/file/d/1SZqZpKekxO8C3r2KbB223YMWhGqsqNFF/view";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_user);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }

        floatingActionButton = findViewById(R.id.floatingActionButtonPDF);
        floatingActionButton2 = findViewById(R.id.floatingActionButtonEnviar);
        textView1 = findViewById(R.id.textViewAdminUser);
        //textView2 = findViewById(R.id.textViewTexto);

        textView1.setText("Compra: PRINCIPIANTES\nEdad: 22\nCm: 170\nKg: 66\nComentarios: hdhzj");


        if (getIntent().getExtras() != null){
            toolbar.setTitle(getIntent().getExtras().getString("nombre"));
          //  textView1.setText(getIntent().getExtras().getString("nombre"));
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfLinkEntrenamiento));
                startActivity(browserIntent);

            }

            });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfLinkDieta));
                startActivity(browserIntent);
            }
        });

    }

}
