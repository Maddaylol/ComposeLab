package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.Dimens
import com.example.composelab.ui.theme.component.codelab.WellnessScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.padding(all = Dimens.PaddingLarge)) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "DefaultPreviewDark"
)
@Composable
fun DefaultPreviewDark() {
    AppTheme(dynamicColor = false, darkTheme = true) {
        Surface(modifier = Modifier) {
            WellnessScreen()
        }
    }
}
@Preview(
    showBackground = true,
    name = "DefaultPreviewLight"
)
@Composable
fun DefaultPreviewContrast() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        Surface(modifier = Modifier) {
            WellnessScreen()
        }
    }
}