package com.powwau.lunchbox;


import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LunchOptionsFragment extends Fragment {


    public LunchOptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lunch_options, container, false);
        Button packLunchButton = (Button)rootView.findViewById(R.id.button_pack_lunch);
        LunchOptionsActivity lunchOptionsActivity = (LunchOptionsActivity)getActivity();
        packLunchButton.setOnClickListener(lunchOptionsActivity);
        return rootView;
    }

    public String generateOptionSummary() {
        List<String> options = new ArrayList<>(6);
        int[] ids = {
                R.id.checkbox_kosher, R.id.checkbox_muslim, R.id.checkbox_hindu,
                R.id.checkbox_vegetarian, R.id.checkbox_diabetic, R.id.checkbox_gluten_free
        };
        for(int checkbox_id: ids) {
            View rootView = getView();
            if (rootView != null) {
                CheckBox checkBox = (CheckBox) rootView.findViewById(checkbox_id);
                if (checkBox != null && checkBox.isChecked()) {
                    options.add(checkBox.getText().toString());
                }
            }
        }
        return "Lunch: " + TextUtils.join(", ", options);
    }

    public void enableAuthorizedOptions(Boolean enable){
        int[] ids = {R.id.checkbox_vegetarian, R.id.checkbox_diabetic, R.id.checkbox_gluten_free};
        View rootView = getView();
        if(rootView != null){
            for(int checkboxid : ids){
                CheckBox checkBox = (CheckBox)rootView.findViewById(checkboxid);
                        if(checkBox != null){
                            checkBox.setEnabled(enable);
                        }
            }
        }
    }
}
