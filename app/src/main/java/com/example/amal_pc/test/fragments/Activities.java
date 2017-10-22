package com.example.med.test.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.med.test.MainActivity;
import com.example.med.test.PagerActivity;
import com.example.med.test.R;

public class Activities extends android.support.v4.app.ListFragment {

	String[] catagories = new String[] {"Music","Video","Picture","About","Exit"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//Creating an array adapter to store the list of categories
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
		(inflater.getContext(), android.R.layout.simple_list_item_1,catagories);

		//Setting the list adapter for the ListFragment
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		switch (position) {
		case 0:
		case 1:
		case 2:
			PagerActivity.pager.setCurrentItem(position+1);
			break;
		case 3:
			Dialog dialog = new Dialog(getActivity());
			dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			dialog.setContentView(R.layout.add_edit);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			dialog.show();
			break;
		case 4:
			getActivity().finish();
			break;
		}
	}
}