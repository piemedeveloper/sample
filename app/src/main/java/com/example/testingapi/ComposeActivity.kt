package com.example.testingapi


import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.testingapi.api.compose.view.CountDownView
import com.example.testingapi.databinding.ActivityComposeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {
    lateinit var textView : TextView
    private lateinit var binding: ActivityComposeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityComposeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compose.setContent {
            MyTheme() {
                TransparentStatusBar(windows = window)
                MyApp()
            }
        }

    }
}
// Start building your app here!
@Composable
fun MyApp() {

    Column(
        modifier = Modifier
            .padding(0.dp)
            .background(Color(0xFF3D5AFE))
            .fillMaxWidth()
    ) {

        CountDownView()
    }
}

@Composable
fun TransparentStatusBar(windows: Window) =
    MaterialTheme {

        windows.statusBarColor = MaterialTheme.colors.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        @Suppress("DEPRECATION")
        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }




