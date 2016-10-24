package com.lpereira.observablesample.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.lpereira.observablesample.R;
import com.lpereira.observablesample.features.dagger.components.ActivityComponent;
import com.lpereira.observablesample.features.dagger.components.DaggerActivityComponent;
import com.lpereira.observablesample.presentation.IMainView;
import com.lpereira.observablesample.presentation.MainPresenter;

import javax.inject.Inject;
import java.util.List;

import static android.view.View.GONE;

public class MainActivity extends BaseActivity implements IMainView {

    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        setContentView(R.layout.activity_main);

        presenter.setView(this);
        //make the request
        presenter.requestConfigs();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initializeInjector() {
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        activityComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public <T> void onSuccess(T result) {
        Log.d("MainActivity", "Success!");
        if(((List<String>)result).contains("1")){
            findViewById(R.id.textExample).setVisibility(GONE);
        }else {
            findViewById(R.id.textExample).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onServerError() {

    }

    @Override
    public void onClientError() {

    }
}
