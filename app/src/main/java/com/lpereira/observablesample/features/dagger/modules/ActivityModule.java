package com.lpereira.observablesample.features.dagger.modules;

import android.app.Activity;
import com.lpereira.observablesample.features.dagger.PerActivity;
import com.lpereira.observablesample.presentation.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * @author lpereira on 21/10/2016.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    MainPresenter providedPresenterOps() {
        return new MainPresenter();
    }
}