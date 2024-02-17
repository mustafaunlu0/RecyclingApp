package com.example.recyclingapp.ui.main.map

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.recyclingapp.R
import com.example.recyclingapp.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import org.checkerframework.checker.units.qual.s

class MapsFragment : Fragment() {

    private val viewModel : MapViewModel by viewModels()

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private  lateinit var binding : FragmentMapsBinding

    private lateinit var sharedPreferences: SharedPreferences


    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map))


        val center = LatLng(41.014390, 28.976524)
        googleMap.addMarker(MarkerOptions().position(center).title(" Recycling Center").icon(
            BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.center
                ).resize(30, 30, resources)
            )
        ))

        val center2 = LatLng(40.957275,  29.085458)
        googleMap.addMarker(MarkerOptions().position(center2).title("*Recycling Center").icon(
            BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.center
                ).resize(30, 30, resources)
            )
        ))

        val myUser = LatLng(40.9948035, 29.0587282)
        googleMap.addMarker(MarkerOptions().position(myUser).title("Mustafa").icon(
            BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.my_user
                ).resize(20, 20, resources)
            )
        ))
        viewModel.moveLetter(
            googleMap,
            LatLng(center2.latitude, center2.longitude),
            LatLng(40.9948035, 29.0587282),
            "Mustafa's Truck",
            120000,
            resources
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myUser,10f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireContext().getSharedPreferences(
            requireContext().packageName,
            Context.MODE_PRIVATE
        )
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {

                fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
                //println("Location: ${fusedLocationClient.lastLocation.result.latitude}")

            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) -> {

            }
            else -> {
                // You can directly ask for the permission.
                requestPermissions(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    200)
            }
        }
        val time = sharedPreferences.getString("time","null")

        if( !time.isNullOrEmpty() && time!= "null"){
            println("time: $time")
            binding.fab.visibility = View.GONE
            binding.energyCardview.visibility = View.VISIBLE
            binding.time.text = time
        }else{
            binding.fab.visibility = View.VISIBLE
            binding.energyCardview.visibility = View.GONE
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            200 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the feature requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }


}