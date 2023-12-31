package com.example.laboratorio11

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.laboratorio11.ui.login.LoginFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LoginNavigationTest {
    @Test
    fun testNavigationWelcome(){

        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        val loginScenario = launchFragmentInContainer<LoginFragment>(themeResId = R.style.Theme_Laboratorio11)

        loginScenario.onFragment{ fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        onView(withId(R.id.emailField)).perform(typeText("test@test.com"))
        onView(withId(R.id.passwordField)).perform(typeText("12345678"))
        onView(withId(com.example.laboratorio11.R.id.loginBtn)).perform(click())

        Thread.sleep(2000)
        assertEquals(navController.currentDestination?.id, R.id.welcomeFragment)
    }
}