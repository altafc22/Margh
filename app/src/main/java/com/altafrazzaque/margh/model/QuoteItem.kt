package com.altafrazzaque.margh.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class QuoteItem(
    @Json(name = "image") val imageUrl: String,
    @Json(name = "by") val authorUrl: String,
    @Json(name = "download") val downloadUrl: String?,
    @Json(name = "source") val sourceUrl: String,
    @PrimaryKey
    @Json(name = "id") val id: String
) : Parcelable

const val TEST_DATA = """
[
    {
      "image": "https://images.unsplash.com/photo-1707327259268-2741b50ef5e5?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxzZWFyY2h8MXx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@neom",
      "download": "https://unsplash.com/photos/DMGDdksVoWI/download?ixid=M3wxMjA3fDF8MXxzZWFyY2h8MXx8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "d4a2e0f4-102c-4978-9091-b179c49bac87"
    },
    {
      "image": "https://plus.unsplash.com/premium_photo-1661277738780-34bfa7383ec5?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/plus?referrer=%2Fphotos%2Ffantastic-starry-sky-beautiful-winter-landscape-and-snow-capped-peaks-picturesque-mountains-mountain-view-courtesy-of-nasa-carpathians-ukraine-europe-ZXx6BlsSu4s",
      "source": "https://unsplash.com",
      "id": "6c2b2a5f-20db-4da6-8167-73ec1bd4677a"
    },
    {
      "image": "https://images.unsplash.com/photo-1554147090-e1221a04a025?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@wildhoney",
      "download": "https://unsplash.com/photos/RsRTIofe0HE/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "5a9d6ac6-a035-4b63-9db0-f20a34b6497d"
    },
    {
      "image": "https://images.unsplash.com/photo-1519681393784-d120267933ba?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@vorosbenisop",
      "download": "https://unsplash.com/photos/phIFdC6lA4E/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8NHx8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "2744bc43-c680-49b4-a1ae-6a1355e74194"
    },
    {
      "image": "https://plus.unsplash.com/premium_photo-1674476933064-cf99850bed72?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/plus?referrer=%2Fphotos%2Fa-close-up-view-of-a-wavy-pattern-JsrtvPv82pw",
      "source": "https://unsplash.com",
      "id": "8200d999-e3d1-4b32-9a44-1a1f4776c4f7"
    },
    {
      "image": "https://images.unsplash.com/photo-1477346611705-65d1883cee1e?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@heytowner",
      "download": "https://unsplash.com/photos/JgOeRuGD_Y4/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8Nnx8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "f975cf89-02dc-44fc-b59b-5e3f800c446a"
    },
    {
      "image": "https://images.unsplash.com/photo-1511300636408-a63a89df3482?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@lucamicheli",
      "download": "https://unsplash.com/photos/ruWkmt3nU58/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8N3x8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "25f8fd93-8293-41ec-9e93-f384cd43a6b4"
    },
    {
      "image": "https://images.unsplash.com/photo-1707343843598-39755549ac9a?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxzZWFyY2h8OHx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/@neom",
      "download": "https://unsplash.com/photos/LAj90eAXOZA/download?ixid=M3wxMjA3fDF8MXxzZWFyY2h8OHx8d2FsbHBhcGVyfGVufDB8fHx8MTcxMTEwMjU2OXww&force=true",
      "source": "https://unsplash.com",
      "id": "2a58c48d-03d3-487d-a275-04ead10efe11"
    },
    {
      "image": "https://plus.unsplash.com/premium_photo-1675826774817-c15cf80ece32?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8d2FsbHBhcGVyfGVufDB8fDB8fHww",
      "by": "https://unsplash.com/plus?referrer=%2Fphotos%2Fa-mountain-covered-in-snow-under-a-night-sky-wgcnqd5DP8g",
      "source": "https://unsplash.com",
      "id": "70562362-55fe-4e21-a32d-21718841dae9"
    },
    {
      "image": "https://images.unsplash.com/photo-1508739773434-c26b3d09e071?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@cristina_gottardi",
      "download": "https://unsplash.com/photos/CSpjU6hYo_0/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTB8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "242916ec-ebc5-480e-b286-b6ff8bfaec98"
    },
    {
      "image": "https://images.unsplash.com/photo-1541701494587-cb58502866ab?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@aznbokchoy",
      "download": "https://unsplash.com/photos/wQLAGv4_OYs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTF8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "8b73ab6f-2823-422b-b42d-c89216cd6689"
    },
    {
      "image": "https://images.unsplash.com/photo-1491466424936-e304919aada7?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@r3dmax",
      "download": "https://unsplash.com/photos/3l3RwQdHRHg/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTJ8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "a48adf4f-e2bc-4bd4-8203-d972b5878745"
    },
    {
      "image": "https://plus.unsplash.com/premium_photo-1680607980708-d2532db7a529?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/plus?referrer=%2Fphotos%2Fa-blue-robot-with-a-pink-background-zQLxugRHy4U",
      "source": "https://unsplash.com",
      "id": "3ff2765c-3f50-4708-b241-81d59095bdc5"
    },
    {
      "image": "https://images.unsplash.com/photo-1485470733090-0aae1788d5af?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@danielleone",
      "download": "https://unsplash.com/photos/v7daTKlZzaw/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTR8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "a48bac84-501b-4f9b-ae41-8379a2822672"
    },
    {
      "image": "https://images.unsplash.com/photo-1707327956851-30a531b70cda?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxzZWFyY2h8MTV8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@neom",
      "download": "https://unsplash.com/photos/bOMVTvE2QFU/download?ixid=M3wxMjA3fDF8MXxzZWFyY2h8MTV8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "cb95a074-78c8-4c89-bb7e-e55b5f6a887b"
    },
    {
      "image": "https://images.unsplash.com/photo-1481833761820-0509d3217039?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@clemono",
      "download": "https://unsplash.com/photos/zlABb6Gke24/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTZ8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "ed2e7b32-f1e0-4c5c-9e69-92bea845b70c"
    },
    {
      "image": "https://plus.unsplash.com/premium_photo-1674476932917-3689cdfd6642?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/plus?referrer=%2Fphotos%2Fa-close-up-of-a-red-sculpture-against-a-blue-sky-Do-H6coUcx4",
      "source": "https://unsplash.com",
      "id": "0e838f18-f3d7-4253-bd97-2e0221e622a2"
    },
    {
      "image": "https://images.unsplash.com/photo-1554034483-04fda0d3507b?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@adrian_infernus",
      "download": "https://unsplash.com/photos/GLf7bAwCdYg/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTh8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "a5396554-3b72-47c5-95f1-0187edb324f2"
    },
    {
      "image": "https://images.unsplash.com/photo-1512850183-6d7990f42385?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@malteesimo",
      "download": "https://unsplash.com/photos/enGr5YbjQKQ/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MTl8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "24a240f1-62a6-4ba9-a406-46fa1e0c34e1"
    },
    {
      "image": "https://images.unsplash.com/photo-1563387852576-964bc31b73af?q=80&w=600&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHdhbGxwYXBlcnxlbnwwfHwwfHx8MA%3D%3D",
      "by": "https://unsplash.com/@parachutel_",
      "download": "https://unsplash.com/photos/q2dUSl9S4Xg/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8MjB8fHdhbGxwYXBlcnxlbnwwfHx8fDE3MTExMDI1Njl8MA&force=true",
      "source": "https://unsplash.com",
      "id": "2964a586-9080-48ea-9a2f-be1f252fcb8b"
    }
  ]
"""