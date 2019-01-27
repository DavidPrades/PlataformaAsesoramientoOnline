package com.example.plataformaasesoramientoonline;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {


    EditText name;
    EditText email;
    EditText editText;
    Spinner spinner;
    Button button;

    String[] palabras = {"Colaboraciones", "Sponsors", "Consultas", "Asesoramiento"};
    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        name = rootView.findViewById(R.id.editTextName);
        email = rootView.findViewById(R.id.editTextemail);
        editText = rootView.findViewById(R.id.editMensae);
        spinner = rootView.findViewById(R.id.spinner);
        button = rootView.findViewById(R.id.buttonSend);
        spinner.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,palabras));

        button.setOnClickListener(this);

        return rootView;
    }

    public void sendEmail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"thetitanfit@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, ""+spinner.getSelectedItem());
        i.putExtra(Intent.EXTRA_TEXT   , editText.getText());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
            Toast.makeText(getActivity(), "Send mail with", Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
