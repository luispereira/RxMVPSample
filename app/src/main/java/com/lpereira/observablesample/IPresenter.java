package com.lpereira.observablesample;

/**
 * @author lpereira on 21/10/2016.
 */
public interface IPresenter {

    <T> void onSuccess(T result);

    void onServerError();

    void onClientError();
}
