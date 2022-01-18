package com.example.ktorclientandroid.data.remote

import com.example.ktorclientandroid.data.remote.dto.PostRequest
import com.example.ktorclientandroid.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostsServiceImpl(
    private val client : HttpClient
) : PostsServices {
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(HttpRoutes.POSTS)
            }
        } catch (e: RedirectResponseException){
            // 3xx - Responses
            println("Error : ${e.response.status.description}")
            emptyList<PostResponse>()
        } catch (e: ClientRequestException){
            // 4xx - Responses
            println("Error : ${e.response.status.description}")
            emptyList<PostResponse>()
        } catch (e: ServerResponseException){
            // 5xx - Responses
            println("Error : ${e.response.status.description}")
            emptyList<PostResponse>()
        } catch (e: Exception){
            println("Error : ${e.localizedMessage}")
            emptyList<PostResponse>()
        }

    }
    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse> {
                url(HttpRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e: RedirectResponseException){
            // 3xx - Responses
            println("Error : ${e.response.status.description}")
            null
        } catch (e: ClientRequestException){
            // 4xx - Responses
            println("Error : ${e.response.status.description}")
            null
        } catch (e: ServerResponseException){
            // 5xx - Responses
            println("Error : ${e.response.status.description}")
            null
        } catch (e: Exception){
            println("Error : ${e.localizedMessage}")
            null
        }

    }
}