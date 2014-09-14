package com.medmanagerui;

import android.app.Activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.medmanagerui.fragments.BedViewFragment;
import com.medmanagerui.models.Bed;
import com.medmanagerui.models.DataProvider;
import com.medmanagerui.models.Patient;
import com.medmanagerui.models.Staff;
import com.medmanagerui.models.Ward;
import com.medmanagerui.networking.NetworkingService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private Context ctx;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        new NetworkingService().allPatients(new Callback<List<Patient>>() {
            @Override
            public void success(List<Patient> patients, Response response) {
                DataProvider.patientList = patients;
                dialog.hide();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });

        new NetworkingService().allWards(new Callback<List<Ward>>() {
            @Override
            public void success(List<Ward> wards, Response response) {
                DataProvider.wardList = wards;
                dialog.hide();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });

        new NetworkingService().allBeds(new Callback<List<Bed>>() {
            @Override
            public void success(List<Bed> beds, Response response) {
                DataProvider.bedList = beds;
                dialog.hide();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });

        new NetworkingService().allStaff(new Callback<List<Staff>>() {
            @Override
            public void success(List<Staff> staff, Response response) {
                DataProvider.staffList = staff;
                dialog.hide();
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx=this;
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        switch (position){
        case 0:
        fragmentManager.beginTransaction()
                .replace(R.id.container, InfoPatientFragment.newInstance(ctx))
                .commit();
        break;

        case 1:
        fragmentManager.beginTransaction()
        .replace(R.id.container, BedViewFragment.newInstance(ctx))
        .commit();
        break;

        case 2:
        fragmentManager.beginTransaction()
        .replace(R.id.container, InfoPatientFragment.newInstance(ctx))
        .commit();
        break;
    }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.title_Nurse);
                break;
            case 1:
                mTitle = getString(R.string.title_Doctor);
                break;
            case 2:
                mTitle = getString(R.string.title_TestInfo);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
