package com.example.testingapi


import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.testingapi.api.ViewModel.MainViewModel
import com.example.testingapi.api.compose.data.MockData
import com.example.testingapi.api.compose.view.CountDownView
import com.example.testingapi.api.compose.view.PieList
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
               // MyApp()
                val pies = MockData.tweets
                PieList(pies = pies)
            }
        }

    }
}
// Start building your app here!
@Composable
fun MyApp(
    //viewModel: MainViewModel = viewModel(modelClass = MainViewModel::class.java)
            viewModel: MainViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val getAllUserData = viewModel.pies.observeAsState()
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

//
//@ExperimentalMaterialApi
//@Composable
//fun CallApi(
//    viewModel: MainViewModel = hiltViewModel()
//) {
//    val scope = rememberCoroutineScope()
//    val context = LocalContext.current
//    val scaffoldState = rememberScaffoldState()
//    val getAllUserData = viewModel.pies.observeAsState()
//
//    Surface(
//        color = MaterialTheme.colors.background,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Scaffold(
//            modifier = Modifier.fillMaxSize(),
//            scaffoldState = scaffoldState
//        ) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.LightGray)
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        //.background(Purple500)
//                        .padding(15.dp)
//                ) {
//                    Text(
//                        text = "User Live Data",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                }
//
//                scope.launch {
//                    val result = viewModel.getPies()
//
//                    if (result is Resouce.Success) {
//                        Toast.makeText(context, "Fetching data success!", Toast.LENGTH_SHORT).show()
//                    } else if (result is Resouce.Error) {
//                        Toast.makeText(context, "Error: ${result.message}", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                }
//
//                if (!viewModel.isLoading.value) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        CircularProgressIndicator()
//                    }
//                }
//
//                if (viewModel.isLoading.value) {
//                    if (viewModel.getUserData.value!!.isNotEmpty()) {
//                        LazyColumn(
//                            modifier = Modifier.padding(10.dp)
//                        ) {
//                            items(getAllUserData.value!!.size) { index ->
//                                UserListItem(getAllUserData.value!![index])
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}



