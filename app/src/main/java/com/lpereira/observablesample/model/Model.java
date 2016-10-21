package com.lpereira.observablesample.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author lpereira on 21/10/2016.
 */

public class Model {

    public rx.Observable<List<String>> getConfigurationsFromDb(){
        return rx.Observable.just(Arrays.asList("1", "2", "3"));
    }
}
