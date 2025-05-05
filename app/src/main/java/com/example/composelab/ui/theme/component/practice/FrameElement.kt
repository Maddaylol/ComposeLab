package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelab.R

@Composable
fun AppItemCardFrame(modifier: Modifier = Modifier, backgroundImg: Int) {
    // Load the background once
    val bitmap = ImageBitmap.imageResource(id = backgroundImg)

    Box(
        modifier = modifier
            .border(
                width = 6.dp,
                color = Color.Green.copy(green = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Image(
            painter = painterResource(backgroundImg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
                .fillMaxWidth()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Green),
                        startY = size.height / 3f,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient)
                    }
                }
        )
        Text(
            text = "EDITOR'S CHOICE",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .border(
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

    }
}

@Preview(widthDp = 400, heightDp = 550)
@Composable
fun PreviewFramedCardExample() {
    AppItemCardFrame(backgroundImg = R.drawable.fc2_nature_meditations)
}
