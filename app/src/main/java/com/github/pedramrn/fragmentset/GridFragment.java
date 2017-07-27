package com.github.pedramrn.fragmentset;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;

/**
 * Displays a grid of pictures
 *
 * @author bherbst
 */
@TargetApi(Build.VERSION_CODES.M)
public class GridFragment extends Controller implements KittenClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new KittenGridAdapter(6, this));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    private static final String TAG = GridFragment.class.getSimpleName();

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onKittenClicked(KittenViewHolder holder, int position) {

        int kittenNumber = (position % 6) + 1;

        DetailsFragment fragmentDetails = DetailsFragment.newInstance(kittenNumber);

        String name = "kittenImage" + position;

        getRouter().pushController(RouterTransaction.with(fragmentDetails)
                .pushChangeHandler(new ChangeHandler(holder.image, name))
                .popChangeHandler(new ChangeHandler(holder.image, name)));
    }
}
