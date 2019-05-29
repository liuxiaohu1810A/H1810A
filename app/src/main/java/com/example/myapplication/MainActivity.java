package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.myapplication.presenter.Presenter;
import com.example.myapplication.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRlv;
    private ArrayList<User.DataBean> users;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Presenter presenter = new Presenter(this);
        presenter.getDataP();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //创建适配器
        users = new ArrayList<>();
        adapter = new MyAdapter(this, users);
        mRlv.setAdapter(adapter);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void onSuccess(List<User.DataBean> success) {
        users.addAll(success);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Log.d(TAG, "onError: "+error);
    }
}
