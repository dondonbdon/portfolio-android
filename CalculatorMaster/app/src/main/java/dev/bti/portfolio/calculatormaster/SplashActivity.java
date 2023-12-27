package dev.bti.portfolio.calculatormaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        onRun();
    }

    private void onRun() {
         /*
         boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

       if (isFirstRun) {
            startActivity(new Intent(this, OnBoardingActivity.class)
                    .setAction("Transition to on boarding"));
        } else if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class)
                    .setAction("Transition to on get started"));
        } else */ {
            startActivity(new Intent(this, MainActivity.class)
                    .setAction("Transition to app main"));
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
        finishAffinity();
        finish();
    }
}