package com.example.plataformaasesoramientoonline;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSobreMi extends Fragment {


    public FragmentSobreMi() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sobre_mi, container, false);
        // Inflate the layout for this fragment

        Button button = rootView.findViewById(R.id.buttonYoutube);

        Log.d("canal", "fuera");
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("canal", "dentro");
               irAYoutube();
            }
        });


        return inflater.inflate(R.layout.fragment_sobre_mi, container, false);
    }


    public void irAYoutube(){
        Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
        startActivity(i);
    }


}
