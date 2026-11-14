package com.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    private val TAG = "LIFECYCLE_TEST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() вызван")
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Смотри логи в Logcat (фильтр: LIFECYCLE_TEST)")
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() вызван")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() вызван")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() вызван")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() вызван")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() вызван")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() вызван")
    }
}