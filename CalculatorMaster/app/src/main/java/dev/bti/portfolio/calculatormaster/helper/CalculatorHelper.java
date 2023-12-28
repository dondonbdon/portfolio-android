package dev.bti.portfolio.calculatormaster.helper;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CalculatorHelper {

    static CalculatorHelper calculatorHelper;

    public CalculatorHelper() {
    }



    public String formatString(String s) {
        StringBuilder formattedString = new StringBuilder(s);
        int numCommas = (formattedString.length() - 1) / 3;
        int count = 3;


        for (int i = 0; i < numCommas; i++) {
            formattedString.insert(formattedString.length() - count, '\'');
            count += 4;
        }

        return formattedString.toString();
    }

}
