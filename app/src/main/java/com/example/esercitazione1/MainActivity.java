package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button incremento, decremento;
    EditText input;
    int minvalue = 0;
    int maxvalue = 100;
    int modelvalue = 50;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        decremento = findViewById(R.id.decremento);
        input = findViewById(R.id.input);
        seekBar = findViewById(R.id.seekbar);
        updateValue(modelvalue);

        incremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //input.setText("+1");
                updateValue(++modelvalue);
            }
        }

        );

        decremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updateValue(--modelvalue);
            }
        }

        );

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateValue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());
            }
        });

    }

    protected void updateValue(int newValue){
        if(this.seekBar.getProgress() != this.modelvalue){
            this.seekBar.setProgress(this.modelvalue);
        }
        newValue = newValue >maxvalue ? maxvalue : newValue;
        newValue = newValue <minvalue ? minvalue : newValue;
        this.modelvalue=newValue;
        input.setText(""+this.modelvalue);
    }

    /*@Override
    protected void onStop(){
        super.onStop();

        TextView helloword = findViewById(R.id.helloword);
        helloword.setText("on stop");
    }*/
}