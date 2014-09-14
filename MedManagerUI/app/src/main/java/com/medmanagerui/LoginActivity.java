package com.medmanagerui;


        import android.app.Activity;
        import android.app.Fragment;
        import android.app.FragmentManager;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

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

public class LoginActivity extends Activity {

    private EditText  username=null;
    private EditText  password=null;
    private TextView attempts;
    //ListViewAdapter lstAdapter = new ListViewAdapter(ctx, mgr);
    private Button login;

    private Context context;

    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
        context = this;

        final ProgressDialog dialog = ProgressDialog.show(context, "",
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
    }

    public void login(View view){
        if(username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(), "Redirecting...",
                    Toast.LENGTH_SHORT).show();

            Intent myIntent = new Intent(context, MainActivity.class);
            LoginActivity.this.startActivity(myIntent);

        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",
                    Toast.LENGTH_SHORT).show();
            attempts.setBackgroundColor(Color.RED);
            counter--;
            attempts.setText(Integer.toString(counter));
            if(counter==0){
                login.setEnabled(false);
            }

        }

    }
 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.layout.activity_main, menu);
        return true;
    }*/

}