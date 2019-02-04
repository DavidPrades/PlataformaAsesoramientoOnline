package com.example.plataformaasesoramientoonline;


import android.content.Intent;
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
    private Button totalPAck;
    private DatabaseReference mDatabase;

    public FragmentEntrenamientos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_entrenamientos, container, false);

       totalPAck= rootView.findViewById(R.id.totalPack);
       totalPAck.setOnClickListener(this);
        return rootView;
    }



    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getContext(), PerfilActivity.class);
        startActivity(intent);
    }


}
