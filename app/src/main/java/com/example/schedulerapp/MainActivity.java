package com.example.schedulerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

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
    public void onCourseEntered(String courseText, String profText, String startText, String endText, String locText) {
        if(courseText.length() > 0 && profText.length() > 0 && startText.length() > 0 && endText.length() > 0 && locText.length() > 0) {
            Course course = new Course(2, 1, courseText, profText, startText, endText, locText);
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