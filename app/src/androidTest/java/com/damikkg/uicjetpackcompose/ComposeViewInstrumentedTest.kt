package com.damikkg.uicjetpackcompose

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.damikkg.uicjetpackcompose.ui.compose.ComposeView
import com.damikkg.uicjetpackcompose.ui.theme.UicJetpackComposeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ComposeViewInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    var navTrigger = 0

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ComposeView {
                navTrigger++
            }
        }
    }

    @Test
    fun addClicked() {
        composeTestRule.onNodeWithTag("counterUpTestTag").performClick()

        composeTestRule.onNodeWithTag("counter").assert(hasText("1"))
    }

    @Test
    fun nextScreenClicked() {
        composeTestRule.onNodeWithText("Следующее окно").performClick()

        assert(navTrigger != 0)
    }
}
