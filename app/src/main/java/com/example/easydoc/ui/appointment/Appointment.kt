package com.example.easydoc.ui.appointment

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.easydoc.ui.main.SectionsPagerAdapter
import com.example.easydoc.databinding.ActivityAppointmentBinding
import androidx.appcompat.widget.Toolbar
import com.example.easydoc.R

class Appointment : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentBinding
    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: Toolbar    // creating object of ToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the references of the declared objects above
        pager = findViewById(R.id.appointmentView_pager)
        tab = findViewById(R.id.appointmentTabs)
        bar = findViewById(R.id.toolbar)

        // To make our toolbar show the application
        // we need to give it to the ActionBar
        setSupportActionBar(bar)

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(pendingAppointment(), "Pending Appointments")
        adapter.addFragment(currentAppointment(), "Current Appointments")
        adapter.addFragment(previousAppointment(), "Previous Appointments")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)
    }
}
}