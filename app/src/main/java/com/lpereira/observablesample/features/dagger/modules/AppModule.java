package com.lpereira.observablesample.features.dagger.modules;

import android.content.Context;
import com.lpereira.observablesample.App;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author lpereira on 21/10/2016.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}