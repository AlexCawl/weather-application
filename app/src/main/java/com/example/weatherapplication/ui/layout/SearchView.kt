package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchEditText(
    onTextChangeEvent: (String) -> Unit = {},
    onSearchPressedEvent: (String) -> Unit = {},
) {
    var value: String by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = {
            value = it
            onTextChangeEvent(it)
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            IconButton(onClick = { onSearchPressedEvent(value) }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            if (value != "") {
                IconButton(onClick = { value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape,
    )
}

@Composable
fun SearchItemView(
    cityName: String, countryName: String, onClickEvent: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .clickable { onClickEvent(cityName) }
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = cityName, fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = countryName, fontSize = 18.sp, color = Color.Black)
    }
}

@Composable
fun SearchItemListView(
    listOfItems: MutableState<List<Pair<String, String>>>
) {
    LazyColumn(content = {
        items(listOfItems.value) {
            item: Pair<String, String> -> SearchItemView(cityName = item.first, countryName = item.second)
        }
    })
}

@Preview
@Composable
fun SearchViewPreview() {
    val listOfItems = remember {
        mutableStateOf(
            listOf(
                Pair("London", "UK"),
                Pair("Moscow", "RU"),
                Pair("Washington", "US"),
                Pair("Tokyo", "JP"),
                Pair("Seoul", "SK"),
            )
        )
    }

    Column {
        SearchEditText()
        SearchItemListView(listOfItems)
    }
}