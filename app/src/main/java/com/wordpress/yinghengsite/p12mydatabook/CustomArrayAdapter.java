package com.wordpress.yinghengsite.p12mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter {

    private ArrayList<String> al;
    private Context context;
    private TextView tv;
    private ImageView image;

    public CustomArrayAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);

        al = objects;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tv = (TextView) rowView.findViewById(R.id.alTV);

        String currentString = al.get(position);


        image = (ImageView) rowView.findViewById(R.id.alIV);

        if (currentString.equalsIgnoreCase("Bio")) {
            image.setImageResource(android.R.drawable.ic_dialog_info);
            tv.setText(currentString);
        } else if (currentString.equalsIgnoreCase("Vaccination")) {
            image.setImageResource(android.R.drawable.ic_menu_edit);
            tv.setText(currentString);
        } else if (currentString.equalsIgnoreCase("Anniversary")) {
            image.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else
            image.setImageResource(android.R.drawable.star_big_on);
        tv.setText(currentString);

        return rowView;
    }

}
