
package com.example.android.cardviewAndroid

import android.app.Activity
import android.os.Build
import android.os.Bundle
import com.example.android.cardview.R
import com.example.android.cardviewAndroid.CardViewFragment

/**
 * Launcher Activity for the CardView sample app.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.container, CardViewFragment.newInstance())
                .commit()
        }
    }
}