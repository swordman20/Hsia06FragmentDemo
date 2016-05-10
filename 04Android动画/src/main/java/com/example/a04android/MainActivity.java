package com.example.a04android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @butterknife.Bind(R.id.btn1)
    Button btn1;
    @butterknife.Bind(R.id.btn2)
    Button btn2;
    @butterknife.Bind(R.id.btn3)
    Button btn3;
    @butterknife.Bind(R.id.btn4)
    Button btn4;
    @butterknife.Bind(R.id.btn_set)
    Button btnSet;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        iv = (ImageView) findViewById(R.id.iv);
    }

    @butterknife.OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn_set})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                iv.startAnimation(a1);
                break;
            case R.id.btn2:
                Animation a2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv.startAnimation(a2);
                break;
            case R.id.btn3:
                Animation a3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                iv.startAnimation(a3);
                break;
            case R.id.btn4:
                Animation a4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                iv.startAnimation(a4);
                break;
            case R.id.btn_set:
                Animation set = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
                iv.startAnimation(set);
                break;
        }
    }
}
