package com.aditya.ktorclientplayground.data.remote

import com.aditya.ktorclientplayground.data.remote.dto.PostRequest
import com.aditya.ktorclientplayground.data.remote.dto.PostResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import java.io.IOException
import java.lang.Exception

class PostServiceImpl(
    private val client: HttpClient
) : PostService {

    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(RequestRoutes.POSTS)
            }
        } catch (e: RedirectResponseException) {
            e.printStackTrace()
            emptyList()
        } catch (e: ClientRequestException) {
            e.printStackTrace()
            emptyList()
        } catch (e: ServerResponseException) {
            e.printStackTrace()
            emptyList()
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse>() {
                url(RequestRoutes.POSTS)
                contentType(ContentType.Application.Json)
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            e.printStackTrace()
            null
        } catch (e: ClientRequestException) {
            e.printStackTrace()
            null
        } catch (e: ServerResponseException) {
            e.printStackTrace()
            null
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
