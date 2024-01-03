package com.taher.validator

import org.junit.Test

class ValidatorUnitTest {

    @Test
    fun name_test_case_1() {
        val name = "Mohamed Taher"
        val (isValid, _) = name.isValidParam(AppValidator.Type.UserName)
        assert(isValid)
    }

    @Test
    fun name_test_case_2() {
        val name = ""
        val (isValid, _) = name.isValidParam(AppValidator.Type.UserName)
        assert(isValid.not())
    }

    @Test
    fun phone_test_case_1() {
        val name = "01114216241"
        val (isValid, _) = name.isValidParam(AppValidator.Type.phone)
        assert(isValid)
    }

    @Test
    fun phone_test_case_2() {
        val name = "0111"
        val (isValid, _) = name.isValidParam(AppValidator.Type.phone)
        assert(isValid.not())
    }

    @Test
    fun weakPassword_test_case_1() {
        val name = "password"
        val (isValid, _) = name.isValidParam(AppValidator.Type.WeakPassword)
        assert(isValid)
    }

    @Test
    fun weakPassword_test_case_2() {
        val name = ""
        val (isValid, _) = name.isValidParam(AppValidator.Type.WeakPassword)
        assert(isValid.not())
    }

    @Test
    fun password_test_case_1() {
        val name = "P@ssword123"
        val (isValid, _) = name.isValidParam(AppValidator.Type.Password)
        assert(isValid)
    }

    @Test
    fun password_test_case_2() {
        val name = "password"
        val (isValid, _) = name.isValidParam(AppValidator.Type.Password)
        assert(isValid.not())
    }

    @Test
    fun textAr_test_case_1() {
        val name = "بسم الله"
        val (isValid, _) = name.isValidParam(AppValidator.Type.TextAr)
        assert(isValid)
    }

    @Test
    fun textAr_test_case_2() {
        val name = ""
        val (isValid, _) = name.isValidParam(AppValidator.Type.TextAr)
        assert(isValid.not())
    }

}