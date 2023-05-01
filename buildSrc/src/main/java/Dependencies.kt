object Dependencies {

    object AndroidX {
        private const val coreKtxVersion = "1.8.0"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

        private const val lifecycleRuntimeKtxVersion = "2.3.1"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"

        private const val activityComposeVersion = "1.5.1"
        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    }

    object Compose {
        const val version = "1.3.2"

        const val bom = "androidx.compose:compose-bom:2022.10.00"
        const val ui = "androidx.compose.ui:ui"
        const val uiGraphics = "androidx.compose.ui:ui-graphics"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"

        const val composeUITestJUnit4 = "androidx.compose.ui:ui-test-junit4"
        const val composeUITooling = "androidx.compose.ui:ui-tooling"
        const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object Test {
        private const val jUnitVersion = "4.13.2"
        const val jUnit = "junit:junit:$jUnitVersion"

        private const val androidXExpJUnitVersion = "1.1.3"
        const val androidXExpJUnit = "androidx.test.ext:junit:$androidXExpJUnitVersion"

        private const val androidXEspressoCoreVersion = "3.4.0"
        const val androidXEspressoCore =
            "androidx.test.espresso:espresso-core:$androidXEspressoCoreVersion"
    }
}