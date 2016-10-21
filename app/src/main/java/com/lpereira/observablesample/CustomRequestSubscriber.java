package com.lpereira.observablesample;

/**
 * @author lpereira on 21/10/2016.
 */
public class CustomRequestSubscriber<T> extends rx.Subscriber<T> {
    private final IPresenter mIPresenter;

    public CustomRequestSubscriber(IPresenter iPresenter) {
        mIPresenter = iPresenter;
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ServerErrorException){
            mIPresenter.onServerError();
        }else{
            mIPresenter.onClientError();
        }
        //Deal with errors
    }

    @Override
    public void onNext(T t) {
        if (t != null) {
            mIPresenter.onSuccess(t);
        }else{
            mIPresenter.onServerError();
        }
    }
}
