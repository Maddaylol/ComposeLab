package com.example.composelab.ui.theme.component.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.R
import com.example.composelab.ui.theme.AppTheme
import com.example.composelab.ui.theme.Dimens


@Composable
fun AppCardItem(
    modifier: Modifier = Modifier,
    middleItemFontSize: CardItemFontSize,
    bottomItemFontSize: CardItemFontSize
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {

                AppCardMiddleItem(modifier = Modifier.weight(4f), middleItemFontSize)
                Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
                AppCardBottomItem(modifier = Modifier.weight(1f), bottomItemFontSize)
            }
        }
    }

}

@Composable
fun AppCardBottomItem(modifier: Modifier = Modifier, bottomItemFontSize: CardItemFontSize) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(horizontal = Dimens.PaddingMedium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSmall)
    ) {

        Image(
            painterResource(R.drawable.app_sample_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(vertical = Dimens.PaddingMedium)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .weight(3f)
        ) {
            Text(
                "Greengo", style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.White,
                    fontSize = bottomItemFontSize.title
                )
            )
            Text(
                "Learn language and read comics",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White).copy(
                    fontSize = bottomItemFontSize.body
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {},
                modifier = Modifier.padding(bottom = Dimens.PaddingSmall),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray.copy(alpha = 0.5f),
                    contentColor = Color.White
                )
            ) {
                Text(
                    "Get",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = bottomItemFontSize.body.times(1.1f)
                    )
                )
            }
            Text(
                "In-App Purchase",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White,
                    fontSize = bottomItemFontSize.body * 0.75
                )
            )
        }
    }
}

@Composable
fun AppCardMiddleItem(modifier: Modifier = Modifier, middleItemFontSize: CardItemFontSize) {
    Column(
        modifier = modifier.padding(horizontal = Dimens.PaddingMedium),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            "GET STARTED",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = middleItemFontSize.title
            )
        )
        Text(
            text = "Streak or bust",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
                fontSize = middleItemFontSize.subtitle
            )
        )
        Text(
            text = "Get serious about language learning with Greengo's tough little green bird,.",
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color.White,
                fontSize = middleItemFontSize.body,
                lineHeight = (middleItemFontSize.body * 1.3f)
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun ResponsiveAppCardItemPreview() {
    AppTheme {
        ResponsiveAppCardItem()
    }

}

@Composable
fun ResponsiveAppCardItem(modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = modifier) {
        val boxWithConstraintsScope = this
        val w = maxWidth
        // 动态计算
        val mid = CardFontRatio.Middle
        val bottom = CardFontRatio.Bottom

        val middleSizes = CardItemFontSize(
            title = (w * mid.title).value.sp,
            subtitle = (w * mid.subtitle).value.sp,
            body = (w * mid.body).value.sp
        )
        val bottomSizes = CardItemFontSize(
            title = (w * bottom.title).value.sp,
            subtitle = (w * bottom.subtitle).value.sp,
            body = (w * bottom.body).value.sp
        )

        AppCardItem(
            modifier = Modifier
                .aspectRatio(if (w > 500.dp) 1f / 0.8f else 1f / 1.25f),
            middleItemFontSize = middleSizes,
            bottomItemFontSize = bottomSizes
        )
    }
}

sealed class CardFontRatio(val title: Float, val subtitle: Float, val body: Float) {
    object Middle : CardFontRatio(0.1f, 0.07f, 0.05f)
    object Bottom : CardFontRatio(0.04f, 0.03f, 0.03f)
}

data class CardItemFontSize(val title: TextUnit, val subtitle: TextUnit, val body: TextUnit)