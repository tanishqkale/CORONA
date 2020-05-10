package com.example.coronago;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public sliderAdapter (Context context){
        this.context = context;
    }

    //arrays
    public int[] slide_images = {
        R.drawable.app_logo,
            R.drawable.install,
            R.drawable.mask

    };

    public String[] slide_headings = {
            "We have the power to help prevent the spread of Coronavirus Virus pandemic.",
            "This app aims at giving basic information related to pandemic.",
            "It is mandatory to wear mask"
    };

    public String[] slide_disc = {
            "Obeying the norms can definately stop its spread.",
            "Simply install the app and invite your friends and family to install the app to",
            "The app alerts are how to self isolate and what to do in case you develop symptoms"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object o) {
        return view == (RelativeLayout) o;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_disc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_disc[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
