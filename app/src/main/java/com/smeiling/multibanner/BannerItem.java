package com.smeiling.multibanner;

import android.view.View;

/**
 * Created by Smeiling on 2017/12/26.
 */

public class BannerItem {
    private String imageUrl;
    private String redirectUrl;
    private View childView;

    BannerItem(){}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public View getChildView() {
        return childView;
    }

    public void setChildView(View childView) {
        this.childView = childView;
    }
}
