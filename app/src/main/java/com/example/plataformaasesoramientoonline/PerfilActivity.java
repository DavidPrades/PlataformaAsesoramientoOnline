package com.example.plataformaasesoramientoonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.parseInt;

public class PerfilActivity extends AppCompatActivity {
    FirebaseDatabase database;

    DatabaseReference usuarios;


    private EditText name, email, age, height, weight, observation;
    private Button buttonSendInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        name = findViewById(R.id.editTextNamePerfil);
        email = findViewById(R.id.editTextEmailPerfil);
        age = findViewById(R.id.editTextAgePerfil);
        height = findViewById(R.id.editTextHeightPerfil);
        weight = findViewById(R.id.editTextWeightPerfil);
        observation = findViewById(R.id.editTextobservationPerfil);


        database = FirebaseDatabase.getInstance();
        usuarios = database.getReference("usuariosPlataformaOnline");


        buttonSendInformation = findViewById(R.id.buttonSend);


        buttonSendInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameFinal = name.getText().toString();
                String emailFinal = email.getText().toString();
                int ageFinal= Integer.parseInt(age.getText().toString());
                double heightFinal =Double.parseDouble(height.getText().toString());
                double weightFinal =Double.parseDouble(weight.getText().toString());
                String descriptionFinal = observation.getText().toString();

               User user = new User(""+nameFinal,""+emailFinal,ageFinal,heightFinal,weightFinal,""+descriptionFinal);
                //User usuarioPrueba = new User("Prueba 1", "prueba@gmail.com", 22, 170, 70, "Probando nuevo usuario");

                //String clau = usuarios.push().getKey();
                usuarios.child(""+nameFinal).setValue(user);


                Toast.makeText(PerfilActivity.this, "Registered user successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
