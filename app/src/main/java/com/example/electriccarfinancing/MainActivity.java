package com.example.electriccarfinancing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int intYears;
    int intLoan;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final EditText years = (EditText)findViewById(R.id.txtYears);
        final EditText loan = (EditText)findViewById(R.id.txtLoan);
        final EditText interest = (EditText)findViewById(R.id.txtInterest);
        Button button = (Button)findViewById(R.id.btnPayment);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loan.getText().toString());
                decInterest = Float.parseFloat(interest.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decInterest);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));

            }
        });

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}