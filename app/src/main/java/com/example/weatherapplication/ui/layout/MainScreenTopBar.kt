package com.example.weatherapplication.ui.layout

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
import com.example.weatherapplication.model.service.ConverterService

@Composable
fun MainScreenTopBar(
    converter: ConverterService,
    onClickRefreshEvent: () -> Unit,
    onClickOptionsEvent: () -> Unit,
) {
    val datetime: String = converter.getTime()
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
