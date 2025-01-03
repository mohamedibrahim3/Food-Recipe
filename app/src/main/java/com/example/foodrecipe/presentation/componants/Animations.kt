package com.example.foodrecipe.presentation.componants

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.example.foodrecipe.ui.theme.Primary100
import com.example.foodrecipe.ui.theme.Primary40
import com.example.foodrecipe.ui.theme.White


@Composable
fun animations(isSaved: Boolean): SaveAnimations {

    val customEaseInOut = Easing { fraction ->
        if (fraction < 0.5f) {
            2 * fraction * fraction // Ease-in
        } else {
            1 - (-2 * fraction + 2) * (-2 * fraction + 2) / 2 // Ease-out
        }
    }

    val cardColor by animateColorAsState(
        targetValue = if (isSaved) Primary100 else White,
        animationSpec = tween(easing = customEaseInOut),
        label = "Card Color Animation"
    )

    val iconColor by animateColorAsState(
        targetValue = if (isSaved) White else Primary100,
        animationSpec = tween(easing = customEaseInOut),
        label = "Icon Color Animation"
    )

    val bounce by animateFloatAsState(
        targetValue = if (isSaved) 1.02f else 0.9f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessVeryLow
        ),
        label = "Bounce Animation"
    )

    val rotation by animateFloatAsState(
        targetValue = if (isSaved) 360f else 0f,
        animationSpec = tween(easing = customEaseInOut),
        label = "Rotation Animation"
    )

    val followColor by animateColorAsState(
        targetValue = if (isSaved) Primary40 else Primary100,
        label = "Card Color Animation",
        animationSpec = tween(easing = customEaseInOut),
    )

    return SaveAnimations(cardColor, iconColor, followColor, bounce, rotation)
}

data class SaveAnimations(
    val cardColor: Color,
    val iconColor: Color,
    val followColor: Color,
    val bounce: Float,
    val rotation: Float
)