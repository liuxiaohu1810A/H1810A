package com.example.myapplication.view;

import com.example.myapplication.User;

import java.util.List;

public interface IView {
    void onSuccess(List<User.DataBean> success);
    void onError(String error);
}
