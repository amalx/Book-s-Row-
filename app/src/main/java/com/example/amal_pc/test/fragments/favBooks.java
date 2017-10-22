package com.example.med.test.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.example.med.test.R;
import com.example.med.test.utils.Media;
import com.example.med.test.utils.MediaAdapter;

import java.io.File;
import java.util.ArrayList;


public class favBooks extends Fragment {

	private static ViewGroup layout;

	ListView picturelist;
	Cursor picturecursor;
	int picture_column_index;
	int count;
	MediaPlayer mMediaPlayer;
	ArrayList<Media> picturelistArray;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		layout = (ViewGroup) inflater.inflate(R.layout.picture_frag, container, false);
		return layout;
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub

	//	init_phone_picture_grid();

		super.onStart();
	}



}
