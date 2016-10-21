package com.lpereira.observablesample.features.dagger.components;

import android.content.Context;
import com.lpereira.observablesample.features.dagger.modules.AppModule;
import com.lpereira.observablesample.ui.BaseActivity;
import dagger.Component;

import javax.inject.Singleton;

/**
 * @author lpereira on 21/10/2016.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
}