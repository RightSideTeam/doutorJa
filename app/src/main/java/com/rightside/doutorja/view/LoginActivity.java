package com.rightside.doutorja.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rightside.doutorja.R;
import com.rightside.doutorja.modelo.Consulta;
import com.rightside.doutorja.modelo.Usuario;
import com.rightside.doutorja.utils.ConsultaUtils;
import com.rightside.doutorja.utils.Singleton;

public class LoginActivity extends AppCompatActivity {


    private SignInButton mGooglebtn;

    private static final int RC_SIGN_IN = 1;

    private GoogleApiClient mGoogleApiClient;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    private DatabaseReference myRef;


    private Usuario usuario;

    private static final String TAG = "LOGIN_ACTIVITY";

    Consulta consulta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myRef = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(LoginActivity.this, DiaDaSemanaActivity.class));
                    Toast.makeText(LoginActivity.this, "Login efetuado.", Toast.LENGTH_LONG).show();

                    salvaLogin(firebaseAuth.getCurrentUser().getEmail(), firebaseAuth.getCurrentUser().getDisplayName(), firebaseAuth.getCurrentUser().getPhoneNumber());
                    Usuario usuario = new Usuario();
                    usuario.setEmail(firebaseAuth.getCurrentUser().getEmail());
                    usuario.setNome(firebaseAuth.getCurrentUser().getDisplayName());

                   Singleton.getInstacia().salvaUsuario(usuario);
                }else{
                    signIn();

                }

            }
        };



        mGooglebtn = findViewById(R.id.googlebutton);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {


                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mGooglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();

            }
        });



    }

    private void salvaLogin(String email, String nome, String telefone) {
        final SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_config), Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("nome", nome).apply();
        sharedPreferences.edit().putString("email", email).apply();
        sharedPreferences.edit().putString("telefone", telefone).apply();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                assert account != null;
                firebaseAuthWithGoogle(account);




            } else {
                Toast.makeText(LoginActivity.this, "Erro. Tente novamente.", Toast.LENGTH_LONG).show();


            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" +task.isSuccessful());

                        if (!task.isSuccessful()){
                            salvaLogin(task.getResult().getUser().getEmail(), task.getResult().getUser().getDisplayName(), task.getResult().getUser().getPhoneNumber());
                            Log.w(TAG, "signInWithCredential:", task.getException());
                            Toast.makeText(LoginActivity.this, "Autenticação falhou.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }


                });

    }

}

