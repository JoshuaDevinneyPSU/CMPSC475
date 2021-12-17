package com.example.schedulerapp;

import static com.example.schedulerapp.DetailFragment.mCourseID;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @SuppressLint("MissingPermission")
        @Override
        public void onMapReady(GoogleMap googleMap) {
            //Set map to hybrid view and enable gps location
            googleMap.setMapType(4);
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            //Create markers for Behrend school buildings and the center of campus
            LatLng JunkerBld = new LatLng(42.12034657919094, -79.97780244960862);
            LatLng AmicBld = new LatLng(42.1172027162037, -79.97663030724632);
            LatLng OBSBld = new LatLng(42.119059255367574, -79.9873613581717);
            LatLng NickBld = new LatLng(42.11972673423577, -79.98750272542806);
            LatLng BurkeBld = new LatLng(42.11892121674618, -79.9798642820508);
            LatLng KochelBld = new LatLng(42.120180610165626, -79.98162257755125);
            LatLng behrend = new LatLng(42.1195, -79.9826);

            //If statement to decide which marker is shown based on course location
            if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("Nick")){
                googleMap.addMarker(new MarkerOptions().position(NickBld).title("Nick"));
            }
            else if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("Burke")){
                googleMap.addMarker(new MarkerOptions().position(BurkeBld).title("Burke"));
            }
            else if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("Kochel")){
                googleMap.addMarker(new MarkerOptions().position(KochelBld).title("Kochel"));
            }
            else if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("Junker")){
                googleMap.addMarker(new MarkerOptions().position(JunkerBld).title("Junker"));
            }
            else if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("AMIC")){
                googleMap.addMarker(new MarkerOptions().position(AmicBld).title("AMIC"));
            }
            else if(CourseDatabase.getInstance().getCourses(ListFragment.mWeekDay).get(mCourseID-1).getmLocation().contains("OBS")){
                googleMap.addMarker(new MarkerOptions().position(OBSBld).title("OBS"));
            }

            //Center camera on behrend and zoom in to show most of campus
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(behrend, 16));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }


}