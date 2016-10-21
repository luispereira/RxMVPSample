package com.lpereira.observablesample.features.dagger;

/**
 * @author lpereira on 21/10/2016.
 */


import javax.inject.Scope;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}