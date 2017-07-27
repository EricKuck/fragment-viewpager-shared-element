package com.github.pedramrn.fragmentset;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bluelinelabs.conductor.Controller;

/**
 * Display details for a given kitten
 *
 * @author bherbst
 */
public class DetailsFragment extends Controller {
    private static final String ARG_KITTEN_NUMBER = "argKittenNumber";

    /**
     * Create a new DetailsFragment
     * @param kittenNumber The number (between 1 and 6) of the kitten to display
     */
    public static DetailsFragment newInstance(@IntRange(from = 1, to = 6) int kittenNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_KITTEN_NUMBER, kittenNumber);

        DetailsFragment fragment = new DetailsFragment(args);

        return fragment;
    }

    public DetailsFragment(@Nullable Bundle args) {
        super(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.image);

        Bundle args = getArgs();
        int kittenNumber = args.containsKey(ARG_KITTEN_NUMBER) ? args.getInt(ARG_KITTEN_NUMBER) : 1;
        String transitionName = "kittenImage" + (kittenNumber - 1);
        Log.e(TAG, transitionName);
        switch (kittenNumber) {
            case 1:
                image.setImageResource(R.drawable.placekitten_1);
                break;
            case 2:
                image.setImageResource(R.drawable.placekitten_2);
                break;
            case 3:
                image.setImageResource(R.drawable.placekitten_3);
                break;
            case 4:
                image.setImageResource(R.drawable.placekitten_4);
                break;
            case 5:
                image.setImageResource(R.drawable.placekitten_5);
                break;
            case 6:
                image.setImageResource(R.drawable.placekitten_6);
                break;
        }
        image.setTransitionName(transitionName);

        return view;
    }

    private static final String TAG = DetailsFragment.class.getSimpleName();
}
