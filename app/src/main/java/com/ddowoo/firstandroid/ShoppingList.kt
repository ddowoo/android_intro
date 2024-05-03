package com.ddowoo.firstandroid

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ShoppingItem (
    val id:Int,
    var name:String,
    var quantity:Int,
    var isEditing: Boolean = false
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp (modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        var shoppingList by remember { mutableStateOf(listOf<ShoppingItem>()) }
        var showDialog by remember { mutableStateOf(false) }
        var editItem by remember { mutableStateOf<ShoppingItem?>(null) }
        var itemName by remember { mutableStateOf("") }
        var itemCount by remember { mutableStateOf("") }

        fun removeItem (item: ShoppingItem){
            shoppingList = shoppingList.filter { it != item }
        }

        Button(
            onClick = {
                showDialog = true

            },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "추가")
        }


        if (editItem != null) {
            EditShoppingItem(editItem!!)
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(shoppingList){
                ShoppingListItem(it,{
                    editItem = it
                },{
                    removeItem(it)
                })
            }
        }




        if(showDialog){
            AlertDialog(onDismissRequest = {
               showDialog = false
            }, confirmButton = {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        if(itemName.isNotBlank()){
                            val newItem = ShoppingItem(
                                shoppingList.size + 1,
                                itemName,
                                itemCount.toInt() ,
                            )
                            shoppingList = shoppingList + newItem// shoppingList에 새로운 아이템 추가
                            showDialog = false
                            itemName = ""
                            itemCount = ""
                        }
                    }) {
                        Text("추가")
                    }
                    Button(onClick = {
                        showDialog = false
                    }) {
                        Text("취소")
                    }
                }
            },
            title = {Text("쇼핑 아이템 추가")},
                text = {
                    Column {
                        // onValueCahnge it => 변경되는 string 값을 의미
                        OutlinedTextField(
                            value = itemName,
                            onValueChange = {itemName = it},
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                        OutlinedTextField(
                            value = itemCount,
                            onValueChange = {itemCount = it},
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
            )

        }
    }


}

@Composable
fun ShoppingListItem (
    item:ShoppingItem,
    onEditClick: ()-> Unit,
    onDeleteClick: ()-> Unit,
    ){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Blue),
                shape = RoundedCornerShape(10)
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("${item.name} ${item.quantity}개" , Modifier.padding(8.dp))

        Row {
            Button(onClick = {
                onEditClick()
            }) {
                Icon(Icons.Rounded.Edit, "삭제 아이콘")
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = {
                onDeleteClick()
            }) {
                Icon(Icons.Rounded.Delete, "삭제 아이콘")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditShoppingItem(item: ShoppingItem){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = item.name,
            onValueChange = {item.name = it},
            modifier = Modifier
                .background(
                    Color.White
                )
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextField(value = item.quantity.toString(), onValueChange = {item.quantity = it.toInt()}, modifier = Modifier.background(
            Color.White
        ))
    }
}