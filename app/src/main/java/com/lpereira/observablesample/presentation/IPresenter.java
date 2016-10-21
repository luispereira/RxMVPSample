package com.lpereira.observablesample.presentation;

/**
 * @author lpereira on 21/10/2016.
 */
public interface IPresenter<T> {
    void setView(IMainView view);

    void destroy();
}
