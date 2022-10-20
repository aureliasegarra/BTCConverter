package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Button btnConvert;
    public TextView info;
    public TextView result;
    public RadioGroup rg1;
    public RadioGroup rg2;
    public RadioButton euro1,euro2,bitcoin1,bitcoin2;
    public double euroToBitcoin;
    public double euroToEuro;
    public double bitcoinToEuro;
    public double bitcoinToBitcoin;

    public double input1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = findViewById(R.id.convert);
        info = findViewById(R.id.input1);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        result =findViewById(R.id.input2);
        euro1 = findViewById(R.id.eur1);
        euro2 = findViewById(R.id.eur2);
        bitcoin1 = findViewById(R.id.bitcoins1);
        bitcoin2 = findViewById(R.id.bitcoins2);


        euro1.setChecked(true);
        bitcoin2.setChecked(true);

        btnConvert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString())){
                    info.setError("Please enter a number");
                    return;
                }
                input1 = Double.parseDouble(info.getText().toString());

                euroToBitcoin = input1*19550;
                euroToEuro = input1;
                bitcoinToEuro = input1/0.000051;
                bitcoinToBitcoin = input1;

                RadioButton selected1 = findViewById(rg1.getCheckedRadioButtonId());
                RadioButton selected2 = findViewById(rg2.getCheckedRadioButtonId());
                String s2 = getResources().getResourceEntryName(selected1.getId());
                String s1 = getResources().getResourceEntryName(selected2.getId());
                if(s1.equals("eur1")){
                    switch (s2){
                        case "eur2":
                            result.setText(String.valueOf(euroToEuro));
                            break;
                        case "bitcoins2":
                            result.setText(String.valueOf(euroToBitcoin));
                            break;
                    }
                }
                if(s1.equals("bitcoins1")){
                    switch (s2){
                        case "eur2":
                            result.setText(String.valueOf(bitcoinToEuro));
                            break;
                        case "bitcoins2":
                            result.setText(String.valueOf(bitcoinToBitcoin));
                            break;
                    }
                }
            }
        });
    }
}

