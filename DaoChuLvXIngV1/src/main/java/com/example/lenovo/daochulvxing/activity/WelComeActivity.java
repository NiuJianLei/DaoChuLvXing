package com.example.lenovo.daochulvxing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.daochulvxing.R;
import com.example.lenovo.daochulvxing.adapter.WeComeVpAdapter;
import com.example.lenovo.daochulvxing.util.PreviewIndicator;
import com.example.lenovo.daochulvxing.util.SpUtil;

import java.util.ArrayList;

public class WelComeActivity extends AppCompatActivity {

    private ViewPager mWecomeVp;
    private ArrayList<View> viewlist;
    private WeComeVpAdapter adapter;
    private PreviewIndicator mWecomePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        initView();
    }

    private void initView() {


        mWecomeVp = (ViewPager) findViewById(R.id.wecome_vp);
        mWecomePreview = (PreviewIndicator) findViewById(R.id.wecome_preview);
        viewlist = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.wecome_vp1, null);
        View view2 = View.inflate(this, R.layout.wecome_vp2, null);
        View view3 = View.inflate(this, R.layout.wecome_vp3, null);

        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);
        adapter = new WeComeVpAdapter(viewlist);
        Button butt = view3.findViewById(R.id.wecome_button);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtil.setParam("isselected", true);
                Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mWecomeVp.setAdapter(adapter);
        mWecomeVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    mWecomePreview.setVisibility(View.GONE);
                }else{
                    mWecomePreview.setSelected(position);
                    mWecomePreview.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });





    }
}
