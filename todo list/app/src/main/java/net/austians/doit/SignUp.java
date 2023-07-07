package net.austians.doit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import net.austians.doit.R;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import net.austians.doit.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import net.austians.doit.Login;

import static net.austians.doit.R.*;

public class SignUp extends AppCompatActivity {

    EditText signUpEmail, signUpPass;
    Button signUpBtn;
    TextView signUpText;
    FirebaseAuth mFirebaseAuth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.sign_up);

        //mFirebaseAuth = FirebaseAuth.getInstance();

        signUpEmail = findViewById(id.signUpEmail);
        signUpPass = findViewById(id.signUpPass);
        signUpBtn = findViewById(id.signUpBtn);
        signUpText = findViewById(id.signUpText);

        pd = new ProgressDialog(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signUpEmail.getText().toString().length()==0 || signUpPass.getText().toString().length()==0)
                    Toast.makeText(SignUp.this, "Don't keep any field empty", Toast.LENGTH_SHORT).show();
                else{
                Toast.makeText(SignUp.this, "Regestering New User...", Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(SignUp.this, Login.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }}
        });


        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
}