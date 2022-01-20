package com.hypernova.userprofile.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hypernova.userprofile.R

@Composable
fun BasicInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        InfoCard(
            icon = R.drawable.ic_verified,
            title = "PRN",
            content = "119A1014"
        )
        InfoCard(
            icon = R.drawable.ic_phone,
            title = "Phone No",
            content = "7588310400"
        )
        InfoCard(
            icon = R.drawable.ic_cake,
            title = "DOB",
            content = "April 04 2001"
        )
        InfoCard(
            icon = R.drawable.ic_location,
            title = "Address",
            content = "A-602, Prestige Park, Louiswadi, Vashi Sector 17, Navi Mumbai 400403"
        )
        SocialProfiles()
    }
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    content: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title
            )
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = title,
                    color = Color(0xFF888B92),
                    fontSize = 13.sp
                )
                Text(
                    text = content,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_pen),
            contentDescription = title
        )
    }
}



@Composable
fun SocialProfiles() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Social Profiles",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D3267)
        )
        Text(
            text = "Linkedin",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D3267)
        )
        Text(
            text = "www.linkedin.com/in/pournamipottekat/",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF48A7FF)
        )
        Text(
            text = "Instagram",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1D3267)
        )
        Text(
            text = "www.linkedin.com/in/pournamipottekat/",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF48A7FF)
        )

    }
}
