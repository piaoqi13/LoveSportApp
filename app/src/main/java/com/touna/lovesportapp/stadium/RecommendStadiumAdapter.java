package com.touna.lovesportapp.stadium;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.touna.lovesportapp.R;
import com.touna.lovesportapp.model.RecommendStadiumInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * created by collin on 2015-12-12.
 */
public class RecommendStadiumAdapter extends BaseAdapter {
    private Activity mContext;
    private List<RecommendStadiumInfo> mStadiums;
    private final LayoutInflater mInflater;

    public RecommendStadiumAdapter(Activity context, List<RecommendStadiumInfo> stadiums) {
        mContext = context;
        mStadiums = stadiums;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mStadiums == null) return 0;
        return mStadiums.size();
    }

    @Override
    public Object getItem(int i) {
        return mStadiums.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        RecommendStadiumInfo stadiumInfo = mStadiums.get(i);
        if (view == null) {
            view = mInflater.inflate(R.layout.recommend_stadium_item, null);
            holder = new ViewHolder(view, stadiumInfo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
            holder.update(stadiumInfo);
        }

        return view;
    }

    private class ViewHolder {
        private RecommendStadiumInfo mStadium;

        public ViewHolder(View view, RecommendStadiumInfo stadium) {
            x.view().inject(this, view);
            mStadium = stadium;
            setData();
        }

        private void update(RecommendStadiumInfo stadium) {
            mStadium = stadium;
            setData();
        }

        @ViewInject(R.id.iv_recommend_stadium_logo)
        private ImageView mIvStadiumLogo;

        @ViewInject(R.id.tv_recommend_stadium_name)
        private TextView mTvStadiumName;

        @ViewInject(R.id.tv_recommend_stadium_location)
        private TextView mTvStadiumLocation;

        @ViewInject(R.id.tv_recommend_stadium_price)
        private TextView mTvStadiumPrice;

        @ViewInject(R.id.tv_recommend_stadium_book)
        private TextView mTvStadiumBook;

        private void setData() {
            mIvStadiumLogo.setBackgroundResource(R.drawable.recommend_stadium_logo);
            mTvStadiumName.setText(mStadium.getName());
            mTvStadiumLocation.setText(mStadium.getLocation());
            mTvStadiumPrice.setText(mStadium.getPrice());
            mTvStadiumBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("CollinWang", "book is run");
                }
            });
        }
    }
}
