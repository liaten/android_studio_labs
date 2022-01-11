package com.example.app10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editTextNumber, editTextNumber2, editTextNumber3;
    TextView textView, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = (EditText) findViewById(R.id.et1);
        editTextNumber2 = (EditText) findViewById(R.id.et2);
        editTextNumber3 = (EditText) findViewById(R.id.et3);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editTextNumber.getText().toString());
                int b = Integer.parseInt(editTextNumber2.getText().toString());
                int c = Integer.parseInt(editTextNumber3.getText().toString());
                double d = Math.pow(b, 2) - 4*a*c;
                double x1 = (-b - Math.pow(d, 0.5))/(2*a);
                double x2 = (-b + Math.pow(d, 0.5))/(2*a);
                String sx1 = String.format("%.2f",x1);
                String sx2 = String.format("%.2f",x2);
                String ans = "x1 = "+sx1+"\nx2 = "+ sx2;
                textView2.setText(ans);
            }
        });
    }
}