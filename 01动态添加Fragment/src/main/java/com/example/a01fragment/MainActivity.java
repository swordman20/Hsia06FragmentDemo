package com.example.a01fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态加载Fragment，通过屏幕的横竖屏来动态加载
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int x = point.x;
        int y = point.y;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (x<y) {
            fragmentTransaction.replace(android.R.id.content,new VerticalFragment());
        }else{
            fragmentTransaction.replace(android.R.id.content,new HorizontalFragment());
        }
        //提交事务
        fragmentTransaction.commit();
    }
}
