package com.zhuyue.bwie.com.zhuyue20181112;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout Framelayout;
    private TextView xtv;
    private TextView ltv;
    private DrawerLayout Drawer_Layout;
    private AFragment aFragment;
    private com.zhuyue.dell.monilianxi.BFragment bFragment;
    private FragmentManager manager;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();


    }

    private void initData() {
        aFragment = new AFragment();
        bFragment = new com.zhuyue.dell.monilianxi.BFragment();
    }


    private void initView() {
        Framelayout = (FrameLayout) findViewById(R.id.Framelayout);
        xtv = (TextView) findViewById(R.id.xtv);
        xtv.setOnClickListener(this);
        ltv = (TextView) findViewById(R.id.ltv);
        ltv.setOnClickListener(this);
        Drawer_Layout = (DrawerLayout) findViewById(R.id.Drawer_Layout);
        manager=getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xtv:
                manager.beginTransaction().replace(R.id.Framelayout,aFragment).commit();
                Drawer_Layout.closeDrawers();
                break;
            case R.id.ltv:
                manager.beginTransaction().replace(R.id.Framelayout,bFragment).commit();
                Drawer_Layout.closeDrawers();
                break;
        }
    }
}