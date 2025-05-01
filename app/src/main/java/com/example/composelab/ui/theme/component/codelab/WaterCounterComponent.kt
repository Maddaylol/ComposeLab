package com.example.composelab.ui.theme.component.codelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.Dimens

@Composable
fun WaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        if (count > 0) {
            Text(
                text = "You had $count glasses.",
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSmall)
        ) {
            Button(
                onClick = onIncrement,
                modifier = modifier.weight(1f),
                enabled = count < 10,

                ) {
                Text("Drink")
            }
            Button(onClick = onClear, modifier = modifier.weight(1f)) {
                Text("Clear")
            }
        }

    }
}

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    WaterCounter(count, { count++ }, { count = 0 }, modifier)

}

@Composable
fun TaskScreen(modifier: Modifier = Modifier) {
    var showTask by rememberSaveable { mutableStateOf(true) }
    ComposeLabTheme {
        Column(
            modifier = modifier.padding(Dimens.PaddingSmall),
        ) {
            if (showTask) WellnessTaskItem(
                onClose = { showTask = false },
                taskName = "Have you taken your 15 minute walk today?"
            )
            StatefulWaterCounter()
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    ComposeLabTheme {
        TaskScreen()
    }
}
