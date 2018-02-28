package com.example.raul.tareacorta1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    public void convertirClicked(View view){
        EditText cantidadMoneda = (EditText) findViewById(R.id.editText);
        Spinner selectorMonedaOrigen = (Spinner) findViewById(R.id.spinner);
        Spinner selectorMonedaDestino = (Spinner) findViewById(R.id.spinner2);
        TextView resultadoConversion = (TextView) findViewById(R.id.textViewResultado);

        String cant, smo, smd;

        cant = cantidadMoneda.getText().toString();
        smo = selectorMonedaOrigen.getItemAtPosition(selectorMonedaOrigen.getSelectedItemPosition()).toString();
        smd = selectorMonedaDestino.getItemAtPosition(selectorMonedaDestino.getSelectedItemPosition()).toString();

        String url = "https://finance.google.com/finance/converter?a="+cant+"&from="+smo+"&to="+smd+"&meta=ei%3DR5KQWsiRHJWXmAGEypXgCA";
        new AsyncTask(this, url, resultadoConversion).execute();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] datos = new String[] {"AED","AFN","ALL","AMD","ANG","AOA","ARS","AUD","AWG","AZN","BAM","BBD","BDT","BGN","BHD","BIF","BMD",
                "BND","BOB","BRL","BSD","BTC","BTN","BWP","BYN","BYR","BZD","CAD","CDF","CHF","CLF","CLP","CNH","CNY","COP","CRC","CUP","CVE",
                "CZK","DEM","DJF","DKK","DOP","DZD","EGP","ERN","ETB","EUR","FIM","FJD","FKP","FRF","GBP","GEL","GHS","GIP","GMD","GNF","GTQ",
                "GYD","HKD","HNL","HRK","HTG","HUF","IDR","IEP","ILS","INR","IQD","IRR","ISK","ITL","JMD","JOD","JPY","KES","KGS","KHR","KMF",
                "KPW","KRW","KWD","KYD","KZT","LAK","LBP","LKR","LRD","LSL","LTL","LVL","LYD","MAD","MDL","MGA","MKD","MMK","MNT","MOP","MRO",
                "MUR","MVR","MWK","MXN","MYR","MZN","NAD","NGN","NIO","NOK","NPR","NZD","OMR","PAB","PEN","PGK","PHP","PKG","PKR","PLN","PYG",
                "QAR","RON","RSD","RUB","RWF","SAR","SBD","SCR","SDG","SEK","SGD","SHP","SKK","SLL","SOS","SRD","STD","SVC","SYP","SZL","THB",
                "TJS","TMT","TND","TOP","TRY","TTD","TWD","TZS","UAH","UGX","USD","UYU","UZS","VEF","VND","VUV","WST","XAF","XCD","XDR","XOF",
                "XPF","YER","ZAR","ZMK","ZMW","ZWL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        Spinner selectorMonedaOrigen = (Spinner) findViewById(R.id.spinner);
        Spinner selectorMonedaDestino = (Spinner) findViewById(R.id.spinner2);
        selectorMonedaOrigen.setAdapter(adapter);
        selectorMonedaDestino.setAdapter(adapter);
    }
}
