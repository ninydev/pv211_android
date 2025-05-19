package com.itstep.myfilesdb;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

public class MainActivity extends AppCompatActivity {

    protected final String TAG = "MainActivity";
    protected final String API_URL = "https://randomfox.ca/floof/";
    protected final String API_KEY = "38b9e2b8c045a10d8fdc7252a2f127f7";


protected  void testTmdb() {

    new Thread( new Runnable() {
        @Override
        public void run() {
            try {
                // Создание экземпляра TmdbApi с использованием API_KEY
                TmdbApi tmdbApi = new TmdbApi(API_KEY);

                // Получение экземпляра TmdbMovies
                TmdbMovies tmdbMovies = tmdbApi.getMovies();

                // Получение информации о фильме по его ID
                MovieDb movie = tmdbMovies.getMovie(603, "en-US");

                // Вывод названия фильма в лог
                Log.d(TAG, movie.getTitle());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        checkPermission();


    }

    protected void checkPermission() {

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

        testTmdb();

    }
}