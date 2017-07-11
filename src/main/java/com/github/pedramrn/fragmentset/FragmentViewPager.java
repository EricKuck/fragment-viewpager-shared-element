package com.github.pedramrn.fragmentset;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.pedramrn.fragmentset.databinding.FragmentViewPagerBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPager extends Fragment {


    public FragmentViewPager() {
        // Required empty public constructor
    }

    private static final String TAG = FragmentViewPager.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called");
        FragmentViewPagerBinding binding = FragmentViewPagerBinding.inflate(inflater, container, false);
        binding.viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new FragmentContainer();
                    case 1:
                        return new BlankFragment();
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
