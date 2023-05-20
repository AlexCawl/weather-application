package com.example.weatherapplication.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R

@Composable
fun LocationItem(
    identifier: String,
    cityName: String,
    onClickRemoveEvent: (String) -> Unit,
    onClickRefreshEvent: (String) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(15.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = cityName,
            color = MaterialTheme.colors.onBackground,
            fontSize = 18.sp,
            modifier = Modifier.width(120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = identifier,
            modifier = Modifier
                .width(100.dp)
                .background(
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(5.dp),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(
            onClick = {
                onClickRemoveEvent(identifier)
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.round_clear_24),
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface
            )
        }
        IconButton(
            onClick = {
                onClickRefreshEvent(identifier)
            }
        ) {
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
    }
}