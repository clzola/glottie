package com.clzola.glottie;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.LottieAnimationView;

public class GlottieView extends FrameLayout {

    protected ImageView mImageView;
    protected LottieAnimationView mAnimationView;

    public GlottieView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public GlottieView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public GlottieView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GlottieView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        initImageView(attributeSet);
        initAnimationView(attributeSet);
    }

    private void initImageView(@Nullable AttributeSet attributeSet) {
        mImageView = new ImageView(getContext(), attributeSet);
        FrameLayout.LayoutParams imageViewLp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        mImageView.setLayoutParams(imageViewLp);
        addView(mImageView);
    }

    private void initAnimationView(@Nullable AttributeSet attributeSet) {
        mAnimationView = new LottieAnimationView(getContext(), attributeSet);
        FrameLayout.LayoutParams imageViewLp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        mAnimationView.setLayoutParams(imageViewLp);
        mAnimationView.setVisibility(View.GONE);
        addView(mAnimationView);
    }

    protected void setLoading() {
        showAnimationView();
    }

    protected void finishedLoadingImage() {
        hideAnimationView();
    }

    protected void setErrorState() {
        hideAnimationView();
    }

    private void showAnimationView() {
        mImageView.setVisibility(View.INVISIBLE);
        mAnimationView.setVisibility(View.VISIBLE);
        mAnimationView.playAnimation();
    }

    private void hideAnimationView() {
        mImageView.setVisibility(View.VISIBLE);
        mAnimationView.setVisibility(View.GONE);
        mAnimationView.cancelAnimation();
    }

    public void setImageDrawable(Drawable drawable) {
        mImageView.setImageDrawable(drawable);
    }
}
