package com.example.hemant.myapplication.expandable;

import android.content.Context;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemant.myapplication.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

@Layout(R.layout.child_layout)
public class  ChildView {
    private static String TAG ="ChildView";
    private int count = 0;
    @View(R.id.child_name)
    TextView textViewChild;

    @View(R.id.child_desc)
    TextView textViewDesc;

    @View(R.id.child_image)
    ImageView childImage;

    @View(R.id.rbChecked)
    CheckBox rbChecked;


    private Context mContext;
    private Movie movie;



    public ChildView(Context mContext, Movie movie) {
        this.mContext = mContext;
        this.movie = movie;
        AppData.getInstance().addMovie(movie);
    }

    @Resolve
    private void onResolve(){
        Log.d(TAG,"onResolve");
        textViewChild.setText(movie.getName());
        rbChecked.setChecked(movie.isChecked());
//        Glide.with(mContext).load(movie.getImageUrl()).apply(RequestOptions.circleCropTransform()).into(childImage);
    }
    @Click(R.id.child_image)
    public void onClick() {
        count ++;
//        mExpandablePlaceHolderView.addChildView(mParentPosition, new ChildItem(mExpandablePlaceHolderView));
        Toast.makeText(mContext, "child_name:"+movie.getName(), Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.rbChecked)
    public void onRadioClick(){
        boolean checked = rbChecked.isChecked();
        this.movie.setChecked(checked);

        List<Movie> movies = AppData.getInstance().getMovie();
        for (Movie movie1 : movies) {
            if(movie1.getId() == movie.getId()){
                movie1.setChecked(movie.isChecked());
            }
        }


        Toast.makeText(mContext, "checked:"+checked, Toast.LENGTH_SHORT).show();
    }
}