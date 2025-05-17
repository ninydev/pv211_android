package com.itstep.myfilesdb;

import static java.net.HttpURLConnection.HTTP_OK;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
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

    private void readPhotos() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                android.provider.MediaStore.Images.Media.DATE_ADDED + " DESC" // Sort by date added
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int pathIdx = cursor.getColumnIndex(android.provider.MediaStore.Images.Media.DATA);
                int nameIdx = cursor.getColumnIndex(android.provider.MediaStore.Images.Media.DISPLAY_NAME);

                String path = pathIdx != -1 ? cursor.getString(pathIdx) : "Unknown";
                String name = nameIdx != -1 ? cursor.getString(nameIdx) : "Unknown";

                Log.d("Photo", "Name: " + name + ", Path: " + path);
            }
            cursor.close();
        } else {
            Log.e("Photo", "Cursor is null");
        }
    }

    private void readCallLog() {
        ContentResolver contentResolver = getContentResolver();

        // Запрос журнала вызовов
        Cursor cursor = contentResolver.query(
                CallLog.Calls.CONTENT_URI,
                null,
                null,
                null,
                CallLog.Calls.DATE + " DESC" // Сортировка по дате
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Индексы нужных столбцов
                int numberIdx = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                int typeIdx = cursor.getColumnIndex(CallLog.Calls.TYPE);
                int dateIdx = cursor.getColumnIndex(CallLog.Calls.DATE);
                int durationIdx = cursor.getColumnIndex(CallLog.Calls.DURATION);

                // Извлечение данных
                String number = numberIdx != -1 ? cursor.getString(numberIdx) : "Unknown";
                String callType = typeIdx != -1 ? getCallType(cursor.getInt(typeIdx)) : "Unknown";
                String date = dateIdx != -1 ? cursor.getString(dateIdx) : "Unknown";
                String duration = durationIdx != -1 ? cursor.getString(durationIdx) : "0";

                // Логирование данных вызова
                Log.d("LastCall", "Number: " + number + ", Type: " + callType + ", Date: " + date + ", Duration: " + duration + " seconds");
            }
            cursor.close();
        } else {
            Log.e("LastCall", "Cursor is null");
        }
    }

    // Метод для преобразования типа вызова
    private String getCallType(int type) {
        switch (type) {
            case CallLog.Calls.INCOMING_TYPE:
                return "Incoming Call";
            case CallLog.Calls.OUTGOING_TYPE:
                return "Outgoing Call";
            case CallLog.Calls.MISSED_TYPE:
                return "Missed Call";
            case CallLog.Calls.VOICEMAIL_TYPE:
                return "Voicemail";
            case CallLog.Calls.REJECTED_TYPE:
                return "Rejected Call";
            case CallLog.Calls.BLOCKED_TYPE:
                return "Blocked Call";
            case CallLog.Calls.ANSWERED_EXTERNALLY_TYPE:
                return "Answered Externally";
            default:
                return "Unknown Type";
        }
    }



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
        // Проверка и запрос разрешения на доступ к контактам (если требуется)
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CALL_LOG}, 1);
        }

        if (checkSelfPermission(Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_MEDIA_IMAGES}, 1);
        }

        readContacts();
        readCallLog();
        readPhotos();



    }
}