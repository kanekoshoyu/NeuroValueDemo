package com.example.shoyu.neurovaluedemo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmationActivity extends AppCompatActivity {

    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        new CountDownTimer(10000, 1000) { // 5000 = 5 sec
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                final String LA= getIntent().getExtras().getString("LA");
                a=LA;
                TextView LAET = (TextView) findViewById(R.id.TV_LA);
                LAET.setText(LA);
                LinearLayout LL1 = (LinearLayout) findViewById(R.id.LL1);
                LL1.setVisibility(View.GONE);
                LinearLayout LL2 = (LinearLayout) findViewById(R.id.LL2);
                LL2.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void resultActivity(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("LA", a);
        startActivity(intent);
    }
}
