package com.lpereira.observablesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IPresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Presenter(this).requestConfigs();
    }

    @Override
    public <T> void onSuccess(T result) {
        //TODO refresh UI
    }

    @Override
    public void onServerError() {

    }

    @Override
    public void onClientError() {

    }
}
