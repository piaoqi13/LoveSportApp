package com.touna.lovesportapp.mine;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.touna.lovesportapp.R;
import com.touna.lovesportapp.model.OrderInfo;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * created by collin on 2016-01-04.
 */
public class MyOrderAdapter extends BaseAdapter {
    private Activity mContext;
    private List<OrderInfo> mOrderInfos;
    private final LayoutInflater mInflater;

    public MyOrderAdapter(Activity context, List<OrderInfo> orderInfos) {
        mContext = context;
        mOrderInfos = orderInfos;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if (mOrderInfos == null) return 0;
        return mOrderInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return mOrderInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        OrderInfo orderInfo = mOrderInfos.get(i);
        if (view == null) {
            view = mInflater.inflate(R.layout.my_order_item, null);
            holder = new ViewHolder(view, orderInfo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
            holder.update(orderInfo);
        }

        return view;
    }

    private class ViewHolder {
        private OrderInfo mOrderInfo;

        public ViewHolder(View view, OrderInfo orderInfo) {
            x.view().inject(this, view);
            mOrderInfo = orderInfo;
            setData();
        }

        private void update(OrderInfo orderInfo) {
            mOrderInfo = orderInfo;
            setData();
        }

        @ViewInject(R.id.tv_order_stadium_name)
        private TextView mTvStadiumName;

        @ViewInject(R.id.tv_order_state)
        private TextView mTvOrderState;

        @ViewInject(R.id.tv_order_start_time)
        private TextView mTvStartTime;

        @ViewInject(R.id.tv_order_code)
        private TextView mTvCode;

        @ViewInject(R.id.tv_order_stadium_number)
        private TextView mTvStadiumNumber;

        @ViewInject(R.id.tv_order_money)
        private TextView mTvMoney;

        @ViewInject(R.id.btn_order_cancel)
        private Button mBtnCancelOrder;

        @ViewInject(R.id.btn_order_pay)
        private Button mBtnPayOrder;

        private void setData() {
            mTvStadiumName.setText(mOrderInfo.getStadiumName());
            mTvOrderState.setText(mOrderInfo.getState());
            mTvStartTime.setText(mOrderInfo.getStartTime());
            mTvCode.setText(mOrderInfo.getCode());
            mTvStadiumNumber.setText(mOrderInfo.getStadiumNumber());
            mTvMoney.setText(mOrderInfo.getMoney());
            mBtnCancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("CollinWang", "cancel is run");
                }
            });

            mBtnPayOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("CollinWang", "pay is run");
                }
            });
        }
    }
}
