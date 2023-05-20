package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R

@Composable
fun LocationFloatingActionButton(
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClickEvent,
        modifier = modifier.size(80.dp),
        shape = CircleShape,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.round_add_24),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        )
    }
}