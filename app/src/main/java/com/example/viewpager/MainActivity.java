package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.viewpager.Fragments.PageFragment1;
import com.example.viewpager.Fragments.PageFragment2;
import com.example.viewpager.Fragments.PageFragment3;
import com.example.viewpager.Fragments.PageFragmentAll;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fragment> list=new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragmentAll());

        pager=findViewById(R.id.pager);
        pagerAdapter=new SliderPageAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);

    }
}