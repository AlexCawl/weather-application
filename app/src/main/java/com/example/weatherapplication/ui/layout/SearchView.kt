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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.model.pojo.Location

@Composable
fun SearchEditText(
    query: MutableState<String>,
    onSearchPressedEvent: (String) -> Unit = {},
    onClearPressedEvent: (String) -> Unit = {},
    onTextChangedEvent: (String) -> Unit = {},
) {
    TextField(
        value = query.value,
        onValueChange = {
            query.value = it
            onTextChangedEvent(it)
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            IconButton(
                onClick = {
                    onSearchPressedEvent(query.value)
                }
            ) {
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
            if (query.value != "") {
                IconButton(
                    onClick = {
                        query.value = ""
                        onClearPressedEvent(query.value)
                    }
                ) {
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
    location: Location, onClickEvent: (Location) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .clickable { onClickEvent(location) }
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = location.name, fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = location.country, fontSize = 18.sp, color = Color.Black)
    }
}

@Composable
fun SearchItemListView(
    listOfItems: SnapshotStateList<Location>
) {
    LazyColumn {
        items(listOfItems) {
                item: Location -> SearchItemView(location = item)
        }
    }
}

@Preview
@Composable
fun SearchViewPreview() {
//    val listOfItems = remember {
//        mutableStateOf(
//            listOf(
//                Location("London", "UK"),
//                Location("Moscow", "RU"),
//                Location("Washington", "US"),
//                Location("Tokyo", "JP"),
//                Location("Seoul", "SK"),
//            )
//        )
//    }
//
//    Column {
//        SearchEditText()
//        SearchItemListView(listOfItems)
//    }
}