package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

sealed class TestTabs(
    val content: @Composable () -> Unit
) {
    object TestA: TestTabs({ Text(text = "TestA", modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .background(color = Color.Red))})
    object TestB: TestTabs({ Text(text = "TestB", modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .background(color = Color.Blue))})
    object TestC: TestTabs({ Text(text = "TestC", modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .background(color = Color.Green))})
}

@Composable
fun Test() {

    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "AppBar")
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .padding(15.dp)
            .background(color = Color.Red))
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun TestPreview() {
    val tabs = listOf(
        TestTabs.TestA,
        TestTabs.TestB,
        TestTabs.TestC,
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        val text: Int = pagerState.currentPage
        Text(text = text.toString())
        HorizontalPager(state = pagerState) { page ->
            tabs[page].content()
        }
    }
}