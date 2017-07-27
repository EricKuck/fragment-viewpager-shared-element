package com.github.pedramrn.fragmentset;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.github.pedramrn.fragmentset.databinding.FragmentViewPagerBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPager extends Controller {


    public FragmentViewPager() {
        // Required empty public constructor
    }

    private static final String TAG = FragmentViewPager.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        Log.d(TAG, "onCreateView() called");
        FragmentViewPagerBinding binding = FragmentViewPagerBinding.inflate(inflater, container, false);

        binding.viewPager.setAdapter(new RouterPagerAdapter(this) {
            @Override
            public void configureRouter(@NonNull Router router, int position) {
                switch (position) {
                    case 0:
                        router.setRoot(RouterTransaction.with(new FragmentContainer()));
                        break;
                    case 1:
                        router.setRoot(RouterTransaction.with(new BlankFragment()));
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        return binding.getRoot();
    }

}
