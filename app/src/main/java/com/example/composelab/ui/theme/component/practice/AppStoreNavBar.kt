package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.composelab.ui.theme.AppTheme


@Composable
fun AppStoreNavBar(
    modifier: Modifier = Modifier,
    selectedItem: Int = 0,
    items: List<String> = listOf("Today", "Games", "Apps", "Home", "Me"),
    onSelected: @Composable (Int) -> Color,
    onClick: (Int) -> Unit,
    icons: List<ImageVector>
) {
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem (
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = item,
                        tint = onSelected(index)
                    )
                },
                label = {
                    Text(item, color = onSelected(index))
                },
                selected = selectedItem == index,
                onClick = { onClick(index) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavBarItem(modifier: Modifier = Modifier) {
    AppTheme {
        Row {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = true,
                onClick = {}
            )
        }
    }

}


class NavBarItemsProvider : PreviewParameterProvider<List<String>> {
    override val values = sequenceOf(listOf("Today", "Games", "Apps", "Home", "Me"))
}

val getIcons: List<ImageVector> = listOf(Icons.Filled.DateRange, Icons.Filled.Build, Icons.Filled.Favorite, Icons.Filled.Home, Icons.Filled.Search)


@Preview
@Composable
fun AppStoreNavBarPreview(@PreviewParameter(provider = NavBarItemsProvider::class) items: List<String>) {
    var currentItem by remember { mutableIntStateOf(1) }
    AppTheme {
        AppStoreNavBar(
            items = items,
            selectedItem = currentItem,
            onClick = { selectedItem -> currentItem = selectedItem },
            onSelected = { index ->  onSelected(index, currentItem)},
            icons = getIcons
        )
    }
}

@Composable
fun onSelected(index: Int, selectedItem: Int): Color {
    println("index: $index, selectedItem: $selectedItem")
    return if (selectedItem == index) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }
}
