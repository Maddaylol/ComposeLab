package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelab.R

@Composable
fun AppItemCardFrame(modifier: Modifier = Modifier, backgroundImg: Int) {
    Box(
        modifier = modifier
            .border(
                width = 6.dp,
                color = Color.Green.copy(green = 0.5f),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(backgroundImg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "EDITOR'S CHOICE",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))// Add padding around the frame
                .border( // Add a border to create the frame effect
                    width = 1.dp,
                    color = Color.Green.copy(alpha = 0.5f, green = 0.5f),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    Color.Green.copy(green = 0.5f, blue = 0.2f),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomCenter)
                .blur(15.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 250)
@Composable
fun PreviewFramedCardExample() {
    AppItemCardFrame(backgroundImg = R.drawable.fc2_nature_meditations)
}

