package com.powwau.lunchbox;


import android.content.Intent;
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
        Intent intent = getActivity().getIntent();
        String summary = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (summary != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.text_view_summary);
            textView.setText(summary);
        }
    }

}
