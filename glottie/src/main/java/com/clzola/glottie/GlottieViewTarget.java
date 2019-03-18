package com.clzola.glottie;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class GlottieViewTarget extends ImageViewTarget<Drawable> {

    private GlottieView mTarget;

    public GlottieViewTarget(GlottieView target) {
        super(target.mImageView);
        mTarget = target;
    }

    @Override
    public void onLoadStarted(@Nullable Drawable placeholder) {
        super.onLoadStarted(null);
        mTarget.setLoading();
    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
        mTarget.setErrorState();
    }

    @Override
    public void onLoadCleared(@Nullable Drawable placeholder) {
        super.onLoadCleared(placeholder);
        mTarget.finishedLoadingImage();
    }

    @Override
    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
        super.onResourceReady(resource, transition);
        mTarget.finishedLoadingImage();
    }

    @Override
    protected void setResource(@Nullable Drawable resource) {
        mTarget.setImageDrawable(resource);
    }
}
