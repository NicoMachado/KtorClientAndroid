package com.example.ktorclientandroid.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ktorclientandroid.data.remote.PostsServices
import com.example.ktorclientandroid.data.remote.dto.PostResponse
import com.example.ktorclientandroid.ui.theme.KtorClientAndroidTheme

@Composable
fun PostsKtorDemo(navController: NavController){
    val service = PostsServices.create()
    val posts = produceState<List<PostResponse>>(
        initialValue = emptyList(),
        producer = {
            value = service.getPosts()
        }
    )

    LazyColumn {
        items(posts.value){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text=it.title, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))

                Text(text=it.body, fontSize = 14.sp,
                    modifier = Modifier.padding(8.dp, 0.dp,0.dp, 0.dp))
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PostKtordemoPreview() {
//    KtorClientAndroidTheme {
//        PostsKtorDemo()
//    }
//}
