package com.example.plataformaasesoramientoonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class FragmentTransformation extends Fragment {


    public FragmentTransformation() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_transformaciones, container, false);
        final ArrayList<Image> items = new ArrayList<>();
        items.add(new Image(R.drawable.transfor1));
        items.add(new Image(R.drawable.transfor2));
        items.add(new Image(R.drawable.transfor3));
        items.add(new Image(R.drawable.transfor4));
        items.add(new Image(R.drawable.transfor5));
        items.add(new Image(R.drawable.transfor6));


        final RecyclerView recView = (RecyclerView) rootView.findViewById((R.id.recyclerView));
        recView.setItemAnimator(new DefaultItemAnimator());


        registerForContextMenu(recView);

        ImageAdapter adaptador = new ImageAdapter(items);
        recView.setAdapter(adaptador);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        //recView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false ));

        return rootView;

    }
}
