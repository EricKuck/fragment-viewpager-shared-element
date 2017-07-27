package com.github.pedramrn.fragmentset;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.github.pedramrn.fragmentset.databinding.MainActivityBinding;

/**
 * @author bherbst
 */
public class MainActivity extends AppCompatActivity {

    Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        router = Conductor.attachRouter(this, (ViewGroup)findViewById(R.id.container), savedInstanceState);
        router.setRoot(RouterTransaction.with(new FragmentViewPager()));
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
}
