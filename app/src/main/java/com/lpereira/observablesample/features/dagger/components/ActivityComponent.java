package com.lpereira.observablesample.features.dagger.components;

import com.lpereira.observablesample.features.dagger.PerActivity;
import com.lpereira.observablesample.features.dagger.modules.ActivityModule;
import com.lpereira.observablesample.ui.MainActivity;
import dagger.Component;

/**
 * @author lpereira on 21/10/2016.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}