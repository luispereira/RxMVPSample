package com.lpereira.observablesample.presentation;

import com.lpereira.observablesample.features.dagger.PerActivity;
import com.lpereira.observablesample.features.shared.CustomRequestSubscriber;
import com.lpereira.observablesample.model.Model;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

import javax.inject.Inject;

/**
 * @author lpereira on 21/10/2016.
 */
@PerActivity
public class MainPresenter<T> implements IPresenter<T>{
    private Subscription subscription = Subscriptions.empty();

    private final Model model;
    private IMainView view;

    @Inject
    public MainPresenter() {
        model = new Model();
    }

    @Override public void setView(IMainView view) {
        this.view = view;
        if (view == null) {
            subscription.unsubscribe();
        }
    }

    public void requestConfigs(){
        subscription = model.getConfigurationsFromDb()
                .subscribeOn(Schedulers.io()) //execute requests should be on io() thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomRequestSubscriber(view));
    }

    @Override
    public void destroy() {
        this.subscription.unsubscribe();
        this.view = null;
    }
}
