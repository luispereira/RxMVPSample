package com.lpereira.observablesample.ui;

import android.app.Activity;
import android.os.Bundle;
import com.lpereira.observablesample.App;
import com.lpereira.observablesample.features.dagger.components.AppComponent;
import com.lpereira.observablesample.features.dagger.modules.ActivityModule;

/**
 * @author lpereira on 21/10/2016.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Get the Main Application component for dependency injection.
     */
    protected AppComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
