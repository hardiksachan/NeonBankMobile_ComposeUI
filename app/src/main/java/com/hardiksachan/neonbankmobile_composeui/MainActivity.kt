package com.hardiksachan.neonbankmobile_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hardiksachan.neonbankmobile_composeui.ui.HomeScreen
import com.hardiksachan.neonbankmobile_composeui.ui.theme.NeonBankMobile_ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeonBankMobile_ComposeUITheme {
                HomeScreen()
            }
        }
    }
}