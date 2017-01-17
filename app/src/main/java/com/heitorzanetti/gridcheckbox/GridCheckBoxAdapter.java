package com.heitorzanetti.gridcheckbox;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by heitorzc on 08/02/16.
 */
public class GridCheckBoxAdapter extends BaseAdapter {

	private int animSpeed = 200;
	private Bundle attrs;
	private List<CheckItem> items;
	private LayoutInflater mInflater;
	private ViewHolder holder;
	private Context context;


    private class ViewHolder {
		ItemImageView ivImage;
		ItemImageView ivIndicator;
        TextView tvDescription;

        ViewHolder(View view) {
            ivImage       = (ItemImageView) view.findViewById(R.id.image);
            ivIndicator   = (ItemImageView) view.findViewById(R.id.indicator);
            tvDescription = (TextView)      view.findViewById(R.id.description);
		}

    }


	public GridCheckBoxAdapter(Context context, Bundle attrs) {
		mInflater = LayoutInflater.from(context);
		this.context = context;
		this.attrs = attrs;
		this.animSpeed = attrs.getInt("checkAnimSpeed");
	}


    public void setItems(List<CheckItem> items){
        this.items = items;
    }


	@Override
	public int getCount() {
		return items.size();
	}


	@Override
	public Object getItem(int index) {
		return items.get(index);
	}


	@Override
	public long getItemId(int index) {
		return index;
	}


    @SuppressLint("NewApi")
    @Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
 
		if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_check_box, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
 
		} else {

			holder = (ViewHolder) convertView.getTag();

		}

		setAttrs();

		final CheckItem item = items.get(position);

		Picasso.with(context).load(item.getImage()).into(holder.ivImage);
		holder.tvDescription.setText(item.getDescription());

		if (item.isSelected()){
			holder.ivIndicator.setVisibility(View.VISIBLE);
			holder.ivIndicator.setAnimation(fadeIn(0));
			holder.ivImage.setAnimation(fadeOut(0.1f));
		}
		else {
			if (holder.ivIndicator.getVisibility() != View.GONE) {
				holder.ivIndicator.setVisibility(View.GONE);
				holder.ivIndicator.setAnimation(fadeOut(0.0F));
				holder.ivImage.setAnimation(fadeIn(0.1f));
			}

		}


		return convertView;
	}


	private void setAttrs(){
		holder.tvDescription.setTextSize(attrs.getInt("textSize"));
		holder.tvDescription.setGravity(attrs.getInt("textGravity"));
		holder.tvDescription.setTextColor(context.getResources().getColor(attrs.getInt("textColor")));
		holder.ivIndicator.setImageDrawable(context.getResources().getDrawable(attrs.getInt("checkDrawable")));
	}


	private AlphaAnimation fadeIn(float start){
		AlphaAnimation fadeIn = new AlphaAnimation(start, 1.0f);
		fadeIn.setDuration(animSpeed);
		fadeIn.setFillAfter(true);

		return fadeIn;
	}


	private AlphaAnimation fadeOut(float end){
		AlphaAnimation fadeOut = new AlphaAnimation(1.0f, end);
		fadeOut.setDuration(animSpeed);
		fadeOut.setFillAfter(true);

		return fadeOut;
	}


}