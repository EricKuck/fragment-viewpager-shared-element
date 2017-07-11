package com.github.pedramrn.fragmentset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.pedramrn.fragmentset.databinding.MainActivityBinding;

/**
 * @author bherbst
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FragmentViewPager())
                .addToBackStack(null)
                .commit();

    }
}
