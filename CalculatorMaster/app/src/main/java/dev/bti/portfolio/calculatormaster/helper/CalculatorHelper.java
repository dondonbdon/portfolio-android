package dev.bti.portfolio.calculatormaster.helper;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import java.util.Set;

public class CalculatorHelper {

    static CalculatorHelper calculatorHelper;

    public CalculatorHelper() {
    }

    public static CalculatorHelper GetInstance() {
        if (calculatorHelper != null) {
            calculatorHelper = new CalculatorHelper();
        }

        return calculatorHelper;
    }

    public StringBuilder getFormattedString(String s) {


        StringBuilder formattedStringBuilder = new StringBuilder();
        Set<Character> operations = Set.of('+', '−', '×', '÷', '=', '%', '±');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (operations.contains(c)) {
                formattedStringBuilder.append(s, i, i + 1);
                SpannableString spannableString = new SpannableString(s);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#004E7E")),
                        formattedStringBuilder.length() - 1, formattedStringBuilder.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                formattedStringBuilder.append(spannableString);
            } else {
                formattedStringBuilder.append(c);
            }
        }

        return formattedStringBuilder;
    }

}
