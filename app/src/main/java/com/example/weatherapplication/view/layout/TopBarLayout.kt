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

@Composable
fun MainScreenTopBar(
    viewModel: WeatherViewModel,
    onClickOptionsEvent: () -> Unit = {}
) {
    val cityName: String = "Stuttgart"
    val datetime: String = "12 September, Sunday"
    TopAppBar(
        contentPadding = PaddingValues(10.dp),
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Column {
            Text(
                text = cityName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = datetime,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = onClickOptionsEvent) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
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
