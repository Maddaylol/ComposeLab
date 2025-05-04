package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R
import com.example.composelab.ui.theme.AppTheme
import com.example.composelab.ui.theme.bodyFontFamily

@Composable
fun AppIndexCardMainPart(
    modifier: Modifier = Modifier,
    backgroundImage: Int = R.drawable.app_sample_background,
) {
    Card(
        modifier.fillMaxSize()
    ) {
        Box(modifier = modifier) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(20.dp),
                painter = painterResource(backgroundImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(all = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "NEW GAME",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp
                    ),
                )
                Text(
                    text = "Go 3 For 3 in Pokemon TCGsdasdadadadadsadsdasdadadad",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = bodyFontFamily,
                        fontSize = 30.sp
                    ),
                )
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Extreme Games rule in Neo Tokyo",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = bodyFontFamily,
                        fontSize = 20.sp
                    ),
                )
                AppIndexCardBottomItem()
            }

        }
    }
}

@Composable
fun AppIndexCardBottomItem(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image (
                painterResource(R.drawable.fc2_nature_meditations),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
            Column(

            ) {
                Text(
                    text = "TRIBE NINE",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Brutal action RPG", style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {}
            ) {
                Text("Get")
            }
            Text("In-App Purchase"
                , color = Color.White
                , style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppIndexCardBottomItemPreview() {
    AppTheme {
        AppIndexCardBottomItem(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun AppIndexCardBottomPreview() {
    AppTheme {
        AppIndexCardMainPart(Modifier.aspectRatio(1f/1.25f))
    }
}