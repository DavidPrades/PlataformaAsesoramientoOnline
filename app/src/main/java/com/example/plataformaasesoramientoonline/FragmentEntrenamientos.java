package com.example.plataformaasesoramientoonline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEntrenamientos extends Fragment implements View.OnClickListener {

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mAuth;

    public FragmentEntrenamientos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_entrenamientos, container, false);
      /*  mAuth = FirebaseAuth.getInstance();
        Button button = rootView.findViewById(R.id.button);
        Button buttonSingOut = rootView.findViewById(R.id.buttonSingOut);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singIn();


            }
        });

        buttonSingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singOut();
            }
        });
*/
        return rootView;
    }

   /* private void singIn() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN);
    }
    @Override
    private void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    public void singOut(){
        AuthUI.getInstance()
                .delete(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }
*/

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onClick(View v) {

    }


}
