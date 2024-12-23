package com.example.foodrecipe.presentation.componants.buttons

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.example.foodrecipe.common.assets.Iconly
import com.example.foodrecipe.common.assets.icons.`Share-outline`
import com.example.foodrecipe.ui.theme.Black

@Composable
fun ShareButton(modifier: Modifier) =
    Image(
        imageVector = Iconly.`Share-outline`,
        contentDescription = "Share icon",
        colorFilter = ColorFilter.tint(Black),
        modifier = modifier
    )
