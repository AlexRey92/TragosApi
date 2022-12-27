package com.e.tragos

data class DrinksResponse (
    val drinks:List<Drinks>
)

data class Drinks (
val strDrink:String,
val strDrinkThumb: String,
val idDrink:String

        )


