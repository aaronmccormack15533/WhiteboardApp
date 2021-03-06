package com.example.aaron.whiteboardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private Animation uptodown;
    private Animation downtoup;
    private LinearLayout linearOne;
    private LinearLayout linearTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.login_btn);
        Button registerButton = (Button) findViewById(R.id.registerBtn);

        emailEditText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
        linearOne = (LinearLayout) findViewById(R.id.linearOne);
        linearTwo = (LinearLayout) findViewById(R.id.linearTwo);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.up_to_down);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.down_to_up);

        linearOne.setAnimation(uptodown);
        linearTwo.setAnimation(downtoup);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        Intent i = new Intent();
    }

    public void runMethod(){
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your Password", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void registerCall(){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.login_btn:
                runMethod();
                break;

            case R.id.registerBtn:
                registerCall();
                break;

            default:
                break;
        }
    }
}
