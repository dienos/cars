package jth.com.thetrive.data.util

import java.text.DecimalFormat

fun Int.asCommaFormatter(): String {
    val formatter = DecimalFormat("###,###")
    return formatter.format(this)
}
