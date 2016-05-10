package com.example.a02fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Hsia";
    @butterknife.Bind(R.id.ll_replace)
    LinearLayout llReplace;
    @butterknife.Bind(R.id.btn_wechat)
    Button btnWechat;
    @butterknife.Bind(R.id.btn_contact)
    Button btnContact;
    @butterknife.Bind(R.id.btn_friend)
    Button btnFriend;
    @butterknife.Bind(R.id.btn_information)
    Button btnInformation;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        btnWechat.setOnClickListener(this);
        btnContact.setOnClickListener(this);
        btnFriend.setOnClickListener(this);
        btnInformation.setOnClickListener(this);
        fm = getFragmentManager();
        //默认是微信页面
        fm.beginTransaction().replace(R.id.ll_replace,new WeChatFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        //在onClick里面需要重新获取事务
        FragmentTransaction ft =  fm.beginTransaction();
            switch (v.getId()) {
                case R.id.btn_wechat:
                    ft.replace(R.id.ll_replace,new WeChatFragment());
                    break;
                case R.id.btn_contact:
                    ft.replace(R.id.ll_replace,new ContactFragment());
                    break;
                case R.id.btn_friend:
                    ft.replace(R.id.ll_replace,new FriendFragment());
                    break;
                case R.id.btn_information:
                    ft.replace(R.id.ll_replace,new InformationFragment());
                    break;
            }
        ft.commit();
    }
}
