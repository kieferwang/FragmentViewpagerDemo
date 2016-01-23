package com.krisitine.fragmentviewpagerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Button one;
    private Button two;
    private Button three;
    private Button four;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化ViewPager
        InitViewPager();
        //初始化布局
        InitView();


    }

    private void InitViewPager() {
        viewPager = (ViewPager) findViewById(R.id.pager);

        //创建一个FragPagerAdapter对象，该对象为ViewPager提供多个Fragment
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                Fragment fragment = null;
                switch (i) {
                    case 0:
                        fragment = new OneFragement();
                        break;
                    case 1:
                        fragment = new TwoFragment();
                        break;
                    case 2:
                        fragment = new ThreeFragment();
                        break;
                    case 3:
                        fragment = new FourFragment();
                        break;

                }
                return fragment;
            }

            //该方法的返回值i表明该Adapter总共有多少个Fragmen
            @Override
            public int getCount() {
                return 4;
            }
        };

        //为ViewPager组件设置FragmentPagerAdapter
        viewPager.setAdapter(fragmentPagerAdapter);


        //为viewPager组件绑定监听器
       viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
           @Override
           public void onPageSelected(int position) {
               switch (position) {
                   case 0:
                       one.setTextColor(Color.BLUE);
                       two.setTextColor(Color.BLACK);
                       three.setTextColor(Color.BLACK);
                       four.setTextColor(Color.BLACK);
                       break;

                   case 1:
                       one.setTextColor(Color.BLACK);
                       two.setTextColor(Color.BLUE);
                       three.setTextColor(Color.BLACK);
                       four.setTextColor(Color.BLACK);
                       break;
                   case 2:
                       one.setTextColor(Color.BLACK);
                       two.setTextColor(Color.BLACK);
                       three.setTextColor(Color.BLUE);
                       four.setTextColor(Color.BLACK);
                       break;
                   case 3:
                       one.setTextColor(Color.BLACK);
                       two.setTextColor(Color.BLACK);
                       three.setTextColor(Color.BLACK);
                       four.setTextColor(Color.BLUE);
                       break;
               }
               super.onPageSelected(position);
           }
       });
    }

    private void InitView(){
        one = (Button) findViewById(R.id.btn_one);
        two = (Button) findViewById(R.id.btn_two);
        three = (Button) findViewById(R.id.btn_three);
        four = (Button) findViewById(R.id.btn_four);

        //设置点击监听
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        //将button中字体的颜色先按照点击第一个button的效果初始化
        one.setTextColor(Color.BLUE);
        two.setTextColor(Color.BLACK);
        three.setTextColor(Color.BLACK);
        four.setTextColor(Color.BLACK);
    }

    //点击主界面上面的button后，将viewpager中的fragment跳转到对应的item
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_two:
                viewPager.setCurrentItem(1);
                break;
            case R.id.btn_three:
                viewPager.setCurrentItem(2);
                break;
            case R.id.btn_four:
                viewPager.setCurrentItem(3);
                break;
        }
    }


}
