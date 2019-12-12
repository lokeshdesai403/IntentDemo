package com.android4dev.intentdemo.kotlin

import java.io.Serializable

data class MovieModel(var movieName: String,
                      var description: String) : Serializable