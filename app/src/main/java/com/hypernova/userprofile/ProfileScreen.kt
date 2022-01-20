package com.hypernova.userprofile

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.hypernova.userprofile.tabs.AboutMe
import com.hypernova.userprofile.tabs.BasicInfo
import com.hypernova.userprofile.tabs.Team
import com.hypernova.userprofile.ui.theme.OvalCustomShape
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.net.SocketAddress

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun ProfileScreen() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    CollapsingToolbarLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(0.dp),
        expandedHeight = 340.dp,
        expandedToolBarContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(340.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .graphicsLayer {
                        shape = OvalCustomShape()
                        clip = true
                    }
                    .background(Color(0xFF001F39))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "profile",
                    modifier = Modifier
                        .graphicsLayer {
                            shape = CircleShape
                            clip = true
                        }
                        .size(100.dp)
                )
                Text(text = "Vedant Bhamare")
                Text(text = "vedantbhamare11@gmail.com")
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.linkedin_logo),
                        contentDescription = "Linkedin"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.github_logo),
                        contentDescription = "Github"
                    )
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .graphicsLayer {
                        shape = RoundedCornerShape(50)
                        clip = true
                    }
                    .background(Color.White),
                contentPadding = PaddingValues(horizontal = 50.dp)
            ) {
                items(3) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Text(text = "TE", color = Color(0xFF48A7FF))
                        Text(text = "CE", color = Color.Black)
                    }
                }
            }
        },
        expandedToolbarShape = RectangleShape,
        collapsedHeight = 66.dp,
        collapsedToolBarContent = {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Profile",
                color = Color(0xFF001F39),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp
            )
        },
        content = {
                TabLayout(
                    modifier = Modifier.fillMaxSize(),
                    pagerState = pagerState,
                    scope = scope
                )
        }
    )

}

@ExperimentalAnimationApi
@Composable
fun CollapsingToolbarLayout(
    modifier: Modifier = Modifier,
    expandedHeight: Dp = 200.dp,
    expandedToolBarContent: @Composable (BoxScope.() -> Unit),
    collapsedHeight: Dp = 0.dp,
    collapsedToolBarContent: @Composable (BoxScope.() -> Unit),
    collapsedToolbarColor: Color = MaterialTheme.colors.primarySurface,
    expandedToolbarShape: Shape = RectangleShape,
    toolBarCollapsedShape: Shape = RectangleShape,
    dividerThickness: Dp = 0.dp,
    dividerColor: Color = MaterialTheme.colors.secondary,
    content: @Composable () -> Unit,
    contentPadding: PaddingValues = PaddingValues(),
    contentVerticalArrangement: Arrangement.Vertical = Arrangement.Top,
) {
    val expandedHeightPx =
        with(LocalDensity.current) { expandedHeight.roundToPx().toFloat() }
    val collapsedHeightPx =
        with(LocalDensity.current) { collapsedHeight.roundToPx().toFloat() }
    var offsetHeightPx by rememberSaveable { mutableStateOf(0f) }
    var totalScrollOffsetPx by rememberSaveable { mutableStateOf(0f) }
    val expandedBarTransparency = 1f - offsetHeightPx / (collapsedHeightPx - expandedHeightPx)
    val isCollapsedBarVisible = expandedBarTransparency == 0f

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource,
            ): Offset {
                totalScrollOffsetPx += consumed.y

                offsetHeightPx =
                    totalScrollOffsetPx.coerceIn(
                        collapsedHeightPx - expandedHeightPx,
                        0f
                    )
                if (offsetHeightPx == 0f) {
                    totalScrollOffsetPx = 0f
                }
                return Offset.Zero
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = modifier,
            contentPadding = contentPadding,
            verticalArrangement = contentVerticalArrangement
        ) {
            item {
                Spacer(
                    modifier = modifier
                        .height(expandedHeight)
                        .fillMaxWidth()
                )
                content()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    translationY = offsetHeightPx
                    shape = expandedToolbarShape
                    clip = true
                    alpha = expandedBarTransparency
                }
        ) {
            expandedToolBarContent()
        }
        AnimatedVisibility(
            visible = isCollapsedBarVisible,
            enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut()
        )
        {
            Column {
                TopAppBar(
                    modifier = Modifier
                        .padding(0.dp)
                        .height(collapsedHeight)
                        .fillMaxWidth()
                        .graphicsLayer {
                            shape = toolBarCollapsedShape
                            clip = true
                        },
                    title = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(end = 12.dp)
                        ) {
                            collapsedToolBarContent()
                        }
                    },
                    backgroundColor = collapsedToolbarColor,
                )
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = dividerColor,
                    thickness = dividerThickness
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabLayout(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    val tabData = listOf(
        "Basic Info",
        "Attendance",
        "Part Of Team",
        "More about me"
    )
    Column {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
            backgroundColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .graphicsLayer {
                            shape = RoundedCornerShape(12.dp)
                            clip = true
                        },
                    height = 4.dp,
                    color = Color(0xFF48A7FF)
                )
            }
        ) {
            tabData.forEachIndexed { index, text ->
                Tab(
                    selected = pagerState.currentPage == index,
                    unselectedContentColor = Color(0x521D3267),
                    selectedContentColor = Color(0xFF1D3267),
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = text) }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            count = tabData.size
        ) { index ->
            Column(
                modifier = modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when(index) {
                    0 -> BasicInfo()
                    1 -> AboutMe()
                    2 -> Team()
                    3 -> AboutMe()
                    else -> BasicInfo()
                }
            }
        }
    }
}


