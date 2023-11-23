package com.curso.android.app.practica.textcompare.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.textcompare.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_makeTruthyComparison() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.replaceText("text string")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.replaceText("text string")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }

    @Test
    fun mainActivity_makeFalsyComparison() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.replaceText("text string")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.replaceText("a different text string")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compare_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos no son iguales")
            )
        )
    }
}
