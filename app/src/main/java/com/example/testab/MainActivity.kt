package com.example.testab

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.BundleCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout


class MainActivity() : AppCompatActivity() , Parcelable {
    constructor(parcel : Parcel) : this() {
    }

    override fun writeToParcel(parcel : Parcel , flags : Int) {

    }

    override fun describeContents() : Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel : Parcel) : MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size : Int) : Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab = findViewById<TabLayout>(R.id.tabLayout)
        var fragment : Fragment = Fragment()

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout , fragment)
        fragmentTransaction.commit()

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab : TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> fragment = BlueFragment()
                    1 -> fragment = RedFragment()
                    2 -> fragment = YellowFragment()
                    3 -> fragment = to()
                    4 -> fragment = tl()
                }

                val fT = supportFragmentManager.beginTransaction()
                fT.replace(R.id.frameLayout , fragment)
                fT.commit()

            }

            override fun onTabSelected(tab : TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab : TabLayout.Tab?) {

            }

        })
    }}
