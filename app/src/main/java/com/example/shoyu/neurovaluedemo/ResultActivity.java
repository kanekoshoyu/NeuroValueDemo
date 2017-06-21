package com.example.shoyu.neurovaluedemo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView TV= (TextView)findViewById(R.id.text_hyper_link);
        TV.setMovementMethod(new ScrollingMovementMethod());

        new CountDownTimer(7000, 1000) { // 5000 = 5 sec
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                LinearLayout LL3 = (LinearLayout) findViewById(R.id.LL3);
                LL3.setVisibility(View.GONE);
                String LA = getIntent().getExtras().getString("LA");
                if (LA.equals("150000")){
                    LinearLayout LL4 = (LinearLayout) findViewById(R.id.LL4);
                    LL4.setVisibility(View.VISIBLE);
                }else{
                    LinearLayout LL5 = (LinearLayout) findViewById(R.id.LL5);
                    LL5.setVisibility(View.VISIBLE);
                }
            }
        }.start();
    }

    public void transactionActivity(View view) {
        Intent intent = new Intent(this, TransactionActivity.class);
        startActivity(intent);
    }
}
