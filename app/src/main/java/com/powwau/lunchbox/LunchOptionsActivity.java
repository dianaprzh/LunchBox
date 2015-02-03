package com.powwau.lunchbox;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LunchOptionsActivity extends Activity implements View.OnClickListener {

    final static Integer REQUEST_CODE = 0;
    private LunchOptionsFragment mLunchOptionsFragment;
    Boolean mLoggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachOptionsFragment();
    }

    private void attachOptionsFragment() {
        mLunchOptionsFragment = new LunchOptionsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.options, mLunchOptionsFragment).
                commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                mLoggedIn = true;
            }else{
                mLoggedIn = false;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLunchOptionsFragment.enableAuthorizedOptions(mLoggedIn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Boolean handled = false;

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_login:
                launchLogin();
                handled = true;
                break;
            case R.id.action_settings:
                handled = true;
                break;
        }

        if(!handled){
            handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    private void launchLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
    @Override
    public void onClick(View v) {
        if (findViewById(R.id.lunchbox) != null) {
            showSummaryInFragment();
        } else {
            showSummaryInActivity();
        }
    }

    private void showSummaryInFragment() {
        LunchSummaryFragment lunchSummaryFragment = new LunchSummaryFragment();
        passArgumentsToLunchSummaryFragment(lunchSummaryFragment);
        performLunchSummaryFragmentTransaction(lunchSummaryFragment);
    }


    private void passArgumentsToLunchSummaryFragment(LunchSummaryFragment lunchSummaryFragment) {
        String summary = mLunchOptionsFragment.generateOptionSummary();
        Bundle bundle = new Bundle();
        bundle.putString(LunchSummaryFragment.SUMMARY_TEXT, summary);
        lunchSummaryFragment.setArguments(bundle);
    }

    private void performLunchSummaryFragmentTransaction(LunchSummaryFragment lunchSummaryFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.lunchbox, lunchSummaryFragment).
                commit();
    }

    private void showSummaryInActivity() {
        Intent intent = new Intent(this, LunchSummaryActivity.class);
        String summary = mLunchOptionsFragment.generateOptionSummary();
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        startActivity(intent);
    }


}
