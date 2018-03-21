package nexumcorp.projectnexum;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;


/**
 * Created by SinghA02 on 03/03/2018.
 */

public class search extends Fragment {

    private static final String TAG = "search";
    private static final String BASE_URL = "http://35.226.253.240//elasticsearch/posts/post/";
    private static final int NUM_GRID_COLUMNS = 3;
    private static final int GRID_ITEM_MARGIN = 5;

    //widgets
    private ImageView mFilters;
    private EditText mSearchText;
    private FrameLayout mFrameLayout;


    //vars
    private String mElasticSearchPassword;
    private String mPrefCity;
    private String mPrefStateProv;
    private String mPrefCountry;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        mFilters = (ImageView) view.findViewById(R.id.ic_search);
        mSearchText = (EditText) view.findViewById(R.id.input_search);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mFrameLayout = (FrameLayout) view.findViewById(R.id.container);

        init();

        return view;
    }
    private void init() {
        mFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to filters activity.");
                Intent intent = new Intent(getActivity(), FiltersActivity.class);
                startActivity(intent);
            }
        });
    }


}
