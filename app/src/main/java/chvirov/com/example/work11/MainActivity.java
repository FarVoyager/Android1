package chvirov.com.example.work11;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int counter1 = 0;       // первый счетчик
    private int counter2 = 0;       // второй счетчик
    private TextView textCounter1;  // пользовательский элемент 1-го счетчика
    private TextView textCounter2;  // пользовательский элемент 2-го счетчика
    private final static String TAG = "[LifeCycleActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_1_3);

        //Логирование
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        makeToast(instanceState + " - onCreate()");

        initView();
    }

    // Получить пользовательский элемент по идентификатору
    private void initView() {
        textCounter1 = findViewById(R.id.textViewResult);
        textCounter2 = findViewById(R.id.textView2);
        initButton2ClickListener();
    }


    private void initButton2ClickListener() {
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            counter2++;
            setTextCounter(textCounter2, counter2);
        });
    }


    // Обработка кнопки через атрибут onClick в макете
    public void buttonCounter1_onClick(View view) {
        counter1++;
        setTextCounter(textCounter1, counter1);
    }

    // Установить текст на TextView
    private void setTextCounter(TextView textCounter, int counter){
        textCounter.setText(String.format(Locale.getDefault(), "%d", counter));
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        makeToast("Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        makeToast("onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy()");
    }


    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }

}
