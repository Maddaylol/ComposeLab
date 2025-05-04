package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelab.ui.theme.AppTheme
import com.example.composelab.ui.theme.Dimens
import com.example.composelab.ui.theme.component.practice.AppIndexCardMainPart
import com.example.composelab.ui.theme.component.practice.AppStoreNavBar
import com.example.composelab.ui.theme.component.practice.getIcons
import com.example.composelab.ui.theme.component.practice.onSelected

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppStoreNavBarScreen(modifier = Modifier.fillMaxSize())
        }
    }
}


@Preview
@Composable
fun AppStoreNavBarScreen(modifier: Modifier = Modifier) {
    AppTheme {
        var currentItem by remember { mutableIntStateOf(1) }
        val items = listOf("Today", "Games", "Apps", "Home", "Me") // 底部栏标签
        val icons = getIcons
        Scaffold(
            modifier = modifier,
            bottomBar = {
                AppStoreNavBar(
                    items = items,
                    selectedItem = currentItem,
                    onClick = { currentItem = it },
                    onSelected = { index -> onSelected(index, currentItem)},
                    icons = getIcons
                )
            }
        ){ contentPadding ->
            //Text(text = "Hello World!", modifier = Modifier.padding(contentPadding))
            //AppIndexCardMainPart(modifier.padding(it))
            Column(
                modifier = Modifier.padding(contentPadding).padding(Dimens.PaddingMedium),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)
            ) {
                AppIndexCardMainPart(modifier = Modifier.aspectRatio(1f/1.25f))
                AppIndexCardMainPart(modifier = modifier.aspectRatio(1f/0.65f))
            }
        }

    }

}