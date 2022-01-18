package com.example.ktorclientandroid.data.remote

import com.example.ktorclientandroid.data.remote.dto.PostRequest
import com.example.ktorclientandroid.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostsServices {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest) : PostResponse?

    companion object {
        fun create(): PostsServices {
            return  PostsServiceImpl(
                client = HttpClient(Android){
                    install(Logging){
                        level = LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }

}