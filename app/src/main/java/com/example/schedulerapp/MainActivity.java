package com.example.schedulerapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements CourseDialogFragment.OnCourseEnteredListener{

    CourseDatabase mCourseDb = CourseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if(navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(navController.getGraph()).build();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.day_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.previous){
            if(ListFragment.mWeekDay == 1){
                ListFragment.mWeekDay = 5;
            }
            else{
                ListFragment.mWeekDay--;
            }
            finish();
            startActivity(getIntent());
            Log.d(TAG, "onOptionsItemSelected: " + ListFragment.mWeekDay);
            return true;
        }
        else if(item.getItemId() == R.id.next){
            if(ListFragment.mWeekDay == 5){
                ListFragment.mWeekDay = 1;
            }
            else{
                ListFragment.mWeekDay++;
            }
            finish();
            startActivity(getIntent());
            Log.d(TAG, "onOptionsItemSelected: " + ListFragment.mWeekDay);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCourseEntered(String courseText, String profText, String startText, String endText, String locText) {
        if(courseText.length() > 0 && profText.length() > 0 && startText.length() > 0 && endText.length() > 0 && locText.length() > 0) {
            Course course = new Course(mCourseDb.requestID(), ListFragment.mWeekDay, courseText, profText, startText, endText, locText);
            mCourseDb.addCourse(course);
        }
    }

    public void addCourseClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        CourseDialogFragment dialog = new CourseDialogFragment();
        dialog.show(manager, "courseDialog");
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}