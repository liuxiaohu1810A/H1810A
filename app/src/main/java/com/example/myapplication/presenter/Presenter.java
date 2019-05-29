package com.example.myapplication.presenter;

import com.example.myapplication.User;
import com.example.myapplication.model.ICallBask;
import com.example.myapplication.model.Modelmap;
import com.example.myapplication.view.IView;

import java.util.List;

public class Presenter implements IPresenter{
    private final Modelmap modelmap;
    private IView iView;

    public Presenter(IView iView) {
        modelmap = new Modelmap();
        this.iView = iView;
    }

    @Override
    public void getDataP() {
        if (modelmap!=null){
            modelmap.getDataM(new ICallBask() {
                @Override
                public void onSuccess(List<User.DataBean> success) {
                    iView.onSuccess(success);
                }

                @Override
                public void onError(String error) {
                    iView.onError(error);
                }
            });
        }
    }
}
