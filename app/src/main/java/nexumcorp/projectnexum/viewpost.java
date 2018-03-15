package nexumcorp.projectnexum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SinghA02 on 03/03/2018.
 */

public class viewpost extends Fragment {
    private static final String TAG= "ViewPost";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_post,container,false);
        return view;
    }
}
