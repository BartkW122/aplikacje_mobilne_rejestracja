package com.example.rejestracja;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button confirm;
    private EditText email;
    private EditText haslo;
    private EditText haslo_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        confirm=findViewById(R.id.zatwierdz);
        email=findViewById(R.id.email);
        haslo=findViewById(R.id.haslo);
        haslo_p=findViewById(R.id.haslo_p);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email=email.getText().toString().trim();
                String input_haslo=haslo.getText().toString().trim();
                String input_haslo_p=haslo_p.getText().toString().trim();

                if(input_email.isEmpty()){
                    Toast.makeText(MainActivity.this,"Wypelnij pole E-mail",Toast.LENGTH_LONG).show();
                    return;
                }
                if(input_haslo.isEmpty()){
                    Toast.makeText(MainActivity.this,"Wypelnij pole Haslo",Toast.LENGTH_LONG).show();
                    return;
                }
                if(input_haslo_p.isEmpty()){
                    Toast.makeText(MainActivity.this,"Wypelnij pole Powtorz haslo",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()){
                    Toast.makeText(MainActivity.this,"Email jest nie poprawny",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!input_haslo_p.equals(input_haslo)){
                    Toast.makeText(MainActivity.this,"Haslo musi sie powtarzac",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}