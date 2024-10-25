package com.example.ui.categories

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.ui.common.ShimmerListItem

@Composable
fun CategoriesScreen(
    state: CategoriesUIState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(20.dp),
    ) {
        items(
            items = state.categories.ifEmpty { Array(20){ CategoryUIModel() }.toList() },
            key = if(state.categories.isEmpty()) null else { category -> category.id },
        ) { category ->
            CategoryItem(
                isLoading = state.isLoading,
                category = category
            )
        }
    }
}

@Composable
private fun CategoryItem(
    isLoading: Boolean,
    category: CategoryUIModel
) {
    var arrowClicked by remember { mutableStateOf(false) }
    val cardHeight by animateDpAsState(
        targetValue = if (arrowClicked) 150.dp else 100.dp,
        animationSpec = tween(
            delayMillis = 100
        )
    )

    OutlinedCard (
        modifier = Modifier.height(cardHeight),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.outlinedCardElevation(3.dp)
    ) {
        ShimmerListItem(
            isLoading = isLoading
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    modifier = Modifier.size(100.dp),
                    model = category.imgUrl,
                    contentDescription = "Meal",
                    contentScale = ContentScale.Inside
                )
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = if (arrowClicked) Alignment.Bottom else Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = category.description,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = if (arrowClicked) 50 else 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { arrowClicked = !arrowClicked },
                        imageVector = if (arrowClicked) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                }

            }
        }
    }
}