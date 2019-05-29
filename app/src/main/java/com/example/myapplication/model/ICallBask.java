package com.example.myapplication.model;

import com.example.myapplication.User;

import java.util.List;

public interface ICallBask {
    void onSuccess(List<User.DataBean> success);
    void onError(String error);
}
