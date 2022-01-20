package com.hypernova.userprofile.tabs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.hypernova.userprofile.ui.theme.CompBlue

@Composable
fun AboutMe(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.padding(horizontal = 10.dp)
    ) {
        Text(
            text = "About Me",
            color = CompBlue,
            fontSize = 20.sp
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pretium suspendisse ut sit ultrices. Proin leo sit a at pellentesque. Tempor quis non scelerisque a. Rhoncus volutpat enim et odio ut adipiscing.",
            fontSize = 14.sp,
            color = Color.Black
        )
        Text(
            text = "Skills",
            color = CompBlue,
            fontSize = 20.sp
        )
        FlowRow(
            mainAxisSpacing = 10.dp,
            crossAxisSpacing = 10.dp
        ) {
            Chip()
            Chip()
            Chip()
            Chip()
            Chip()
            Chip()
            Chip()
            Chip()
            Chip()
        }
    }
}

@Composable
fun Chip() {
    Surface(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Blue
        ),
        color = Color.Transparent
    ) {
        Text(
            text = "Kotlin",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(7.dp)
        )
    }
}