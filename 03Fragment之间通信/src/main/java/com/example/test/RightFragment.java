package com.example.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by xwf on 16/5/10.
 */
public class RightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_right, null);
        Button btn = (Button) layout.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeftFragment lf = (LeftFragment) getFragmentManager().findFragmentByTag("LeftFragment");
                lf.setText("数据已更改！");
            }
        });
        return layout;
    }
}
