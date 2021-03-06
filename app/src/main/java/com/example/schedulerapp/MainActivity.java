package com.example.schedulerapp;

import static android.content.ContentValues.TAG;
import static com.example.schedulerapp.ListFragment.mWeekDay;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements CourseDialogFragment.OnCourseEnteredListener{

    //Course Database instance
    CourseDatabase mCourseDb = CourseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set view to main activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get NavHost
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        //Link navHost and Action Bar
        if(navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(navController.getGraph()).build();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate AppBar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.day_menu, menu);
        updateAppBarTitle();
        return true;
    }

    public void updateAppBarTitle() {
        //Set the day of the week in the app bar
        Weekday weekday = mCourseDb.getWeekday(mWeekDay);
        String title = weekday.getDay();
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Move to previous day
        if(item.getItemId() == R.id.previous){
            if(mWeekDay == 1){
                mWeekDay = 5;
            }
            else{
                mWeekDay--;
            }
            finish();
            startActivity(getIntent());
            Log.d(TAG, "onOptionsItemSelected: " + mWeekDay);
            return true;
        }
        //Move to the next day
        else if(item.getItemId() == R.id.next){
            if(mWeekDay == 5){
                mWeekDay = 1;
            }
            else{
                mWeekDay++;
            }
            finish();
            startActivity(getIntent());
            Log.d(TAG, "onOptionsItemSelected: " + mWeekDay);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCourseEntered(String courseText, String profText, String startText, String endText, String locText) {
        //Enter new course from dialog fragment info
        if(courseText.length() > 0 && profText.length() > 0 && startText.length() > 0 && endText.length() > 0 && locText.length() > 0) {
            Course course = new Course(mCourseDb.requestID(), mWeekDay, courseText, profText, startText, endText, locText);
            mCourseDb.addCourse(course);
        }
    }

    public void addCourseClick(View view) {
        //Show dialog when the add button is clicked
        FragmentManager manager = getSupportFragmentManager();
        CourseDialogFragment dialog = new CourseDialogFragment();
        dialog.show(manager, "courseDialog");
    }

    @Override
    public boolean onSupportNavigateUp() {
        //Navigate to the next fragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}