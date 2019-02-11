package com.example.plataformaasesoramientoonline;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEntrenamientos extends Fragment {


    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private Button comprar;


    public FragmentEntrenamientos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_entrenamientos, container, false);

        final ArrayList<Entrenamientos> items = new ArrayList<Entrenamientos>();

          items.add(new Entrenamientos("BEGINNERS","24,99€",getString(R.string.rutinasprincipiantes)));
          items.add(new Entrenamientos("INTERMEDIOS","24,99€",getString(R.string.rutinasintermedios)));
          items.add(new Entrenamientos("INTERMEDIATES","24,99€",getString(R.string.rutinasavanzados)));
          items.add(new Entrenamientos("TOTAL PACK","49,90€",getString(R.string.rutinastotalpack)));



        final RecyclerView recView = rootView.findViewById(R.id.recyclerView2);
        recView.setHasFixedSize(true);
        EntrenamientosAdapter tarjetaAdapter = new EntrenamientosAdapter(items);
        recView.setAdapter(tarjetaAdapter);
        recView.setItemAnimator(new DefaultItemAnimator());

        registerForContextMenu(recView);

        final EntrenamientosAdapter adaptador = new EntrenamientosAdapter(items);
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        registerForContextMenu(recView);





        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Entrenamientos i = items.get(recView.getChildAdapterPosition(v));
                int itemPosition = recView.getChildAdapterPosition(v);
                Intent intent = new Intent(getContext(), PerfilActivity.class);
                String compra = i.getTitulo();
                adaptador.getItemViewPosition(itemPosition);
                intent.putExtra("compra",compra);
                startActivity(intent);
            }
        });



        return rootView;
    }



    @Override
    public void onStart() {
        super.onStart();


    }


}
