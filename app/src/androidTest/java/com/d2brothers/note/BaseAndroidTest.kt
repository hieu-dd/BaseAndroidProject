package com.d2brothers.note

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.d2brothers.note.presentation.MainScreen
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseAndroidTest {

    @Rule
    @JvmField
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeRule.activity.setContent {
            MainScreen()
        }
    }
}
