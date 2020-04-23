package com.example.kmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    Timer timer = new Timer();
    int Kmi_skaicius;
    ConstraintLayout bgElement;
    public void mygtukas(View view){
int pasirinko =0;
        double x=0;
        String fname = ((EditText)findViewById(R.id.mase)).getText().toString();
        double kuno_mase = Double.parseDouble(fname);
        String ugis_string = ((EditText)findViewById(R.id.editText2)).getText().toString();
        double ugis = Double.parseDouble(ugis_string);
        TextView pirmas= ((TextView )findViewById(R.id.textView));
        TextView antras= ((TextView )findViewById(R.id.textView2));

        CheckBox  vyriska = (CheckBox)findViewById(R.id.checkBox);
        CheckBox mopteriska = (CheckBox)findViewById(R.id.checkBox2);

        EditText editText = (EditText)findViewById(R.id.KMI);

        if(mopteriska.isChecked() && vyriska.isChecked()) {
            Toast.makeText(this,"Pasirinkite tik vieną lytį", Toast.LENGTH_SHORT).show();
            pasirinko=0;
        }
       else if(mopteriska.isChecked()){
            x = kuno_mase / Math.pow((ugis / 100), 2);
            pasirinko++;
        }
       else if(vyriska.isChecked()){
            x = kuno_mase / Math.pow((ugis / 100), 2);
            pasirinko++;
        }
        else{
            Toast.makeText(this,"Pasirinkite lytį", Toast.LENGTH_SHORT).show();
            pasirinko=0;
        }
        DecimalFormat formatter = new DecimalFormat("#,###.00");
if(pasirinko!=0) {
    editText.setText("" + formatter.format(x));
    if(x<18.5 || x>30) {
        bgElement = (ConstraintLayout) findViewById(R.id.backr);
        bgElement.setBackgroundColor(Color.RED);
        pirmas.setVisibility(View.VISIBLE);
        antras.setVisibility(View.VISIBLE);
    }else if(18.5<x && x<25){
        bgElement = (ConstraintLayout) findViewById(R.id.backr);
        bgElement.setBackgroundColor(Color.GREEN);
        pirmas.setVisibility(View.VISIBLE);
        antras.setVisibility(View.VISIBLE);
    }
    else if(x>25 && x<30){
        int orange = Color.rgb(255, 165, 0);
        bgElement = (ConstraintLayout) findViewById(R.id.backr);
        bgElement.setBackgroundColor(Color.rgb(255, 165, 0));
        pirmas.setVisibility(View.VISIBLE);
        antras.setVisibility(View.VISIBLE);
    }
}


        pasirinko=0;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
