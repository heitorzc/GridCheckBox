package com.heitorzanetti.gridcheckbox;

import android.content.Context;
import android.util.AttributeSet;

import com.github.siyamed.shapeimageview.CircularImageView;

/**
 * Created by heitorzc on 14/01/2017.
 */

public class ItemImageView extends CircularImageView {



    public ItemImageView(Context context) {
        super(context);
        init();
    }


    public ItemImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public ItemImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        setBorderAlpha(0.0f);
        setBorderWidth(0);
    }


    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }*/
}
