package com.itstep.myfilesdb;

import static java.net.HttpURLConnection.HTTP_OK;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
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

public class MainActivity extends AppCompatActivity {


    private void readContacts() {

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(
                android.provider.ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {

                int idx = cursor.getColumnIndex(android.provider.ContactsContract.Contacts._ID);
                String id = cursor.getString(idx);

                int nameIdx = cursor.getColumnIndex(android.provider.ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(nameIdx);

                Cursor phones = contentResolver.query(
                        android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        android.provider.ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{id},
                        null
                );
                if (phones != null) {
                    while (phones.moveToNext()) {
                        int phoneIdx = phones.getColumnIndex(android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER);
                        if (phoneIdx == -1) {
                            Log.e("Contact", "Phone number index not found");
                            continue;
                        }
                        String phoneNumber = phones.getString(phoneIdx);
                        Log.d("Contact", "Name: " + name + ", Phone: " + phoneNumber);
                    }
                    phones.close();
                }
            }
            cursor.close();
        } else {
            Log.e("Contact", "Cursor is null");
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        // Проверка и запрос разрешения на доступ к интернету (если требуется)
        if (checkSelfPermission(android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.INTERNET}, 1);
        }

        // Проверка и запрос разрешения на доступ к контактам (если требуется)
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, 1);
        }

        readContacts();




    }
}