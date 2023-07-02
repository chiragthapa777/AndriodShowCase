package com.example.andriodshowcase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.andriodshowcase.activities.layout.AbsoluteLayoutExample;
import com.example.andriodshowcase.activities.layout.ConstraintLayoutExample;
import com.example.andriodshowcase.activities.layout.LinearLayoutExample;
import com.example.andriodshowcase.activities.layout.RelativeLayoutExample;
import com.example.andriodshowcase.activities.layout.TableLayoutExample;
import com.example.andriodshowcase.activities.widgets.StudentForm;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        navigationView.setNavigationItemSelectedListener(this);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.linear_layout:{
                Intent intent = new Intent(this, LinearLayoutExample.class);
                startActivity(intent);
                break;
            }
            case R.id.relative_layout:{
                Intent intent = new Intent(this, RelativeLayoutExample.class);
                startActivity(intent);
                break;
            }
            case R.id.table_layout:{
                Intent intent = new Intent(this, TableLayoutExample.class);
                startActivity(intent);
                break;
            }
            case R.id.absolute_layout:{
                Intent intent = new Intent(this, AbsoluteLayoutExample.class);
                startActivity(intent);
                break;
            }
            case R.id.constraint_layout:{
                Intent intent = new Intent(this, ConstraintLayoutExample.class);
                startActivity(intent);
                break;
            }
            case R.id.student_form:{
                Intent intent = new Intent(this, StudentForm.class);
                startActivity(intent);
                break;
            }
        }
        return true;
    }
}