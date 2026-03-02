package com.dashkin.spoiler.feature.result.presentation.screen

import android.content.Intent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashkin.spoiler.core.ui.theme.SpoilerTheme

private const val PLACEHOLDER_SPOILER_TEXT =
    "Lost centers on the survivors of Oceanic Flight 815, which crashes on a " +
    "mysterious island in the South Pacific. Over six seasons, the survivors " +
    "uncover the island's secrets: an ancient man named Jacob has been protecting " +
    "a glowing \"Heart of the Island\" — the source of all life — and has been " +
    "summoning candidates there for centuries to find a worthy successor.\n\n" +
    "The island is threatened by the Man in Black (MIB), Jacob's twin brother, " +
    "who wants to destroy the Heart and escape. He takes the form of the deceased " +
    "John Locke and manipulates Ben Linus into killing Jacob.\n\n" +
    "In Season 6, Jack Shephard is chosen as Jacob's successor. The MIB tries to " +
    "use Desmond Hume's electromagnetic immunity to uncork the Heart and destroy " +
    "the island. Desmond does uncork it — temporarily stripping both Jack and the " +
    "MIB of their powers. Jack kills the now-mortal MIB, then sacrifices himself " +
    "by re-inserting the stone cork. As he dies in the bamboo field where he first " +
    "woke up, he watches Ajira Flight 316 escape with Sawyer, Kate, Claire, " +
    "Lapidus, Richard, and Miles aboard. Hurley becomes the new island guardian " +
    "with Ben as his advisor.\n\n" +
    "The Season 6 flash-sideways timeline is revealed in the finale to be a " +
    "collective purgatory — a liminal space unconsciously created by the survivors " +
    "after their deaths so they could find each other one last time before moving " +
    "on. The island events were entirely real; the survivors died at different " +
    "points in their lives (many, like Kate and Sawyer, lived long after escaping " +
    "the island). In the church, bathed in white light, all of the main characters " +
    "reunite and let go together.\n\n" +
    "The series closes with Jack's eye shutting — a direct mirror of the pilot's " +
    "opening shot of his eye opening in the same bamboo grove."

@Composable
fun ResultScreen(
    title: String,
    categoryLabel: String?,
    onNewSpoilerClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                ResultHeader(title = title, categoryLabel = categoryLabel)
                Spacer(modifier = Modifier.height(32.dp))
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                    thickness = 1.dp,
                )
                Spacer(modifier = Modifier.height(24.dp))
                SpoilerBody(text = PLACEHOLDER_SPOILER_TEXT)
                Spacer(modifier = Modifier.height(32.dp))
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline,
                thickness = 1.dp,
            )
            BottomActions(
                onShareClicked = {
                    val shareText = "$title\n\n$PLACEHOLDER_SPOILER_TEXT"
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, shareText)
                    }
                    context.startActivity(Intent.createChooser(intent, null))
                },
                onNewSpoilerClicked = onNewSpoilerClicked,
            )
        }
    }
}

@Composable
private fun ResultHeader(
    title: String,
    categoryLabel: String?,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.Black,
                letterSpacing = 4.sp,
                color = Color.White,
            ),
        )
        if (categoryLabel != null) {
            CategoryTag(label = categoryLabel)
        }
    }
}

@Composable
private fun CategoryTag(label: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp),
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                letterSpacing = 1.5.sp,
            ),
        )
    }
}

@Composable
private fun SpoilerBody(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = Color.White.copy(alpha = 0.85f),
            lineHeight = 26.sp,
        ),
        textAlign = TextAlign.Start,
    )
}

@Composable
private fun BottomActions(
    onShareClicked: () -> Unit,
    onNewSpoilerClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        OutlinedButton(
            onClick = onShareClicked,
            modifier = Modifier
                .weight(1f)
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
            ),
        ) {
            Text(
                text = "SHARE",
                style = MaterialTheme.typography.labelLarge.copy(
                    letterSpacing = 2.sp,
                ),
            )
        }

        Button(
            onClick = onNewSpoilerClicked,
            modifier = Modifier
                .weight(1f)
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        ) {
            Text(
                text = "NEW SPOILER",
                style = MaterialTheme.typography.labelLarge.copy(
                    letterSpacing = 2.sp,
                ),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ResultScreenPreview() {
    SpoilerTheme {
        ResultScreen(
            title = "Lost",
            categoryLabel = "TV Series",
            onNewSpoilerClicked = {},
        )
    }
}
