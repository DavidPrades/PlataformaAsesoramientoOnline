package com.example.plataformaasesoramientoonline;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.parseInt;

public class PerfilActivity extends AppCompatActivity {
    FirebaseDatabase database;

    DatabaseReference usuarios;
    Bundle parametros;

    private EditText name, email, age, height, weight, observation;
    private TextView compra;
    private Button buttonSendInformation;
    private Color color;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }


        name = findViewById(R.id.editTextNamePerfil);
        email = findViewById(R.id.editTextEmailPerfil);
        compra = findViewById(R.id.textViewCompra);
        age = findViewById(R.id.editTextAgePerfil);
        height = findViewById(R.id.editTextHeightPerfil);
        weight = findViewById(R.id.editTextWeightPerfil);
        observation = findViewById(R.id.editTextobservationPerfil);

        database = FirebaseDatabase.getInstance();
        usuarios = database.getReference("usuariosPlataformaOnline");

        database.getReference("informes").orderByChild("receptor_uid").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("ProfileActivity", dataSnapshot.getValue().toString());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        buttonSendInformation = findViewById(R.id.buttonSend);


        parametros = getIntent().getExtras();
        String datos = parametros.getString("compra");
        compra.setText(compra.getText() + " " + datos);
        buttonSendInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(name.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                String nameFinal = name.getText().toString();
                if (TextUtils.isEmpty(email.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                String emailFinal = email.getText().toString();

                String textViewFinal = compra.getText().toString();
                if (TextUtils.isEmpty(age.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Age", Toast.LENGTH_SHORT).show();
                    return;
                }
                int ageFinal = Integer.parseInt(age.getText().toString());
                if (TextUtils.isEmpty(height.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Height", Toast.LENGTH_SHORT).show();
                    return;
                }
                double heightFinal = Double.parseDouble(height.getText().toString());

                if (TextUtils.isEmpty(weight.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Weight", Toast.LENGTH_SHORT).show();
                    return;
                }
                double weightFinal = Double.parseDouble(weight.getText().toString());
                if (TextUtils.isEmpty(observation.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter Observation", Toast.LENGTH_SHORT).show();
                    return;
                }
                String descriptionFinal = observation.getText().toString();

                User user = new User("" + nameFinal, "" + emailFinal, "" + textViewFinal, ageFinal, heightFinal, weightFinal, "" + descriptionFinal);

                usuarios.child(""+ nameFinal).setValue(user);
                Toast.makeText(PerfilActivity.this, "Registered user successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
