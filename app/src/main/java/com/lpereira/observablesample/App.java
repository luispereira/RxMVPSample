package com.lpereira.observablesample;

import android.app.Application;
import com.lpereira.observablesample.features.dagger.components.AppComponent;
import com.lpereira.observablesample.features.dagger.components.DaggerAppComponent;
import com.lpereira.observablesample.features.dagger.modules.AppModule;

/**
 * @author lpereira on 21/10/2016.
 */

public class App extends Application {
    private AppComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}