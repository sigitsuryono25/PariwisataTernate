package com.surelabs.pariwisataternate.ui.lokasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.surelabs.pariwisataternate.R

class LokasiWisata : Fragment(), OnMapReadyCallback {
    private var mGoogleMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lokasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mp = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        this.mGoogleMap = p0

        val bentengTolukko = LatLng(0.8139152, 127.387834)
        val markerbentengTolukko =
            mGoogleMap?.addMarker(MarkerOptions().position(bentengTolukko).title("Benteng Tolukko"))
        markerbentengTolukko?.showInfoWindow()

        val pantaiBobaneIci = LatLng(0.7947089, 127.2940025)
        val markerpantaiBobaneIci =
            mGoogleMap?.addMarker(MarkerOptions().position(pantaiBobaneIci).title("Pantai Bobane Ici"))
        markerpantaiBobaneIci?.showInfoWindow()

        val pantaiJikomalamo = LatLng(0.8626167, 127.3200885)
        val markerpantaiJikomalamo =
            mGoogleMap?.addMarker(MarkerOptions().position(pantaiJikomalamo).title("Pantai Jikomalamo"))
        markerpantaiJikomalamo?.showInfoWindow()

        //
        val bound = LatLngBounds(pantaiBobaneIci, bentengTolukko)
        mGoogleMap?.setPadding(200, 0, 200, 0)
        mGoogleMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(bound, 17))

        mGoogleMap?.setOnInfoWindowClickListener { marker ->
            if (marker == markerpantaiJikomalamo) {
                marker.showInfoWindow()
                Toast.makeText(activity, "Pantai Jikomalamo", Toast.LENGTH_SHORT).show()
            }else if (marker == markerbentengTolukko) {
                marker.showInfoWindow()
                Toast.makeText(activity, "Benteng Tolukko", Toast.LENGTH_SHORT).show()
            }else if (marker == markerpantaiBobaneIci) {
                marker.showInfoWindow()
                Toast.makeText(activity, "Pantai Bobane Ici", Toast.LENGTH_SHORT).show()
            }
        }
    }

}