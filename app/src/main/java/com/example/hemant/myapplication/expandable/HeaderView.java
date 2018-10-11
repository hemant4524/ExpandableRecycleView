package com.example.hemant.myapplication.expandable;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.hemant.myapplication.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.expand.Collapse;
import com.mindorks.placeholderview.annotations.expand.Expand;
import com.mindorks.placeholderview.annotations.expand.Parent;
import com.mindorks.placeholderview.annotations.expand.ParentPosition;
import com.mindorks.placeholderview.annotations.expand.SingleTop;

@Parent
@SingleTop
@Layout(R.layout.header_layout)
public class HeaderView {

    private static String TAG = "HeaderView";
    @Position
    private int mParentPosition;


    @View(R.id.header_text)
    TextView headerText;

    private Context mContext;
    private String mHeaderText;

    public HeaderView(Context context,String headerText) {
        this.mContext = context;
        this.mHeaderText = headerText;
        mParentPosition = 1;
    }

    @Resolve
    private void onResolve(){
        Log.d(TAG, "onResolve");
        headerText.setText(mHeaderText);
    }

    @Expand
    private void onExpand(){
        Log.d(TAG, "onExpand");
    }

    @Collapse
    private void onCollapse(){
        Log.d(TAG, "onCollapse");
    }


}