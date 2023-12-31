package com.albatros.kplanner.model.module

import android.content.Context
import com.example.vtbmap.VTBApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val host_name = "http://10.0.2.2:8980"

private const val settingsName = "settings"

//private fun provideApiService(retrofit: Retrofit) =
 //   retrofit.create(DiraApi::class.java)

private fun provideRetrofit(factory: GsonConverterFactory, client: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl(host_name)
        .client(client)
        .addConverterFactory(factory)
        .build()

private fun provideApiService(retrofit: Retrofit) = retrofit.create(VTBApi::class.java)

private fun provideOkHttpClient(cache: Cache, interceptor: Interceptor) = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .cache(cache)
    .build()

private fun provideCache(context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024)

private fun provideInterceptor() = Interceptor {
    var request = it.request()
    val maxStale = 60 * 60 * 24
    request = request.newBuilder()
        .header("Cache-Control", "public, no-cache, max-stale=$maxStale")
        .removeHeader("Pragma")
        .build()
    it.proceed(request)
}

private fun provideGsonFactory(gson: Gson) =
    GsonConverterFactory.create(gson)

private fun provideGson() = GsonBuilder()
    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
    .setPrettyPrinting()
    .serializeNulls()
    .create()

private fun provideSharedPreferences(context: Context) =
    context.getSharedPreferences(settingsName, Context.MODE_PRIVATE)


val appModule = module {
    single(createdAtStart = true) { provideSharedPreferences(get()) }
    single(createdAtStart = true) { provideApiService(get()) }
    single(createdAtStart = true) { provideRetrofit(get(), get()) }
    single { provideCache(get()) }
    single { provideOkHttpClient(get(), get()) }
    single { provideInterceptor() }
    single(createdAtStart = true) { provideGsonFactory(get()) }
    single(createdAtStart = true) { provideGson() }
}