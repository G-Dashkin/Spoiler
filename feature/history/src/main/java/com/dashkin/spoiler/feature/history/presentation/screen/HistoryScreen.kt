package com.dashkin.spoiler.feature.history.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashkin.spoiler.core.ui.theme.SpoilerTheme

private data class HistoryItem(
    val title: String,
    val categoryLabel: String,
    val spoilerLevel: String,
    val date: String,
)

private val sampleHistory = listOf(
    HistoryItem("Inception", "Movie", "Ruthless", "Mar 1, 2026"),
    HistoryItem("The Dark Knight", "Movie", "Hard", "Feb 28, 2026"),
    HistoryItem("1984", "Book", "Ruthless", "Feb 25, 2026"),
    HistoryItem("Dune", "Book", "Mild", "Feb 20, 2026"),
)

@Composable
fun HistoryScreen(
    onBackClicked: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp),
    ) {
        HistoryHeader(onBackClicked = onBackClicked)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(sampleHistory) { item ->
                HistoryItemCard(item = item)
            }
        }
    }
}

@Composable
private fun HistoryHeader(onBackClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "HISTORY",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Black,
                letterSpacing = 4.sp,
                color = Color.White,
            ),
        )
        TextButton(onClick = onBackClicked) {
            Text(
                text = "BACK",
                style = MaterialTheme.typography.labelMedium.copy(
                    letterSpacing = 2.sp,
                    color = Color.White.copy(alpha = 0.4f),
                ),
            )
        }
    }
}

@Composable
private fun HistoryItemCard(item: HistoryItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.1f),
                shape = RoundedCornerShape(8.dp),
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                ),
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CategoryBadge(label = item.categoryLabel)
                SpoilerLevelBadge(level = item.spoilerLevel)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = Color.White.copy(alpha = 0.3f),
                    ),
                )
            }
        }
    }
}

@Composable
private fun CategoryBadge(label: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.2f),
                shape = RoundedCornerShape(4.dp),
            )
            .padding(horizontal = 8.dp, vertical = 3.dp),
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                color = Color.White.copy(alpha = 0.5f),
                letterSpacing = 1.sp,
            ),
        )
    }
}

@Composable
private fun SpoilerLevelBadge(level: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                shape = RoundedCornerShape(4.dp),
            )
            .padding(horizontal = 8.dp, vertical = 3.dp),
    ) {
        Text(
            text = level.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                letterSpacing = 1.sp,
            ),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun HistoryScreenPreview() {
    SpoilerTheme {
        HistoryScreen()
    }
}
