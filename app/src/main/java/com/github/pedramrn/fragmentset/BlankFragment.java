package com.github.pedramrn.fragmentset;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Controller {


    public BlankFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
