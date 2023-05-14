package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.view.theme.WeatherApplicationTheme

@Composable
fun SearchBar(
    onTextChangeEvent: (String) -> Unit,
    unfocusedColor: Color,
    focusedColor: Color,
    modifier: Modifier = Modifier,
) {
    val content = remember { mutableStateOf("") }
    val hasFocus = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier
            .onFocusChanged { hasFocus.value = it.hasFocus }
            .fillMaxWidth()
            .padding(5.dp),
        value = content.value,
        onValueChange = {
            content.value = it
            onTextChangeEvent(it)
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.round_search_24),
                contentDescription = null,
                tint = when (hasFocus.value) {
                    true -> focusedColor
                    false -> unfocusedColor
                }
            )
        },
        trailingIcon = {
            if (content.value.isNotEmpty() && hasFocus.value) {
                IconButton(onClick = { content.value = "" }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.round_clear_24),
                        contentDescription = null,
                        tint = unfocusedColor
                    )
                }
            }
        },
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle().copy(
            color = when (hasFocus.value) {
                true -> focusedColor
                false -> unfocusedColor
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent
        )
    )
}

@Composable
fun SearchItem(
    cityName: String,
    latitude: Double,
    longitude: Double,
    regionName: String,
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(15.dp))
            .padding(10.dp)
            .clickable { onClickEvent() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = cityName,
            color = MaterialTheme.colors.onBackground,
            fontSize = 18.sp,
            modifier = Modifier.width(150.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(20.dp))
        Row(
            modifier = Modifier
                .width(120.dp)
                .background(
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "lat",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
                Text(
                    text = "%.1f".format(latitude),
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "lon",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
                Text(
                    text = "%.1f".format(longitude),
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f, true))
        Text(
            text = regionName,
            color = MaterialTheme.colors.onBackground,
            fontSize = 18.sp,
            maxLines = 1
        )
    }
}

@Composable
fun SearchHintContent(
    list: List<Location>,
    onClickEvent: (Location) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) {
            SearchItem(
                cityName = it.name,
                latitude = it.latitude,
                longitude = it.longitude,
                regionName = it.country,
                onClickEvent = { onClickEvent(it) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WeatherApplicationTheme {
        Column {
            SearchBar(
                onTextChangeEvent = {},
                unfocusedColor = MaterialTheme.colors.onSurface,
                focusedColor = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(15.dp)
                    )
            )
            SearchItem(
                cityName = "Chelyabinsk 2077",
                latitude = 23.4,
                longitude = -36.8,
                regionName = "RU",
                onClickEvent = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )
        }
    }
}
