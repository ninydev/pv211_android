package com.itstep.myfilesdb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private void writeToFile(){
         File file = new File(getFilesDir(), "myfile.txt");
         try (FileOutputStream fos = new FileOutputStream(file)) {
             fos.write("Hello, World!".getBytes());
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    private void readFromFile(){
        File file = new File(getFilesDir(), "myfile.txt");
        if (file.exists()) {
            Log.i("File", "File exists: " + file.getAbsolutePath());

            try {
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
                Log.i("File", "File content: " + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("File", "File does not exist");
        }
    }

    SQLiteDatabase db = null;

    private void openDatabase() {
        db = openOrCreateDatabase("my.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS files " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");
    }

    private void seedDatabase() {
        db.execSQL("INSERT OR IGNORE INTO files (id, name) VALUES (1, 'file1.txt');");
        db.execSQL("INSERT OR IGNORE  INTO files (id, name) VALUES (2, 'file2.txt');");
        db.execSQL("INSERT OR IGNORE  INTO files (id, name) VALUES (3, 'file3.txt');");
    }

    private void echoDatabase() {
        // db.execSQL("SELECT * FROM files;");

        Cursor cursor = db.rawQuery("SELECT name, id FROM files;", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex("id");
                int nameIndex = cursor.getColumnIndex("name");

                if (idIndex != -1 && nameIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String name = cursor.getString(nameIndex);
                    Log.i("DB", "ID: ("+ idIndex + ") " + id + ", Name: " + name);
                } else {
                    Log.e("DB", "Column not found in cursor");
                }
            }
            cursor.close();
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

        openDatabase();
        seedDatabase();
        echoDatabase();

        writeToFile();
        readFromFile();
    }
}