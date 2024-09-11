package org.kotlinmultiplatformprojectwithcompose.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App(batterManagerClass = remember{BatterManagerClass()}) }