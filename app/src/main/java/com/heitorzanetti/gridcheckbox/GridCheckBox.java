package com.heitorzanetti.gridcheckbox;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heitorzc on 21/12/2016.
 */

//TODO: Add customizations, such as: Square imageView, extended height, allow multiple selection, add attrs on xml.
public class GridCheckBox extends GridView implements AdapterView.OnItemClickListener{

    private Bundle attrs = new Bundle();
    private GridCheckBoxAdapter adapter;
    private List<CheckItem> items = new ArrayList<>();
    private OnGridItemSelectedListener listener;
    private OnMultipleGridItemsSelected mListener;


    public GridCheckBox(Context context) {
        super(context);
        inflateView(context);
    }

    public GridCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateView(context);
    }

    public GridCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GridCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateView(context);
    }



    private void inflateView(Context context){

        attrs.putInt("textSize",       12);
        attrs.putInt("textGravity",    Gravity.CENTER_HORIZONTAL);
        attrs.putInt("textColor",      android.R.color.black);
        attrs.putInt("checkDrawable",  R.drawable.ic_done_black_24dp);
        attrs.putInt("checkAnimSpeed", 200);

        adapter = new GridCheckBoxAdapter(context, attrs);
        setOnItemClickListener(this);
    }



    public void addItem(String image, String description){
        items.add(new CheckItem(image, description));
        adapter.setItems(items);
        this.setAdapter(adapter);
    }


    public List<CheckItem> getItems(){
        return items;
    }


    public int getSelectedPosition(){

        for (int i = 0; i < items.size(); i++){
            if (items.get(i).isSelected()){
                return i;
            }
        }

        return -1;

    }


    public void setTextSize(int size){
        attrs.putInt("textSize", size);
    }


    public void setTextGravity(int gravity){
        attrs.putInt("textGravity", gravity);
    }


    public void setTextColor(int color){
        attrs.putInt("textColor", color);
    }


    public void setCheckDrawable(int drawable){
        attrs.putInt("checkDrawable", drawable);
    }


    public void setCheckAnimSpeed(int speed){
        attrs.putInt("checkAnimSpeed", speed);
    }


    public void setOnGridItemSelectedListener(OnGridItemSelectedListener listener){
        this.listener = listener;
    }

    public void setOnMultipleGridItemsSelectedListener(OnMultipleGridItemsSelected mListener){
        this.mListener = mListener;
    }



    public void select(int i) {

        for (int j = 0; j < items.size(); j++) {
            if (j == i) {
                items.get(j).setSelected(true);
            }
            else {
                items.get(j).setSelected(false);
            }

        }

        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        select(i);

        if (listener != null) listener.onGridItemSelected(i);

    }


}
