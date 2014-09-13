import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.dmurray.medmanagerui.R;

public class BedViewFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    public static BedViewFragment newInstance(int sectionNumber) {
        BedViewFragment fragment = new BedViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public BedViewFragment() {
    }

  /*  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_bed_view, container, false);
        return rootView;

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new GridViewAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(HelloGridView.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }*/ 

  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_bed_view, container, false);
        return rootView;
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((DocNavigation) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}