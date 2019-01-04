package com.zhuyue.bwie.com.zhuyue20181112;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.zhuyue.bwie.com.library.view.XListView;
import com.zhuyue.bwie.com.zhuyue20181112.Aadapter.MyAdapter;
import com.zhuyue.bwie.com.zhuyue20181112.bean.Json;
import com.zhuyue.bwie.com.zhuyue20181112.utils.HttpUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements XListView.IXListViewListener {
    private String mUrl ="http://api.expoon.com/AppNews/getNewsList/type/1/p/1";
    private int index = 1;
    private View mView;
    private ArrayList<Json.DataBean> mList = new ArrayList<>();
    private XListView X_ListView;
    private MyAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_a, container, false);

        initView(mView);
        mAdapter=new MyAdapter(mList,getActivity());
        X_ListView.setAdapter(mAdapter);
        new MyTask().execute(mUrl+index);
        return mView;
    }

    private void initView(View mView) {
        X_ListView = mView.findViewById(R.id.X_ListView);
        X_ListView.setPullLoadEnable(true);
        X_ListView.setXListViewListener(this);
    }

    @Override
    public void onRefresh() {
        mList.clear();
        index=1;
        new MyTask().execute(mUrl+index);

    }
    public void stop(){
        X_ListView.stopRefresh();
        X_ListView.stopLoadMore();
        X_ListView.setRefreshTime("刚刚");

    }

    @Override
    public void onLoadMore() {
        index++;
        new MyTask().execute(mUrl+index);

    }
    class MyTask extends AsyncTask<String,Void,ArrayList<Json.DataBean>>{

        @Override
        protected ArrayList<Json.DataBean> doInBackground(String... strings) {
            try {
                String s = HttpUtils.get(strings[0]);
                Gson gson = new Gson();
                Json json = gson.fromJson(s, Json.class);
                return (ArrayList<Json.DataBean>)json.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Json.DataBean> dataBeans) {
            mList.addAll(dataBeans);
            mAdapter.notifyDataSetChanged();
            stop();

        }
    }
}
