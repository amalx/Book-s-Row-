package com.example.med.test.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.med.test.R;
import com.example.med.test.utils.Media;
import com.example.med.test.utils.MediaAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class SignBook extends Fragment {

	private static ViewGroup layout;

	int TAKE_PHOTO_CODE = 0;
	public static int count = 0;
	public String array_spinner[];

	private View view;

	private String array_spinner2[];
	final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
	File newdir = new File(dir);


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		layout = (ViewGroup) inflater.inflate(R.layout.add_book, container, false);


		Button capture = (Button) layout.findViewById(R.id.btnCapture);

		Spinner s = (Spinner) layout.findViewById(R.id.spinner1);
		Spinner s2 = (Spinner) layout.findViewById(R.id.spinner2);
		newdir.mkdirs();
		array_spinner=new String[8];
		array_spinner[0]="Romance";
		array_spinner[1]="Action";
		array_spinner[2]="Drama";
		array_spinner[3]="Biography";
		array_spinner[4]="Crime";
		array_spinner[5]="Comedy";
		array_spinner[6]="History";
		array_spinner[7]="Mystery";
//*******//
		array_spinner2=new String[6];
		array_spinner2[0]="Gafsa";
		array_spinner2[1]="Ariana";
		array_spinner2[2]="Tunis";
		array_spinner2[3]="Manouba";
		array_spinner2[4]="Ben Arous";
		array_spinner2[5]="Monastir";



		s.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
				android.R.layout.simple_list_item_1, array_spinner));

		s2.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
				android.R.layout.simple_list_item_1, array_spinner2));
		return layout;
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
	//	init_phone_music_grid();

		super.onStart();
	}

	public void onClick(View v) {

		switch (v.getId()){
			case R.id.btnCapture:
				// Here, the counter will be incremented each time, and the
				// picture taken by camera will be stored as 1.jpg,2.jpg
				// and likewise.
				count++;
				String file = dir + count + ".jpg";
				File newfile = new File(file);
				try {
					newfile.createNewFile();
				} catch (IOException e) {
				}

				Uri outputFileUri = Uri.fromFile(newfile);

				Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

				startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
				break;
		}
	}


}
