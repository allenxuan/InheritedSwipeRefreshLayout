package com.xuanyihuang.allenxuan.inheritedswiperefreshlayout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;

/**
 * Created by allenxuan on 21/02/2018.
 */

class HeaderView extends FrameLayout {
    private View mViewRoot = null;

    private Animation.AnimationListener mListener;

    HeaderView(Context context) {
        this(context, null);
    }

    HeaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void inflateLayout(@LayoutRes int layoutRes){
        if(getContext() != null) {
            mViewRoot = LayoutInflater.from(getContext()).inflate(layoutRes, this);
        }
    }

    public void setAnimationListener(Animation.AnimationListener listener) {
        mListener = listener;
    }

    @Override
    public void onAnimationStart() {
        super.onAnimationStart();
        if (mListener != null) {
            mListener.onAnimationStart(getAnimation());
        }
    }

    @Override
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (mListener != null) {
            mListener.onAnimationEnd(getAnimation());
        }
    }
}
