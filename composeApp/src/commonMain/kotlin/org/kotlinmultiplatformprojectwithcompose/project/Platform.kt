package org.kotlinmultiplatformprojectwithcompose.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform