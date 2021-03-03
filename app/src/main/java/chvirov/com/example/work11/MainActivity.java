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
    protected int valueOfFirstNumber;
    private char action = ' ';
    protected boolean isAction = false;
    protected int calculationResult;
    protected boolean isActionPressed;


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
        isActionPressed = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);
        textViewExpression = findViewById(R.id.textViewExpression);
        Button buttonResult = findViewById(R.id.buttonResult);


        buttonResult.setOnClickListener(v -> {

            isAction = false;

            if (action == '+') {
                String[] values = overallText.split("\\+");
                calculationResult = Integer.parseInt(values[0]) + Integer.parseInt(values[1]);
                String calculationResultStr = Integer.toString(calculationResult);
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
                calculationResult = Integer.parseInt(values[0]) - Integer.parseInt(values[1]);
                String calculationResultStr = Integer.toString(calculationResult);
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
                calculationResult = Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
                String calculationResultStr = Integer.toString(calculationResult);
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
                calculationResult = Integer.parseInt(values[0]) / Integer.parseInt(values[1]);
                String calculationResultStr = Integer.toString(calculationResult);
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
                calculationResult = Integer.parseInt(values[1]) * 100 / Integer.parseInt(values[0]);
                String calculationResultStr = Integer.toString(calculationResult);
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

    private void digitAssign(String digit) {
        if (overallText.equals("0")) {
            overallText = "";
            textViewExpression.setText(overallText);
        }
        textViewExpression.setText(String.format(Locale.getDefault(), overallText + digit));
        overallText = textViewExpression.getText().toString();
    }

    private void buttonOperation(char actionVarChar, String actionTextView) {


//        if (calculationResult < 0) {
//            overallText = textViewResult.getText().subSequence(1, overallText.length()).toString();
//            int subZeroCorrection = Integer.parseInt(overallText);
//            overallText = Integer.toString(subZeroCorrection - (subZeroCorrection * 2));
//        }


            valueOfFirstNumber = Integer.parseInt(overallText);
            textViewExpression.setText(String.format(Locale.getDefault(), overallText + actionTextView));
            action = actionVarChar;
            overallText = textViewExpression.getText().toString();
    }


//        if (calculationResult < 0) {
//            overallText = textViewResult.getText().subSequence(1, overallText.length() - 1).toString();
//            int subZeroCorrection = Integer.parseInt(overallText);
//            overallText = Integer.toString(subZeroCorrection - (subZeroCorrection * 2));
//        }







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
