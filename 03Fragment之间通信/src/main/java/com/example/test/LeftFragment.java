package com.example.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xwf on 16/5/10.
 */
public class LeftFragment extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_left, null);
        tv = (TextView) layout.findViewById(R.id.tv);
        return layout;
    }

    public void setText(String context){
        tv.setText(context);
    }
}
