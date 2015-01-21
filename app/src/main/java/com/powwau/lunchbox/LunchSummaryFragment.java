package com.powwau.lunchbox;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LunchSummaryFragment extends Fragment {

    public static final String SUMMARY_TEXT = "SUMMARY_TEXT";

    public LunchSummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lunch_summary, container, false);
        displaySummary(rootView);
        return rootView;
    }

    private void displaySummary(View rootView) {
        if (getArguments().containsKey(SUMMARY_TEXT)) {
            String summary = getArguments().getString(SUMMARY_TEXT);
            TextView textView = (TextView) rootView.findViewById(R.id.text_view_summary);
            textView.setText(summary);
        }
    }

}
