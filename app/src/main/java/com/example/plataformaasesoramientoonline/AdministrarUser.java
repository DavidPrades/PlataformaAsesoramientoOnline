package com.example.plataformaasesoramientoonline;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AdministrarUser extends AppCompatActivity {

    TextView textView1;
    TextView textView2;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_user);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }


        textView1 = findViewById(R.id.textViewAdminUser);
        //textView2 = findViewById(R.id.textViewTexto);

        textView1.setText("Compra: PRINCIPIANTES \n" +
                "Edad: 22\n" +
                "Cm: 170 \n" +
                "Kg: 66 \n" +
                "Comentarios: hdhzj");


        if (getIntent().getExtras() != null){
            toolbar.setTitle(getIntent().getExtras().getString("nombre"));
          //  textView1.setText(getIntent().getExtras().getString("nombre"));
        }
    }
}
