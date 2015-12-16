package com.touna.lovesportapp.coach;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.touna.lovesportapp.R;
import com.touna.lovesportapp.model.CoachInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * created by collin on 2015-12-16.
 */
public class CoachListAdapter extends BaseAdapter {
    private Activity mContext;
    private List<CoachInfo> mCoachs;
    private final LayoutInflater mInflater;

    public CoachListAdapter(Activity context, List<CoachInfo> coachs) {
        mContext = context;
        mCoachs = coachs;
        mInflater = LayoutInflater.from(mContext);
    }

    public void refleshCoach(List<CoachInfo> coachs) {
        this.mCoachs = coachs;
    }

    @Override
    public int getCount() {
        if (mCoachs == null) return 0;
        return mCoachs.size();
    }

    @Override
    public Object getItem(int i) {
        return mCoachs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        CoachInfo coachInfo = mCoachs.get(i);
        if (view == null) {
            view = mInflater.inflate(R.layout.coach_list_item, null);
            holder = new ViewHolder(view, coachInfo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
            holder.update(coachInfo);
        }

        return view;
    }

    private class ViewHolder {
        private CoachInfo mCoach;

        public ViewHolder(View view, CoachInfo coach) {
            x.view().inject(this, view);
            mCoach = coach;
            setData();
        }

        private void update(CoachInfo stadium) {
            mCoach = stadium;
            setData();
        }

        @ViewInject(R.id.iv_coach_logo)
        private ImageView mIvCoachLogo;

        @ViewInject(R.id.tv_coach_name)
        private TextView mTvCoachName;

        @ViewInject(R.id.tv_coach_from_stadium)
        private TextView mTvCoachFrom;

        @ViewInject(R.id.tv_coach_price)
        private TextView mTvCoachPrice;

        private void setData() {
            mIvCoachLogo.setBackgroundResource(R.drawable.coach_logo);
            mTvCoachName.setText(mCoach.getName());
            mTvCoachFrom.setText(mCoach.getFromStadium());
            mTvCoachPrice.setText(mCoach.getPrice());
        }
    }
}
