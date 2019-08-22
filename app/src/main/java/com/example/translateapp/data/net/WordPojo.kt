package com.example.translateapp.data.net

//{
//  "code": 200,
//  "lang": "en-uz",
//  "text": [
//    "o'qish kitoblar"
//  ]
//}
class WordPojo(
    val text: Array<String> = arrayOf(),
    val lang: String,
    val code: Int
)