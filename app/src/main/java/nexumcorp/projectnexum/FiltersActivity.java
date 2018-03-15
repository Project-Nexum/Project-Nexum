package nexumcorp.projectnexum;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by User on 10/31/2017.
 */

public class FiltersActivity extends AppCompatActivity {

    private static final String TAG = "FiltersActivity";

    //widgets
    private Button mSave;
    private EditText mCity, mStateProvince, mCountry;
    private ImageView mBackArrow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        mSave = (Button) findViewById(R.id.btnSave);
        mCity = (EditText) findViewById(R.id.input_city);
        mStateProvince = (EditText) findViewById(R.id.input_state_province);
        mCountry = (EditText) findViewById(R.id.input_country);
        mBackArrow = (ImageView) findViewById(R.id.backArrow);


    }


}
















