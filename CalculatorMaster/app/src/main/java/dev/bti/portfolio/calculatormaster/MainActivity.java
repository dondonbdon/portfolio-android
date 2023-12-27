package dev.bti.portfolio.calculatormaster;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import dev.bti.portfolio.calculatormaster.helper.CalculatorHelper;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textView);
        CalculatorHelper calculatorHelper = new CalculatorHelper();
        textView.setText(calculatorHelper.getFormattedString(textView.getText().toString()));
    }
}