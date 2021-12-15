package com.hypernova.userprofile.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

class OvalCustomShape() : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                reset()
                lineTo(0f, (4*size.height)/5)
                cubicTo(0f, size.height,size.width,size.height,size.width,(4*size.height)/5)
                lineTo(size.width, 0f)
                close()
            }
        )
    }
}

class RoundedCircleCorner(): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic (
            path = Path().apply {
                reset()
                moveTo(size.width/4, 0f)
                lineTo(size.width/4 + size.width/2, 0f)
                arcTo(
                    rect = Rect(
                        top = 0f,
                        bottom = size.height,
                        right = size.width,
                        left = size.width/2 + size.width/8
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                lineTo(size.width/4, size.height)
                arcTo(
                    rect = Rect(
                        top = 0f,
                        bottom = size.height,
                        left = 0f,
                        right = size.width/2 - size.width/8
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = false
                )
                close()
            }
        )
    }
}