package com.altafrazzaque.margh.util

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment


fun openUrlInBrowser(url:String,context: Context){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

fun downloadImage(fileName:String,imageUrl: String, context: Context) {
    val request = DownloadManager.Request(Uri.parse(imageUrl))
        .setTitle("Quote Image")
        .setDescription("Downloading quote image")
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        .setAllowedOverMetered(true)
        .setAllowedOverRoaming(true)
        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$fileName.jpg")

    val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    downloadManager.enqueue(request)
}
