package dev.bti.portfolio.calculatormaster;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;

import dev.bti.portfolio.calculatormaster.common.Constants;
import dev.bti.portfolio.calculatormaster.helper.CalculatorHelper;

public class MainActivity extends AppCompatActivity {

    TextView equationBar, answerBar;
    TextView clearEquation, plusMinusSymbol, percentSymbol, reset, dot;
    TextView divideSymbol, addSymbol, minusSymbol, multiplySymbol, equalSymbol;
    TextView one, two, three, four, five, six, seven, eight, nine, zero;

    CalculatorHelper calculatorHelper = Constants.calculatorHelper;

    private final StringBuilder currentEquation = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        initUi();
        initClicks();
        initHelper();
        initTouches();
        initHelper();
        initListener();
    }

    private void initUi() {
        equationBar = findViewById(R.id.equationBar);
        answerBar = findViewById(R.id.answerBar);
        clearEquation = findViewById(R.id.clearEquation);
        plusMinusSymbol = findViewById(R.id.plusMinusSymbol);
        percentSymbol = findViewById(R.id.percentSymbol);
        divideSymbol = findViewById(R.id.divideSymbol);
        addSymbol = findViewById(R.id.addSymbol);
        minusSymbol = findViewById(R.id.minusSymbol);
        multiplySymbol = findViewById(R.id.multiplySymbol);
        equalSymbol = findViewById(R.id.equalSymbol);
        reset = findViewById(R.id.reset);
        dot = findViewById(R.id.dot);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
    }

    private void initClicks() {
        clearEquation.setOnClickListener(view -> {
            currentEquation.setLength(0);
            updateEquation();
        });

        plusMinusSymbol.setOnClickListener(view -> {
            updateEquation();
        });

        percentSymbol.setOnClickListener(view -> {

            updateEquation();
        });

        divideSymbol.setOnClickListener(view -> appendSymbol("÷"));
        addSymbol.setOnClickListener(view -> appendSymbol("+"));
        minusSymbol.setOnClickListener(view -> appendSymbol("-"));
        multiplySymbol.setOnClickListener(view -> appendSymbol("×"));
        equalSymbol.setOnClickListener(view -> evaluateEquation());
        reset.setOnClickListener(view -> resetCalculator());
        dot.setOnClickListener(view -> appendSymbol("."));
        one.setOnClickListener(view -> appendNumber("1"));
        two.setOnClickListener(view -> appendNumber("2"));
        three.setOnClickListener(view -> appendNumber("3"));
        four.setOnClickListener(view -> appendNumber("4"));
        five.setOnClickListener(view -> appendNumber("5"));
        six.setOnClickListener(view -> appendNumber("6"));
        seven.setOnClickListener(view -> appendNumber("7"));
        eight.setOnClickListener(view -> appendNumber("8"));
        nine.setOnClickListener(view -> appendNumber("9"));
        zero.setOnClickListener(view -> appendNumber("0"));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initTouches() {
        View.OnTouchListener onTouchListener = (view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN ->
                        view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey10));
                case MotionEvent.ACTION_UP ->
                        view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.transparent));
            }
            return false;
        };

        clearEquation.setOnTouchListener(onTouchListener);
        plusMinusSymbol.setOnTouchListener(onTouchListener);
        percentSymbol.setOnTouchListener(onTouchListener);
        divideSymbol.setOnTouchListener(onTouchListener);
        addSymbol.setOnTouchListener(onTouchListener);
        minusSymbol.setOnTouchListener(onTouchListener);
        multiplySymbol.setOnTouchListener(onTouchListener);
        equalSymbol.setOnTouchListener(onTouchListener);
        reset.setOnTouchListener(onTouchListener);
        dot.setOnTouchListener(onTouchListener);
        one.setOnTouchListener(onTouchListener);
        two.setOnTouchListener(onTouchListener);
        three.setOnTouchListener(onTouchListener);
        four.setOnTouchListener(onTouchListener);
        five.setOnTouchListener(onTouchListener);
        six.setOnTouchListener(onTouchListener);
        seven.setOnTouchListener(onTouchListener);
        eight.setOnTouchListener(onTouchListener);
        nine.setOnTouchListener(onTouchListener);
        zero.setOnTouchListener(onTouchListener);
    }

    private void initHelper() {

    }

    private void initListener() {

    }

    private void updateEquation() {
        equationBar.setText(currentEquation.toString());
    }

    private void appendSymbol(String symbol) {
        currentEquation.append(symbol);
        updateEquation();
    }

    private void appendNumber(String number) {

        currentEquation.append(number);
        updateEquation();
    }

    private void evaluateEquation() {
        equationBar.setText(String.format(Locale.getDefault(),
                "%,d", Long.parseLong(equationBar.getText().toString())));
    }

    private void resetCalculator() {
        currentEquation.setLength(0);
        updateEquation();
        answerBar.setText("");
    }
}