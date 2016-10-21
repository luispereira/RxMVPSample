package com.lpereira.observablesample;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author lpereira on 21/10/2016.
 */

public class Presenter {

    private final Model model;
    private final IPresenter mIPresenter;

    public Presenter(IPresenter iPresenter) {
        model = new Model();
        mIPresenter = iPresenter;
    }

    public void requestConfigs(){
        model.getConfigurationsFromDb()
                .subscribeOn(Schedulers.io()) //execute requests should be on io() thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomRequestSubscriber(mIPresenter));
    }
}
