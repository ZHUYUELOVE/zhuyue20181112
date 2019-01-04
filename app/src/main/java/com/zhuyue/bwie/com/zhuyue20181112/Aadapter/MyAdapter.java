package com.zhuyue.bwie.com.zhuyue20181112.Aadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.zhuyue.bwie.com.zhuyue20181112.R;
import com.zhuyue.bwie.com.zhuyue20181112.bean.Json;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private final int ITEM_ONE = 0;
    private final int ITEM_TWO = 1;
    private ArrayList<Json.DataBean> mList;
    private Context mContext;
    private ImageLoader mImageLoader = ImageLoader.getInstance();
    private DisplayImageOptions mDisplayImageOp;

    public MyAdapter(ArrayList<Json.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        mDisplayImageOp = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderOne one = null;
        HolderTwo two = null;
        int type = getItemViewType(position);
        Json.DataBean dataBean = mList.get(position);
        switch (type) {
            case ITEM_ONE:
                if (convertView == null) {
                    one = new HolderOne();
                    convertView = View.inflate(mContext, R.layout.item_one, null);
                    one.mNameOne = convertView.findViewById(R.id.Item_One_Text);
                    one.mImageOne = convertView.findViewById(R.id.Item_One_Image);
                    convertView.setTag(one);
                } else {
                    one = (HolderOne) convertView.getTag();
                }
                one.mNameOne.setText(dataBean.getNews_title() + "");
                mImageLoader.displayImage(dataBean.getPic_url(), one.mImageOne, mDisplayImageOp);
                break;
            case ITEM_TWO:
                if (convertView == null) {
                    two = new HolderTwo();
                    convertView = View.inflate(mContext, R.layout.item_two, null);
                    two.mNameTwo = convertView.findViewById(R.id.Item_Two_Text);
                    two.mImageTwo = convertView.findViewById(R.id.Item_Two_Image);
                    convertView.setTag(two);
                } else {
                    two = (HolderTwo) convertView.getTag();
                }
                two.mNameTwo.setText(dataBean.getNews_title() + "");
                mImageLoader.displayImage(dataBean.getPic_url(), two.mImageTwo, mDisplayImageOp);
                break;
        }

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return ITEM_ONE;
        } else {
            return ITEM_TWO;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    class HolderOne {
        private TextView mNameOne;
        private ImageView mImageOne;
    }

    class HolderTwo {
        private TextView mNameTwo;
        private ImageView mImageTwo;
    }
}
