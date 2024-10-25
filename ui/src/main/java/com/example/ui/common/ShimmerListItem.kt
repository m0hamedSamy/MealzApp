package com.example.ui.common

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerListItem(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit
) {
    if (isLoading)
        ShimmerItem(modifier)
    else
        contentAfterLoading()
}

@Composable
private fun ShimmerItem(
    modifier: Modifier = Modifier,
    imgShape: Shape = CircleShape
) {
    Row(modifier = modifier.padding(12.dp)){
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(imgShape)
                .shimmerEffect()
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(20.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .shimmerEffect()
            )
        }
    }
}

private fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ),
        label = "OffsetXAnimation"
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFDEDEDE),
                Color(0xFFB4B4B4),
                Color(0xFFDEDEDE),
            ),
            start = Offset(x = startOffsetX, y = 0f),
            end = Offset(x = startOffsetX + size.width.toFloat(), y = size.height.toFloat())
        )
    )
    .onGloballyPositioned {
        size = it.size
    }
}