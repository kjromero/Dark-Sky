package sky.dark.kenny.darksky;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import sky.dark.kenny.darksky.callBack.GetCallBack;
import sky.dark.kenny.darksky.callBack.ServiceCall;
import sky.dark.kenny.darksky.model.Currently;
import sky.dark.kenny.darksky.model.ResponseData;

public class MainActivity extends AppCompatActivity implements GetCallBack , LocationListener{

    private static final int ACCESS_FINE_LOCATION = 0;
    private TextView txtData;
    private TextView txtTemperature;
    private TextView txtSummary;
    private TextView txtSpeedWind;
    private TextView txtPorcent;


    private LocationManager locationManager;

    private Location currentLocation;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtData = (TextView)findViewById(R.id.txt_data);
        txtTemperature = (TextView)findViewById(R.id.txt_temperature);
        txtSummary = (TextView)findViewById(R.id.txt_summary);
        txtSpeedWind = (TextView)findViewById(R.id.txt_sppedwind);
        txtPorcent = (TextView)findViewById(R.id.txt_porcent);



        ServiceCall.getData("4.710989","-74.072092", this);


        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions();

        }else{

            final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

            if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
                buildAlertMessageNoGps();
            }else {

                //Toast.makeText(getApplicationContext(), String.valueOf(currentLocation.getLatitude()) +  String.valueOf(currentLocation.getLongitude()),Toast.LENGTH_LONG).show();
            }

        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    }



    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }


    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                0);
    }



    @Override
    public void getCallback(ResponseData body, boolean success) {
        if (success){

            Currently currently = body.getCurrently();
            txtData.setText(body.getTimezone());
            txtTemperature.setText(currently.getTemperature() + "ª");
            txtSummary.setText(currently.getSummary());
            txtSpeedWind.setText(currently.getWindSpeed() + "Mph");
            txtPorcent.setText(currently.getUvIndex()+ "%");
        }else{
            txtData.setText("ERROR 8");
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        currentLocation = location;
        //LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        locationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ACCESS_FINE_LOCATION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    MainActivity.this.finish();
                }
                return;
            }

        }
    }

}
