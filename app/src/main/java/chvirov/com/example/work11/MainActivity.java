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

    private TextView textViewResult;
    private TextView textViewExpression;
    private String overallText = "";
    private final String digit1 = "1";
    private int value1;
    private int value2;
    private char action = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);
        textViewExpression = findViewById(R.id.textViewExpression);

        //связывание кнопок с макета с их экземплярами
        Button button1 = findViewById(R.id.button1);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonResult = findViewById(R.id.buttonResult);


        button1.setOnClickListener(v -> {

            //установить текст на TextView
            textViewExpression.setText(String.format(Locale.getDefault(), overallText + digit1));
            overallText = textViewExpression.getText().toString();
        });

        buttonPlus.setOnClickListener(v -> {
            value1 = Integer.parseInt(overallText);
            textViewExpression.setText(String.format(Locale.getDefault(), overallText + " + "));
            action = '+';
            overallText = textViewExpression.getText().toString();
            //установить текст на TextView
        });

        buttonResult.setOnClickListener(v -> {
            if (action == '+') {
                String[] values = overallText.split("\\+");
                textViewResult.setText(String.format(Locale.getDefault(), Integer.toString(Integer.parseInt(values[0]) + Integer.parseInt(values[1]))));
            }


            //установить текст на TextView
        });
    }


//    // Установить текст на TextView
//    private void setTextCounter(TextView textCounter, int counter){
//        textCounter.setText(String.format(Locale.getDefault(), "%d", counter));
//    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
