package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.example.composelab.ui.theme.Dimens


@Composable
fun AppCardItem(modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(10.dp)) { //这里我本来用Box，结果那个shapeBox没有
        Box(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(20.dp),
                painter = painterResource(R.drawable.fc2_nature_meditations),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            //the three text
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Bottom
            ) {
                AppCardMiddleItem()
                AppCardBottomItem()
            }


        }
    }

}

@Composable
fun AppCardBottomItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f)
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(horizontal = Dimens.PaddingMedium),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            painterResource(R.drawable.app_sample_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = modifier
                .weight(1f)
                .padding(start = Dimens.PaddingMedium)
        ) {
            Text(
                "Greengo", style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.White
                )
            )
            Text(
                "Learn language fordddsfsfsfsadas",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
            )
        }
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {}) {
                Text("Get")
            }
            Text(
                "Get In-App Purchase",
                style = MaterialTheme.typography.titleSmall.copy(color = Color.White)
            )
        }
    }
}

@Composable
fun AppCardMiddleItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = Dimens.PaddingMedium)) {
        Text(
            "GET STARTED",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            text = "Streak or bust",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
        )
        Text(
            text = "Get serious about language learning with Greengo's tough little green bird.",
            style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
        )
    }
}

@Preview
@Composable
fun AppCardItemPreview() {
    AppCardItem(Modifier.aspectRatio(1f / 1.25f))
}