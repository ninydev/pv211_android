package com.itstep.myfilesdb;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityCalculator extends AppCompatActivity {

    protected ArrayList<String> commands = new ArrayList<>();

    protected void seedCommands() {
        commands.add("Сложение");
        commands.add("Вычитание");
        commands.add("Умножение");
        commands.add("Деление");
        commands.add("Степень");
        commands.add("Корень");
        commands.add("Логарифм");
        commands.add("1+2");
        commands.add("5+5");
        commands.add("12+4");
        commands.add("12-2");
        commands.add("44-4");
        commands.add("Степень");
        commands.add("Корень");
        commands.add("Логарифм");
        commands.add("5+5");
        commands.add("12+4");
        commands.add("12-2");
        commands.add("44-4");
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

        ListView listView = findViewById(R.id.commands_list);
        seedCommands();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, commands);
        listView.setAdapter(adapter);



    }
}