package chvirov.com.example.work11;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

// Переделайте все кнопки на материал.
// Все размеры и строки сделайте ресурсами.
// Создайте стиль для своего приложения.
// * Создайте светлую и тёмную тему для приложения.

public class MainActivity extends AppCompatActivity implements Constants {

    private TextView textViewResult;
    private TextView textViewExpression;
    private String overallText = "";
    private String textForValues = "";
    protected double calculationResult;
    private char action = ' ';
    protected boolean isDotLast = false;
    protected boolean isActionLast = false;
    protected boolean isResultLast = false;

    protected double valueBuffer = 0;
    private String textBuffer = "";
    protected double value1;
    protected double value2;
    protected int themeIdentifier;


    private final String digit1 = "1";
    private final String digit2 = "2";
    private final String digit3 = "3";
    private final String digit4 = "4";
    private final String digit5 = "5";
    private final String digit6 = "6";
    private final String digit7 = "7";
    private final String digit8 = "8";
    private final String digit9 = "9";
    private final String digit0 = "0";

    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setActivityTheme();
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        textViewExpression = findViewById(R.id.textViewExpression);
        Button buttonResult = findViewById(R.id.buttonResult);
        Button btnSettings = findViewById(R.id.buttonSettings);

        // переход в Настройки
        btnSettings.setOnClickListener(v -> {
            Intent runSettings = new Intent(MainActivity.this, Settings.class);
            startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
        });

        // Обработка нажатия на кнопку РАВНО
        buttonResult.setOnClickListener(v -> {

            if (isResultLast || isActionLast || isDotLast) {
                //Do nothing
            } else {

                valueBuffer = Float.parseFloat(textForValues);
                value2 = valueBuffer;

                if (action == '+') {

                    calculationResult = value1 + value2;
                    updateViewsOnResult();

                } else if (action == '-') {

                    calculationResult = value1 - value2;
                    updateViewsOnResult();

                } else if (action == '*') {

                    calculationResult = value1 * value2;
                    updateViewsOnResult();

                } else if (action == '/') {

                    calculationResult = value1 / value2;
                    updateViewsOnResult();


                } else if (action == '°') {

                    calculationResult = value2 * 100 / value1;
                    updateViewsOnResult();

                }
            }

            textForValues = String.valueOf(calculationResult);
            value2 = 0;

        });


        //связывание кнопок с макета с их экземплярами
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);


        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonPercent = findViewById(R.id.buttonPercent);
        Button buttonFloatingDot = findViewById(R.id.buttonPt);

        Button buttonClear = findViewById(R.id.buttonClear);


        // Обработка нажатия на цифровые кнопки
        button0.setOnClickListener(v -> {
            digitAssign(digit0);
        });

        button1.setOnClickListener(v -> {
            digitAssign(digit1);
        });

        button2.setOnClickListener(v -> {
            digitAssign(digit2);
        });

        button3.setOnClickListener(v -> {
            digitAssign(digit3);
        });

        button4.setOnClickListener(v -> {
            digitAssign(digit4);
        });

        button5.setOnClickListener(v -> {
            digitAssign(digit5);
        });

        button6.setOnClickListener(v -> {
            digitAssign(digit6);
        });

        button7.setOnClickListener(v -> {
            digitAssign(digit7);
        });

        button8.setOnClickListener(v -> {
            digitAssign(digit8);
        });

        button9.setOnClickListener(v -> {
            digitAssign(digit9);
        });


        // Обработка нажатия на кнопки операций
        buttonPlus.setOnClickListener(v -> {

            buttonOperation('+', "+");
        });

        buttonMinus.setOnClickListener(v -> {
            buttonOperation('-', "-");
        });

        buttonMultiply.setOnClickListener(v -> {
            buttonOperation('*', "*");
        });

        buttonDivide.setOnClickListener(v -> {
            buttonOperation('/', "/");
        });

        buttonPercent.setOnClickListener(v -> {
            buttonOperation('°', "°");
        });

        buttonClear.setOnClickListener(v -> {
            clearAll();
        });

        buttonFloatingDot.setOnClickListener(v -> {

            if (isResultLast || isActionLast) {
                //Do nothing
            } else {
                overallText = overallText + ".";
                textViewExpression.setText(String.format(Locale.getDefault(), overallText));
                textBuffer = textBuffer + ".";
                isDotLast = true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(data + " Result");
        System.out.println(resultCode + " Result");
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_CANCELED) {
        }
    }

    private void setActivityTheme() {
        if (themeIdentifier == 0) {
            setTheme(R.style.AppTheme);
        } else if (themeIdentifier == 1) {
            setTheme(R.style.NightTheme);
        }
    }


    private void updateViewsOnResult() {

        if (isDotLast) {
            //Do nothing
        } else {
            overallText = String.valueOf(calculationResult);

            if (calculationResult % 1 == 0) {
                String[] arrDivider = overallText.split("\\.");
                overallText = arrDivider[0];
                textViewExpression.setText(String.format(Locale.getDefault(), arrDivider[0]));
                textViewResult.setText(String.format(Locale.getDefault(), arrDivider[0]));
            } else {
                textViewExpression.setText(String.format(Locale.getDefault(), overallText));
                textViewResult.setText(String.format(Locale.getDefault(), overallText));
            }
            textForValues = String.valueOf(calculationResult);
            isDotLast = false;
            isResultLast = true;
        }
    }

    // Добавление значения нажатой цифровой кнопки
    private void digitAssign(String digit) {

        if (isResultLast) {
            //Do nothing
        } else {

            if (overallText.equals("0") || textForValues.equals("0.0")) {
                overallText = "";
                textViewExpression.setText(overallText);
            }

            textBuffer = textBuffer + digit;
            textForValues = textBuffer;
            overallText = overallText + digit;
            textViewExpression.setText(String.format(Locale.getDefault(), overallText));
            isDotLast = false;
            isActionLast = false;
        }
    }


    // Добавление значения нажатой кнопки операции
    private void buttonOperation(char actionVarChar, String actionTextView) {

        if (isDotLast || isActionLast) {
            //Do nothing
        } else {

            textViewExpression.setText(String.format(Locale.getDefault(), ""));
            action = actionVarChar;
            valueBuffer = Float.parseFloat(textForValues);
            value1 = valueBuffer;
            overallText = overallText + actionTextView;
            textViewExpression.setText(String.format(Locale.getDefault(), overallText));
            textBuffer = "";
            textForValues = "";
            isActionLast = true;
            isResultLast = false;
        }
    }

    private void clearAll() {
        overallText = "";
        textViewResult.setText("");
        textViewExpression.setText("");
        value1 = 0;
        value2 = 0;
        textBuffer = "";
        textForValues = "";
        isActionLast = false;
        isResultLast = false;
        isDotLast = false;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);

        instanceState.putDouble("calculationResult", calculationResult);
        instanceState.putString("textViewExpression", (textViewExpression.getText()).toString());
        instanceState.putString("textViewResult", (textViewResult.getText()).toString());
        instanceState.putBoolean("isActionLast", isActionLast);
        instanceState.putBoolean("isResultLast", isResultLast);
        instanceState.putBoolean("isDotLast", isDotLast);
        instanceState.putChar("action", action);
        instanceState.putString("textForValues", textForValues);
        instanceState.putString("textBuffer", textBuffer);
        instanceState.putString("overallText", overallText);
        instanceState.getDouble("valueBuffer", valueBuffer);
        instanceState.getDouble("value1", value1);
        instanceState.getDouble("value2", value2);

    }

    @Override
    protected void onRestoreInstanceState(Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);

        calculationResult = instanceState.getDouble("calculationResult");
        textViewExpression.setText(String.format(Locale.getDefault(), instanceState.getString("textViewExpression")));
        textViewResult.setText(String.format(Locale.getDefault(), instanceState.getString("textViewResult")));
        isActionLast = instanceState.getBoolean("isActionLast");
        isResultLast = instanceState.getBoolean("isResultLast");
        isDotLast = instanceState.getBoolean("isDotLast");
        textForValues = instanceState.getString("textForValues");
        textBuffer = instanceState.getString("textBuffer");
        overallText = instanceState.getString("overallText");
        valueBuffer = instanceState.getDouble("valueBuffer");
        value1 = instanceState.getDouble("value1");
        value2 = instanceState.getDouble("value2");


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
