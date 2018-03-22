package nexumcorp.projectnexum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by blras on 11/03/2018.
 */

public class add_business extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.add_business,container,false);
        return view;
    }
    public void viewPost(String postid){
        viewpost fragment = new viewpost();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        Bundle args= new Bundle();
        args.putString(getString(R.string.arg_post_id),postid);
        fragment.setArguments(args);

        transaction.replace(R.id.container,fragment,getString(R.string.fragment_view_post));
        transaction.addToBackStack(getString(R.string.fragment_view_post));
        transaction.commit();

        mFrameLayout.setVisibility(View.VISIBLE);
    }
}
