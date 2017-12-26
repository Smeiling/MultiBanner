package com.smeiling.multibanner;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Smeiling on 2017/12/26.
 */

public class MyViewer extends FrameLayout {

    private List<BannerItem> items;
    private ViewPager viewPager;
    private boolean pause = true;
    private int currentIndex = 1;

    public MyViewer(@NonNull Context context) {
        super(context, null);
    }

    public MyViewer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        setBackgroundColor(Color.CYAN);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        viewPager = new ViewPager(getContext());
        viewPager.setLayoutParams(params);
        viewPager.setBackgroundColor(Color.MAGENTA);
        addView(viewPager);
    }


    public void setItems(List<BannerItem> items) {
        if (items != null && items.size() > 0) {
            this.items = items;
            BannerPagerAdapter pagerAdapter = new BannerPagerAdapter(items);
            viewPager.setAdapter(pagerAdapter);
            viewPager.setOnPageChangeListener(pageChangeListener);
            startScroll();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (pause != true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentIndex == items.size()) {
                    currentIndex = 0;
                }
                viewPager.setCurrentItem(currentIndex);
                currentIndex++;
            }
        }
    };

    public void startScroll() {
        pause = false;
        new Thread(runnable).start();
    }

    public ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class BannerPagerAdapter extends PagerAdapter {

        List<BannerItem> items;

        BannerPagerAdapter(List<BannerItem> bannerItems) {
            this.items = bannerItems;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            if (items.get(position) != null) {
                if (items.get(position).getChildView() != null) {
                    view = items.get(position).getChildView();
                } else {
                    ImageView imageView = new ImageView(getContext());
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    imageView.setLayoutParams(params);
                    Glide.with(getContext()).load(items.get(position)
                            .getImageUrl())
                            .placeholder(R.drawable.placeholder)
                            .into(imageView);

                    view = imageView;
                }
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
