package com.ntt.customgaugeview;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ntt.customgaugeview.library.GaugeView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GaugeView gaugeView = (GaugeView) findViewById(R.id.gauge_view);
        final Button btnStart = (Button) findViewById(R.id.btn_start);
        gaugeView.setShowRangeValues(true);
        gaugeView.setTargetValue(0);
        final Random random = new Random();
        final CountDownTimer timer = new CountDownTimer(10000, 2) {
            @Override
            public void onTick(long millisUntilFinished) {
                gaugeView.setTargetValue(random.nextInt(5000));
            }

            @Override
            public void onFinish() {
                gaugeView.setTargetValue(0);
            }
        };
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
            }
        });
    }
}
