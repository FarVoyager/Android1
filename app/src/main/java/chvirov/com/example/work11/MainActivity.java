package chvirov.com.example.work11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Integer arg1;
    private Integer arg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Button button = findViewById(R.id.button);
//        final EditText editText1 = findViewById(R.id.editText1);
//        final EditText editText2 = findViewById(R.id.editText2);
//        final TextView textView = findViewById(R.id.textView1);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    arg1 = Integer.valueOf(editText1.getText().toString());
//                    arg2 = Integer.valueOf(editText2.getText().toString());
//                    if (arg1.equals(arg2)) {
//                        textView.setText("Равно!");
//                    } else {
//                        textView.setText("Не равно!");
//                    }
//                } catch (NumberFormatException e) {
//                    textView.setText("Нужно ввести число!");
//                }
//
//            }
//        });
    }
}
