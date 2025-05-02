package com.example.composelab.ui.theme.component.codelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composelab.data.WellnessTask
import com.example.composelab.ui.theme.ComposeLabTheme
import com.example.composelab.ui.theme.Dimens
import com.example.composelab.viewmodel.WellnessViewModel

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskName: String,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    onClose: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            taskName, modifier = modifier
                .weight(1f)
                .padding(start = Dimens.PaddingSmall)
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose, modifier = modifier.size(Dimens.IconSizeMedium)) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close",
            )
        }
    }
}

//@Composable
//fun WellnessTaskItem(
//    modifier: Modifier = Modifier,
//    taskName: String,
//    onClose: () -> Unit
//) {
//    var checkedState by rememberSaveable { mutableStateOf(false) }
//    WellnessTaskItem(
//        taskName = taskName,
//        checked = ,
//        onCheckedChange = { newValue -> checkedState = newValue },
//        onClose = onClose,
//        modifier = modifier
//    )
//}

@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    tasks: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChange: (task: WellnessTask, checked: Boolean) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = tasks,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedChange(task, checked) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    ComposeLabTheme {
        WellnessScreen()
    }
}

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulWaterCounter()
        TaskList(
            modifier = modifier,
            tasks = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedChange = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 140)
@Composable
fun WellnessTaskItemPreview() {
    WellnessTaskItem(taskName = "Task", onClose = {})
}
