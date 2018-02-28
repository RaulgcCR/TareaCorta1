package com.example.raul.tareacorta1;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Raul on 2/25/2018.
 */

public class AsyncTask extends android.os.AsyncTask<Void, Void , String>{

    private String url;
    private Context context;
    private TextView resultadoConversion;

    public AsyncTask(Context context, String url, TextView resulConver) {
        this.url = url;
        this.context = context;
        this.resultadoConversion = resulConver;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        String conversion;
        int response;
        StringBuilder dataset = null;


        try {
            URL Httpurl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) Httpurl.openConnection();
            response = urlConnection.getResponseCode();

            dataset = new StringBuilder();

            if(response==HttpURLConnection.HTTP_OK){
                InputStream input = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                while ((conversion=reader.readLine())!=null){
                    dataset.append(conversion);
                    Log.d("INFO:",conversion.toString());
                }

            }

        }catch (Exception e){

        }

            String resultado = dataset.substring(dataset.indexOf("<span class=bld>")+1,dataset.indexOf("</span>"));
            return resultado.substring(resultado.indexOf(">")+1);

    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
        resultadoConversion.setText(result);
    }
}
