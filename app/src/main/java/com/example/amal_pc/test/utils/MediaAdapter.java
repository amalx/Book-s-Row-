package com.example.med.test.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.med.test.R;

import java.util.List;

public class MediaAdapter extends ArrayAdapter<Media> {

	Context context;
	int layoutResourceId;    
	List<Media> medias = null;

	public MediaAdapter(Context context, int layoutResourceId, List<Media> medias) {
		super(context, layoutResourceId, medias);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.medias = medias;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		MediaHolder holder = null;

		if(row == null)
		{
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new MediaHolder();
			holder.size = (TextView)row.findViewById(R.id.size);
			holder.name = (TextView)row.findViewById(R.id.name);
			row.setTag(holder);
		}
		else
		{
			holder = (MediaHolder)row.getTag();
		}

		Media media = medias.get(position);

		holder.size.setText(media.getSize()+"\nKB");
		holder.name.setText(media.getName());


		return row;
	}
	public class MediaHolder
	{
		TextView size;
		TextView name;
	}
}