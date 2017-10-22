package com.example.amal_pc.test;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.med.test.fragments.Activities;
import com.example.med.test.fragments.SignBook;
import com.example.med.test.fragments.favBooks;
import com.example.med.test.fragments.ProgressDialogFrag;
import com.example.med.test.fragments.BooksList;
import com.example.med.test.utils.CustomViewPager;

import java.io.File;
import java.io.IOException;

/**
 * Created by JAMIL-PC on 06/08/2016.
 */
public class PagerActivity extends FragmentActivity {
    private static Activities allCatFrag = null;
    private static SignBook signBook = null;
    private static BooksList booksList = null;
    private static favBooks favBooks = null;

    public static CustomViewPager pager;
    ProgressDialogFrag newFragment;
    int TAKE_PHOTO_CODE = 0;
    public static int count = 0;
    private String array_spinner[];

    private String array_spinner2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_activity);

        newFragment = new ProgressDialogFrag();


        pager = (CustomViewPager)findViewById(R.id.viewpager);
        TitleAdapter titleAdapter = new TitleAdapter(getSupportFragmentManager());
        pager.setAdapter(titleAdapter);
        pager.setCurrentItem(0);

        PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);
        pagerTabStrip.setDrawFullUnderline(true);
        pagerTabStrip.setTabIndicatorColor(Color.parseColor("#00a7e7"));




    }
    class TitleAdapter extends FragmentPagerAdapter {
        private String titles[] = new String[]{"Activities","Sign a book", "Book's list", "Favourite books"};
        public TitleAdapter(FragmentManager fm) {
            super(fm);
            allCatFrag = new Activities();
            signBook = new SignBook();
            booksList = new BooksList();
            favBooks = new favBooks();
        }

        @Override
        public CharSequence getPageTitle (int position){
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return allCatFrag;
                case 1: return signBook;
                case 2: return booksList;
                case 3: return favBooks;
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }
}
