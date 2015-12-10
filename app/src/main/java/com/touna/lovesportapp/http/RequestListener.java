package com.touna.lovesportapp.http;

import com.touna.lovesportapp.event.ResultEvent;

/**
 * created by collin on 2015-12-08.
 */
public interface RequestListener {
    void onUpdate(ResultEvent event, Object obj);
}
