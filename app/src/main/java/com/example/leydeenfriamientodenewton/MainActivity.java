package com.example.leydeenfriamientodenewton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void irAmenu (View view){

        Intent menu = new Intent(this, ley_newton_enfria.class);
        startActivity(menu);


    }
    @SuppressLint("")
    public void Salir (View view){
        finishAffinity();
    }

}