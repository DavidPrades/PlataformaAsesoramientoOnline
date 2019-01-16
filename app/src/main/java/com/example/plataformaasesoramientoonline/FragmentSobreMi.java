package com.example.plataformaasesoramientoonline;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSobreMi extends Fragment implements View.OnClickListener {

    public Button buttonYoutube;
    public Button buttonInstagram;
    public Button buttonTwitter;
    public Button buttonFacebook;
    public FragmentSobreMi() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sobre_mi, container, false);
        // Inflate the layout for this fragment
        buttonYoutube  = rootView.findViewById(R.id.buttonYoutube);
        buttonInstagram  = rootView.findViewById(R.id.buttonInstagram);
        buttonTwitter  = rootView.findViewById(R.id.buttonTwitter);
        buttonFacebook  = rootView.findViewById(R.id.buttonFacebook);

        buttonYoutube.setBackground(getResources().getDrawable(R.drawable.youtube));
        buttonInstagram.setBackground(getResources().getDrawable(R.drawable.botoninstagram));
        buttonTwitter.setBackground(getResources().getDrawable(R.drawable.twitter));
        buttonFacebook.setBackground(getResources().getDrawable(R.drawable.facebook));

        buttonYoutube.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCnpCOBcIaj_zAhl19j2ex7Q"));
        startActivity(i);
    }

}
