package com.example.plataformaasesoramientoonline;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEntrenamientos extends Fragment implements View.OnClickListener {


    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private Button principiante, intermedio, avanzado, totalPack;

    public FragmentEntrenamientos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_entrenamientos, container, false);


        principiante= rootView.findViewById(R.id.principiante);
        intermedio= rootView.findViewById(R.id.intermedio);
        avanzado= rootView.findViewById(R.id.avanzado);
        totalPack= rootView.findViewById(R.id.totalPack);


        principiante.setOnClickListener(this);
        intermedio.setOnClickListener(this);
        avanzado.setOnClickListener(this);
        totalPack.setOnClickListener(this);
        return rootView;
    }



    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.principiante:
                Intent intent = new Intent(getContext(), PerfilActivity.class);
                String compra =principiante.getText().toString();
                intent.putExtra("compra",compra);
                startActivity(intent);
                break;
            case R.id.intermedio:
                Intent intent2 = new Intent(getContext(), PerfilActivity.class);
                String compra2 =intermedio.getText().toString();
                intent2.putExtra("compra",compra2);
                startActivity(intent2);
                break;
            case R.id.avanzado:
                Intent intent3 = new Intent(getContext(), PerfilActivity.class);
                String compra3 =avanzado.getText().toString();
                intent3.putExtra("compra",compra3);
                startActivity(intent3);
                break;
            case R.id.totalPack:
                Intent intent4 = new Intent(getContext(), PerfilActivity.class);
                String compra4 =totalPack.getText().toString();
                intent4.putExtra("compra",compra4);
                startActivity(intent4);
                break;
        }

    }


}
