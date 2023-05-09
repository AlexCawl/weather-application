package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreenTopBar() {
    TopAppBar(
        contentPadding = PaddingValues(10.dp),
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Column {
            Text(
                text = "Stuttgart",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = "12 September, Sunday",
                fontSize = 14.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}
// ImageVector.vectorResource(id = R.drawable.round_window_24),
