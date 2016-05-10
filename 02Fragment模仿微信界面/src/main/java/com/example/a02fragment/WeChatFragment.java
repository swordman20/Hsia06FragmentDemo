package com.example.a02fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by xwf on 16/5/10.
 */
public class WeChatFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.f, null);
        textView = new TextView(getActivity());
        textView.setText("我是微信页面");
        textView.setTextSize(30);
        layout.addView(textView);
        return layout;
    }
}
