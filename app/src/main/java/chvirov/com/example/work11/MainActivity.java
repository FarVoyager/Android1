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
    private String textForValues = "";

    private char action = ' ';
    protected boolean isAction = false;
    protected double calculationResult;
    protected boolean isActionPressed;

    protected double valueBuffer = 0;
    private String textBuffer = "";
    protected double value1;
    protected double value2;
    protected int isOperationPressed = 0;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        isActionPressed = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);
        textViewExpression = findViewById(R.id.textViewExpression);
        Button buttonResult = findViewById(R.id.buttonResult);


        // Обработка нажатия на кнопку РАВНО
        buttonResult.setOnClickListener(v -> {

            value2 = valueBuffer;

            if (action == '+') {
                String[] values = overallText.split("\\+");
                calculationResult = value1 + value2;

                String calculationResultStr = Double.toString(calculationResult);

//                if (calculationResult % 1 == 0) {
//                    String[] FloatToIntArr = calculationResultStr.split(".");
//                    String FloatToIntText = FloatToIntArr[0];
//                    textViewResult.setText(String.format(Locale.getDefault(), FloatToIntText));
//                } else {
                    textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
//                }

                textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
                textViewExpression.setText(textViewResult.getText());
                overallText = textViewResult.getText().toString();
                if (calculationResult < 0) {
                    overallText = textViewResult.getText().subSequence(1, overallText.length() - 1).toString();
                } else {
                    overallText = textViewResult.getText().toString();
                }

            } else if (action == '-') {

                String[] values = overallText.split("-");
                calculationResult = value1 - value2;
                String calculationResultStr = Double.toString(calculationResult);

//                if (calculationResult % 1 != 0) {
//                    String[] FloatToIntArr = calculationResultStr.split(".");
//                    String FloatToIntText = FloatToIntArr[0];
//                    textViewResult.setText(String.format(Locale.getDefault(), FloatToIntText));
//                }

                textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
                textViewExpression.setText(textViewResult.getText());
                overallText = textViewResult.getText().toString();
                if (calculationResult < 0) {
                    overallText = textViewResult.getText().subSequence(1, overallText.length()).toString();
                } else {
                    overallText = textViewResult.getText().toString();
                }

            } else if (action == '*') {

                String[] values = overallText.split("\\*");
                calculationResult = value1 * value2;
                String calculationResultStr = Double.toString(calculationResult);

//                if (calculationResult % 1 != 0) {
//                    String[] FloatToIntArr = calculationResultStr.split(".");
//                    String FloatToIntText = FloatToIntArr[0];
//                    textViewResult.setText(String.format(Locale.getDefault(), FloatToIntText));
//                }

                textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
                textViewExpression.setText(textViewResult.getText());
                overallText = textViewResult.getText().toString();
                if (calculationResult < 0) {
                    overallText = textViewResult.getText().subSequence(1, overallText.length() - 1).toString();
                } else {
                    overallText = textViewResult.getText().toString();
                }

            } else if (action == '/') {

                String[] values = overallText.split("/");
                calculationResult = value1 / value2;
                String calculationResultStr = Double.toString(calculationResult);

//                if (calculationResult % 1 != 0) {
//                    String[] FloatToIntArr = calculationResultStr.split(".");
//                    String FloatToIntText = FloatToIntArr[0];
//                    textViewResult.setText(String.format(Locale.getDefault(), FloatToIntText));
//                }

                textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
                textViewExpression.setText(textViewResult.getText());
                overallText = textViewResult.getText().toString();
                if (calculationResult < 0) {
                    overallText = textViewResult.getText().subSequence(1, overallText.length() - 1).toString();
                } else {
                    overallText = textViewResult.getText().toString();
                }

            } else if (action == '°') {

                String[] values = overallText.split("°");
                calculationResult = value2 * 100 / value1;
                String calculationResultStr = Double.toString(calculationResult);

//                if (calculationResult % 1 != 0) {
//                    String[] FloatToIntArr = calculationResultStr.split(".");
//                    String FloatToIntText = FloatToIntArr[0];
//                    textViewResult.setText(String.format(Locale.getDefault(), FloatToIntText));
//                }

                textViewResult.setText(String.format(Locale.getDefault(), calculationResultStr));
                textViewExpression.setText(textViewResult.getText());
                if (calculationResult < 0) {
                    overallText = textViewResult.getText().subSequence(1, overallText.length() - 1).toString();
                } else {
                    overallText = textViewResult.getText().toString();
                }
            }

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

        Button buttonClear = findViewById(R.id.buttonClear);


        //Обработка нажатия на цифровые кнопки
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


        //обработка нажатия на кнопки операций
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
            overallText = "";
            textViewResult.setText("");
            textViewExpression.setText("");
        });


    }

    //добавление значения нажатой цифровой кнопки
    private void digitAssign(String digit) {
        if (overallText.equals("0") || textForValues.equals("0.0")) {
            overallText = "";
            textViewExpression.setText(overallText);

        }
        textBuffer = textBuffer + digit;
        textForValues = textBuffer;
        overallText = overallText + digit;
        textViewExpression.setText(String.format(Locale.getDefault(), overallText));
        overallText = textViewExpression.getText().toString();
        System.out.println(textForValues);
        valueBuffer = Float.parseFloat(textForValues);
    }


    //добавление значения нажатой кнопки операции
    private void buttonOperation(char actionVarChar, String actionTextView) {

        action = actionVarChar;
        value1 = valueBuffer;
        textForValues = "";
        textBuffer = "";
        overallText = overallText + actionTextView;
        textViewExpression.setText(String.format(Locale.getDefault(), overallText));
        isOperationPressed = 1;


    }


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
