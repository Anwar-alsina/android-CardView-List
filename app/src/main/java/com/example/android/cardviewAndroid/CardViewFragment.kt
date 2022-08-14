
package com.example.android.cardviewAndroid

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.example.android.cardview.R

/**
 * Fragment that demonstrates how to use CardView.
 */
@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
class CardViewFragment : Fragment() {
    /**
     * The CardView widget.
     */
    //@VisibleForTesting
    var mCardView: CardView? = null

    /**
     * SeekBar that changes the cornerRadius attribute for the [.mCardView] widget.
     */
    //@VisibleForTesting
    var mRadiusSeekBar: SeekBar? = null

    /**
     * SeekBar that changes the Elevation attribute for the [.mCardView] widget.
     */
    //@VisibleForTesting
    var mElevationSeekBar: SeekBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCardView = view.findViewById<View>(R.id.cardview) as CardView
        mRadiusSeekBar = view.findViewById<View>(R.id.cardview_radius_seekbar) as SeekBar
        mRadiusSeekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                Log.d(TAG, String.format("SeekBar Radius progress : %d", progress))
                mCardView!!.setRadius(progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //Do nothing
            }
        })
        mElevationSeekBar = view.findViewById<View>(R.id.cardview_elevation_seekbar) as SeekBar
        mElevationSeekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                Log.d(TAG, String.format("SeekBar Elevation progress : %d", progress))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mCardView!!.setElevation(progress.toFloat())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //Do nothing
            }
        })
    }

    companion object {
        private val TAG = CardViewFragment::class.java.simpleName

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment NotificationFragment.
         */
        fun newInstance(): CardViewFragment {
            val fragment = CardViewFragment()
            fragment.retainInstance = true
            return fragment
        }
    }
}