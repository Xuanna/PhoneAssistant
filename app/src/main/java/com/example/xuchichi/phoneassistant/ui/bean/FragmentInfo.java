package com.example.xuchichi.phoneassistant.ui.bean;


/**
 * Created by xuchichi on 2018/4/3.
 */

public class FragmentInfo {
    private Class fragments;
    private String title;

    public FragmentInfo(String title, Class fragments) {
        this.fragments = fragments;
        this.title = title;
    }

    public Class getFragments() {
        return fragments;
    }

    public void setFragments(Class fragments) {
        this.fragments = fragments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
