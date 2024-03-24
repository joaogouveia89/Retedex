package io.github.joaogouveia89.retedex.core.presentation.common

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import io.github.joaogouveia89.retedex.ui.theme.BluePrimary
import io.github.joaogouveia89.retedex.ui.theme.YellowPrimary

@Composable
fun RetedexAppBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    textColor: Color = YellowPrimary,
    backgroundColor: Color = BluePrimary
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                color = textColor
            )
        },
        backgroundColor = backgroundColor,
        modifier = modifier
    )
}