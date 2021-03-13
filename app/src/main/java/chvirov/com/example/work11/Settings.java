package chvirov.com.example.work11;

//  Создайте активити с настройками, где включите выбор темы приложения.
//  Доделайте приложение «Калькулятор». Это последний урок с созданием приложения «Калькулятор».
//  * Сделайте интент-фильтр для запуска калькулятора извне, а также напишите тестовое приложение, запускающее приложение-калькулятор.


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class Settings extends AppCompatActivity implements Constants {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_settings);

        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });

        RadioButton lightThemeButton = findViewById(R.id.rbtnStandardTheme);
        RadioButton nightThemeButton = findViewById(R.id.rbtnDarkTheme);

        lightThemeButton.setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("themeIdentifier", 0);
            editor.apply();
            recreate();
        });

        nightThemeButton.setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("themeIdentifier", 1);
            editor.apply();
            recreate();
        });
    }
}