package chvirov.com.example.work11;

//  Создайте активити с настройками, где включите выбор темы приложения.
//  Доделайте приложение «Калькулятор». Это последний урок с созданием приложения «Калькулятор».
//  * Сделайте интент-фильтр для запуска калькулятора извне, а также напишите тестовое приложение, запускающее приложение-калькулятор.


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class Settings extends AppCompatActivity implements Constants {


    private static final String NameSharedPreference = "LOGIN";
    private static final String appTheme = "APP_THEME";

    private static final int AppThemeCode = 0;
    private static final int DarkThemeCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppTheme));
        setContentView(R.layout.activity_settings);

        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });

        initThemeChooser();
    }

    // Инициализация радиокнопок
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.rbtnStandardTheme),
                AppThemeCode);
        initRadioButton(findViewById(R.id.rbtnDarkTheme),
                DarkThemeCode);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(AppThemeCode))).setChecked(true);
    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {

            setAppTheme(codeStyle);


            //попытка передачи данных в ActivityMain
            Intent intentResultTheme = new Intent();
            intentResultTheme.putExtra(keyToMainActivityTheme, codeStyle);
            setResult(Activity.RESULT_OK, intentResultTheme);
            System.out.println(intentResultTheme.getExtras() + " TRANSFERRED");
            // пересоздадим активити, чтобы тема применилась
            recreate();
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }


    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeCode:
                return R.style.AppTheme;
            case DarkThemeCode:
                return R.style.NightTheme;
            default:
                return R.style.AppTheme;
        }
    }

}