package com.example.plataformaasesoramientoonline;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SingUp extends AppCompatActivity {
    private final static int SELECT_PHOTO = 12345;
    private EditText name_id, email_id, passwordcheck;
    private FirebaseAuth mAuth;
    private static final String TAG = "";
    private ProgressBar progressBar;
    private Button btnSelectImagen;
    Button ahsignup;
    private Color color;
    private ImageView imageSeleccion;
    private String picturePath;

    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        FirebaseApp.initializeApp(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        }


        mAuth = FirebaseAuth.getInstance();
        email_id = (EditText) findViewById(R.id.input_email);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        passwordcheck = (EditText) findViewById(R.id.input_password);
        ahsignup = (Button) findViewById(R.id.btn_signup);
        name_id= (EditText) findViewById(R.id.input_name);
        TextView btnSignUp = (TextView) findViewById(R.id.login_page);
        btnSelectImagen = findViewById(R.id.selectImage);

        imageSeleccion= null;
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUp.this, SingIn.class);
                startActivity(intent);
            }
        });


        ahsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUp2();
            }
        });

        btnSelectImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              selectImage();
            }
        });
    }

    private void singUp2() {
        String email = email_id.getText().toString();
        String password = passwordcheck.getText().toString();
        String name = name_id.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter Eamil Id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SingUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(SingUp.this, SingIn.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SingUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


   /* public static boolean isEmailValid(Editable email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case SELECT_PHOTO: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Toast.makeText(this, "Imagen seleccionada con exito", Toast.LENGTH_SHORT).show();
                    selectImage();
                } else {
                    Dialog d = new AlertDialog.Builder(SingUp.this).setTitle("Error").
                            setMessage("I need permission to read external storage").create();
                    d.show();

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                picturePath = data.getStringExtra("picturePath");
                File f = new File(picturePath);
                Uri contentUri = Uri.fromFile(f);


            }else{
                finish();
            }
        }
    }

    public void selectImage(){

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
          selectPhoto();
        }else{
            //Toast.makeText(SingUp.this, "You don't have permission", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(SingUp.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    SELECT_PHOTO);
        }

    }



        public void selectPhoto(){
            Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


            startActivityForResult(pickPhoto , SELECT_PHOTO);

    }


    }






