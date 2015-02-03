package com.powwau.lunchbox;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText mEditTextUsername;
    EditText mEditTexPassword;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        mEditTextUsername = (EditText)rootView.findViewById(R.id.edit_text_username);
        mEditTexPassword = (EditText)rootView.findViewById(R.id.edit_text_password);
        Button button = (Button)rootView.findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                if(mEditTextUsername.getText().toString().equals("bond@mi6.go.uk") &&
                        mEditTexPassword.getText().toString().equals("s3cr3t")){
                            activity.setResult(Activity.RESULT_OK);
                }
                activity.finish();
            }
        });
        return rootView;
    }

}
