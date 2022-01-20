package com.hypernova.userprofile.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hypernova.userprofile.R
import com.hypernova.userprofile.ui.theme.CompBlue

@Composable
fun Team(modifier: Modifier = Modifier) {
    repeat(10) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TeamCard()
            TeamCard()
        }
    }
}


@Composable
fun TeamCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Team Logo",
            modifier = modifier
                .graphicsLayer {
                    shape = CircleShape
                    clip = true
                }
                .size(106.dp)
        )

        Text(text = "Technical Team of Sies GST", maxLines = 2, color = CompBlue)
        Text(text = "UI UX Designer", color = Color(0xFF868E96))

    }
}