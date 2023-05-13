package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@Composable
fun MainScreenTopBar(
    onClickRefreshEvent: () -> Unit,
    onClickOptionsEvent: () -> Unit,
) {
    val datetime: String = "12 September, Sunday"
    TopAppBar(
        contentPadding = PaddingValues(5.dp),
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Text(
            text = datetime,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = onClickRefreshEvent) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_refresh_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
        IconButton(onClick = onClickOptionsEvent) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_window_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
fun LocationScreenTopBar(
    onClickReturnEvent: () -> Unit,
    onClickRefreshEvent: () -> Unit,
    onClickSettingsEvent: () -> Unit,
) {
    TopAppBar(
        contentPadding = PaddingValues(5.dp),
        backgroundColor = MaterialTheme.colors.background,
    ) {
        IconButton(onClick = onClickReturnEvent) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_arrow_back_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = onClickRefreshEvent) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_refresh_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
        IconButton(onClick = onClickSettingsEvent) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_settings_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}