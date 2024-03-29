package com.example.standard_week2

import com.example.standard_week2.dataclass.DonutItem
import com.example.standard_week2.dataclass.Nutritional

val donutList = arrayOf(
    DonutItem("Almond Donut", "R$ 9.9", R.drawable.img_donut_almonddonut),
    DonutItem("Chocolate Donut", "R$ 9.9", R.drawable.img_donut_chocolatedonut),
    DonutItem("Glazed Donut", "R$ 9.9", R.drawable.img_donut_glazeddonut),
    DonutItem("Strawberry Donut", "R$ 9.9", R.drawable.img_donut_strawberrydonut),
    DonutItem("White Chocolate Donut", "R$ 9.9", R.drawable.img_donut_whitechocolatedonut),
    DonutItem("Little Chicken", "R$ 9.9", R.drawable.img_donut_littlechicken)
)
val nutriType = arrayOf(
    "calories",
    "proteins",
    "fats",
    "sugars"
)
val nutriList = arrayOf(
    Nutritional("302kcal", "1.2g", "33g", "20g"),
    Nutritional("300kcal", "7.2g", "24g", "22g"),
    Nutritional("310kcal", "9.2g", "21g", "19g"),
    Nutritional("700kcal", "8.2g", "12g", "4g"),
    Nutritional("120kcal", "5.2g", "0.2g", "12g"),
    Nutritional("111kcal", "0.2g", "8g", "10g")
    )