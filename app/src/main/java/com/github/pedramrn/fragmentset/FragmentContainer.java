package com.github.pedramrn.fragmentset;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContainer extends Controller {


    public FragmentContainer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);

        getChildRouter((ViewGroup)view.findViewById(R.id.container_fragment))
                    .setRoot(RouterTransaction.with(new GridFragment()));

        return view;
    }

}
