package com.altafrazzaque.margh.util

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.FileProvider
import com.altafrazzaque.margh.BuildConfig
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun shareImageWithMessage(imageUrl: String, message: String, context: Context) {
    GlobalScope.launch(Dispatchers.IO){
        Glide.with(context).asBitmap().load(imageUrl)
            .into(object: CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {}
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val cachePath = File(context.cacheDir, "images")
                    cachePath.mkdirs()
                    val stream = FileOutputStream(cachePath.toString() + "/image.png") // overwrites this image every time
                    resource.compress(Bitmap.CompressFormat.PNG, 100, stream)
                    stream.close()

                    val imagePath = File(context.cacheDir, "images")
                    val newFile = File(imagePath, "image.png")
                    val contentUri: Uri = FileProvider.getUriForFile(context, "${BuildConfig.APPLICATION_ID}.provider", newFile)

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "image/*"
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intent.putExtra(Intent.EXTRA_STREAM, contentUri)
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    context.startActivity(Intent.createChooser(intent, "Choose..."))

                }
            })
    }
}


fun shareImageWithMessage(bitmap: Bitmap, message: String, context: Context) {
    val file = saveBitmapToFile(bitmap, context)
    if (file != null) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/jpeg"
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
        shareIntent.putExtra(Intent.EXTRA_TEXT, message)
        context.startActivity(Intent.createChooser(shareIntent, "Share image"))
    }
}

fun shareImage(bitmap: Bitmap, context: Context) {
    val file = saveBitmapToFile(bitmap, context)

    if (file != null) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/jpeg"
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
        context.startActivity(Intent.createChooser(shareIntent, "Share image"))
    }
}

private fun saveBitmapToFile(bitmap: Bitmap, context: Context): File? {
    val fileName = "shared_image.jpg"
    var file: File? = null
    try {
        val dir = context.getExternalFilesDir(null)
        if (dir != null) {
            file = File(dir, fileName)
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return file
}
