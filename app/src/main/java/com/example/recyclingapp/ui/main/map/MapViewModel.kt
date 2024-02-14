package com.example.recyclingapp.ui.main.map

import android.animation.ValueAnimator
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.recyclingapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.StyleSpan


class MapViewModel : ViewModel() {

    fun moveLetter(
        googleMap: GoogleMap,
        startMarker: LatLng,
        endMarker: LatLng,
        letterName: String,
        arrivalTime : Long,
        resources: Resources
    ) {
        //Rota koordinatlarının belirlenmesi
        val routeCoordinates: List<LatLng> = mutableListOf(startMarker, endMarker)

        //Mektup ikonun belirlenmesi ve başlangıç noktasına koyulması
        val marker =
            googleMap.addMarker(MarkerOptions().position(routeCoordinates[0]).title(letterName))
        marker!!.setIcon(
            BitmapDescriptorFactory.fromBitmap(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.truck
                ).resize(30, 20, resources)
            )
        )

        //Mektubu kaydırma işlemi
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = arrivalTime
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            val newPosition = LatLng(
                startMarker.latitude + (endMarker.latitude - startMarker.latitude) * value,
                startMarker.longitude + (endMarker.longitude - startMarker.longitude) * value
            )
            marker.position = newPosition
        }
        animator.start()
    }





}
fun Bitmap.resize(widthDp: Int, heightDp: Int, resources: Resources): Bitmap {
    val widthPx = (widthDp * resources.displayMetrics.density).toInt()
    val heightPx = (heightDp * resources.displayMetrics.density).toInt()
    return Bitmap.createScaledBitmap(this, widthPx, heightPx, true)
}

