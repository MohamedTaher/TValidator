package com.taher.validator

import java.util.regex.Pattern

class AppValidator(private val errorMessage: ErrorMessage = ErrorMessage()) {

    object Regex {
        const val userName          = "^[a-zA-Z ]{1,64}"
        const val phone             = "^01[0125][0-9]{8}\$"
        const val weakPassword      = "^.{8,50}$"
        const val password          = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"
        const val textAr            =  "^[\\sء-ي]{1,50}$"
    }

    enum class Type {
        UserName, phone, WeakPassword, Password, TextAr;
    }

    private fun Type?.getRegexAndErrorMessage(usingCustomRegex: String = "", usingCustomError: String = ""): Pair<String, String> {
        return when (this) {
            Type.UserName       -> Pair(Regex.userName              , errorMessage.name)
            Type.phone   -> Pair(Regex.phone                 , errorMessage.phone)
            Type.WeakPassword   -> Pair(Regex.weakPassword          , errorMessage.weakPassword)
            Type.Password       -> Pair(Regex.password              , errorMessage.password)
            Type.TextAr         -> Pair(Regex.textAr                , errorMessage.textAr)
            else                -> Pair(usingCustomRegex            , usingCustomError)
        }
    }

    fun isValid(string: String, regex: String, errorMessage: String): Pair<Boolean, String?> {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(string)
        if (!matcher.matches()) {
            return Pair(false, errorMessage)
        }

        return Pair(true, null)
    }

    fun isValid(string: String, type: Type): Pair<Boolean, String?> {
        val (regex, errorMessage) = type.getRegexAndErrorMessage()
        return isValid(string, regex, errorMessage)
    }
}

fun String.isValidParam(type: AppValidator.Type): Pair<Boolean, String?> {
    return AppValidator().isValid(this, type)
}

fun String.isValidParam(regex: String, errorMessage: String): Pair<Boolean, String?> {
    return AppValidator().isValid(this, regex, errorMessage)
}