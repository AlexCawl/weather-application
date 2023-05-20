package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R

@Composable
fun SearchScreenTopBar(
    onClickReturnEvent: () -> Unit
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
    }
}