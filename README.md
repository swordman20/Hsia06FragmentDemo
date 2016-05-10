#06Android学习从零单排之Fragment
**这是Android基础学习的最后一个部分，该部分学习完成后，将不在更新“Android学习从零单排”系列blog，在这个部分学习完成后，我也将开始学习Android项目编写。**
##Fragment入门（不常用）
- 在layout文件中添加2个fragment布局

```
<fragment
        android:name="com.example.xwf.hsia06fragmentdemo.LeftFragment"
        android:id="@+id/left"		//必须加ID，不然就报错
        android:layout_width="0dp"
        android:layout_weight="1"
        android:layout_height="match_parent"/>
    <fragment
        android:name="com.example.xwf.hsia06fragmentdemo.RightFragment"
        android:id="@+id/right"
        android:layout_width="0dp"
        android:layout_weight="1"
        android:layout_height="match_parent"/>
```
- 再编写2个layout种指定的2个Fragment类文件。

```
public class LeftFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, null);
        return view;
    }
}
```

##Fragment动态添加
- 编写2个Fragment文件。
- 在Activity中通过getFragmentManager获得FragmentTransaction事务。
- 通过FragmentTransaction替换Fragment布局
- 提交事务。
![image](/Users/xwf/Desktop/f1.gif)

```

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
```

##Fragment模仿微信页面
![image](/Users/xwf/Desktop/f2.gif)

>需要注意的是在onClick中需要重新获得事务。

```
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

```

##Fragment间通信
![image](/Users/xwf/Desktop/f3.gif)
> 主要通过getFragmentManager().findFragmentByTag("LeftFragment")来获取到另一个Fragment对象，并调用里面的方法。


```
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
```
##Android动画集合

![image](/Users/xwf/Desktop/f4.gif)
- 在res下新建一个anim文件夹，将一些动画文件放在该文件下。
- 在Activity中通过AnimationUtils来加载各种动画资源文件。


```
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
```
##AutoCompleteTextView控件的学习使用
>该控件主要是模糊提示，根据你的首字母，它会自动提示你可能需要输入的内容。根据开发文档cop一份就行了

![image](/Users/xwf/Desktop/f4.gif)

```
private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView ACTV = (AutoCompleteTextView) findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        ACTV.setAdapter(adapter);
    }
```
**关于作者**
	- 个人网站：[北京互联科技](http://shop.zbj.com/14622657/)
	- Email：[xiaweifeng@live.cn](https://login.live.com)
	- 项目地址:[https://github.com/swordman20/Hsia06FragmentDemo.git](https://github.com/swordman20/Hsia06FragmentDemo.git)
