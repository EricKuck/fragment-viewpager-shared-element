package com.github.pedramrn.fragmentset;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.changehandler.SharedElementTransitionChangeHandler;

public class ChangeHandler extends SharedElementTransitionChangeHandler {

    @NonNull
    private final View fromView;

    @NonNull
    private final String toName;

    public ChangeHandler() {
        this(null, null);
    }

    public ChangeHandler(@NonNull View fromView, @NonNull String toName) {
        this.fromView = fromView;
        this.toName = toName;
    }

    @Override
    public void configureSharedElements(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        addSharedElement(fromView, toName);
    }

    @Nullable
    @Override
    public Transition getExitTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        if (isPush) {
            return new Explode();
        } else {
            TransitionSet transitionSet = new TransitionSet().setOrdering(TransitionSet.ORDERING_SEQUENTIAL)
                    .addTransition(new Slide(Gravity.BOTTOM))
                    .addTransition(new Fade(Fade.IN));
            transitionSet.setDuration(300);

            return transitionSet;
        }
    }

    @Nullable
    @Override
    public Transition getSharedElementTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        TransitionSet transition = new TransitionSet()
                .setOrdering(TransitionSet.ORDERING_TOGETHER)
                .addTransition(new ChangeTransform())
                .addTransition(new ChangeBounds())
                .addTransition(new ChangeClipBounds())
                .addTransition(new ChangeImageTransform());

        transition.setDuration(300);

        return transition;
    }

    @Nullable
    @Override
    public Transition getEnterTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        if (isPush) {
            TransitionSet transitionSet = new TransitionSet().setOrdering(TransitionSet.ORDERING_SEQUENTIAL)
                    .addTransition(new Slide(Gravity.BOTTOM))
                    .addTransition(new Fade(Fade.IN));
            transitionSet.setDuration(300);

            return transitionSet;
        } else {
            return new Explode().setDuration(300);
        }

    }
}
