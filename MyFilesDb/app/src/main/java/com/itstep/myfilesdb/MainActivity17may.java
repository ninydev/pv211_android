package com.itstep.myfilesdb;

import static java.net.HttpURLConnection.HTTP_OK;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity17may extends AppCompatActivity {

    protected ArrayList<FoxModel> foxs = new ArrayList<>();

    protected ArrayAdapter<FoxModel> adapter;



    protected String TAG = "MainActivity";
    protected String API_URL = "https://randomfox.ca/floof/";
    protected void loadData() {

    }

    protected void getContent() {
        HttpsURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(API_URL);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.connect();

            if (connection.getResponseCode() != HTTP_OK) {
                Log.e(TAG, "Error response: " + connection.getResponseCode());
                return;
            }

            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String jsonResponse = sb.toString();
            Log.d(TAG, "Response: " + jsonResponse);

            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonResponse);
            String image = jsonObject.optString("image");
            String link = jsonObject.optString("link");
            FoxModel fox = new FoxModel();
            fox.setImage(image);
            fox.setLink(link);
            foxs.add(fox);
            runOnUiThread(() -> {
                adapter.notifyDataSetChanged();
            });

        } catch (Exception e) {
            Log.e(TAG, "Error connection: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing reader: " + e.getMessage());
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing input stream: " + e.getMessage());
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Проверка и запрос разрешения на доступ к интернету (если требуется)
        if (checkSelfPermission(android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.INTERNET}, 1);
        }
        // Load data from API
        // getContent();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foxs);
        ListView lw = findViewById(R.id.list_view);
        lw.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                getContent();
            }
        }).start();

    }
}