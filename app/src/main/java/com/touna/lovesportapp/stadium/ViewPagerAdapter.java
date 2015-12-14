package com.touna.lovesportapp.stadium;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * created by collin on 2015-12-12.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mViews = null;

    public ViewPagerAdapter(List<View> views) {
        this.mViews = views;
    }

    @Override
    public void destroyItem(View view, int position, Object obj) {
        ((ViewPager) view).removeView(mViews.get(position));
    }

    @Override
    public void finishUpdate(View view) {

    }

    @Override
    public int getCount() {
        return mViews != null ? mViews.size() : 0;
    }

    @Override
    public Object instantiateItem(View view, int position) {
        ((ViewPager) view).addView(mViews.get(position), 0);
        return mViews.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void restoreState(Parcelable par, ClassLoader cld) {

    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View view) {

    }
}
