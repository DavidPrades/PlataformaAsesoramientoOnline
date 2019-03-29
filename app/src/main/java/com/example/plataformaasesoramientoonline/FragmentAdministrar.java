package com.example.plataformaasesoramientoonline;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAdministrar extends Fragment {


    public FragmentAdministrar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_administrar, container, false);

        final ArrayList<Administrar> items = new ArrayList<Administrar>();
        items.add(new Administrar(R.drawable.tytyy, "David Prades"));
        items.add(new Administrar(R.drawable.magnetosfera, "Emilio Gonzalez"));


        final RecyclerView recView = rootView.findViewById(R.id.recyclerViewAdmin);
        recView.setHasFixedSize(true);
        AdministrarAdapter tarjetaAdapter = new AdministrarAdapter(items);
        recView.setAdapter(tarjetaAdapter);
        recView.setItemAnimator(new DefaultItemAnimator());

        registerForContextMenu(recView);

        AdministrarAdapter adaptador = new AdministrarAdapter(items);
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        registerForContextMenu(recView);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                Administrar i = items.get(recView.getChildAdapterPosition(v));

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) getContext());

                int itemPosition = recView.getChildAdapterPosition(v);
                Intent intent = new Intent(getContext(), AdministrarUser.class);
                intent.putExtra("nombre", items.get(itemPosition).getTexto());

                intent.putExtra("LOGO", i.getLogo());

                startActivity(intent, options.toBundle());

            }
        });

        return  rootView;
    }

}
