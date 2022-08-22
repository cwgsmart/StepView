package com.cwg.stepview

import android.R.attr.x
import android.R.attr.y
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun StepView(stepItemList: MutableList<StepItem>, lineHigh: Int) {
    LazyColumn {
        item {
            stepItemList.forEachIndexed { index, stepItem ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (stepItemList[index].timeStamp == null) {
                        Text(text = "", modifier = Modifier.width(100.dp))
                    } else {
                        Text(
                            text = "${stepItemList[index].timeStamp}",
                            modifier = Modifier.width(100.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column() {
                        Canvas(
                            modifier = Modifier
                                .height(lineHigh.dp)
                                .width(5.dp)
                        ) {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            drawLine(
                                start = Offset(0f, 0f),
                                end = Offset(0f, canvasHeight),
                                color = if (index == 0)
                                    Color.Transparent
                                else {
                                    when (stepItemList[index - 1].lineColor) {
                                        0 -> {
                                            Color.Gray
                                        }
                                        1 -> {
                                            Color.Red
                                        }
                                        2 -> {
                                            Color.Blue
                                        }
                                        3 -> {
                                            Color.Yellow
                                        }
                                        4 -> {
                                            Color.Cyan
                                        }
                                        else -> {
                                            Color.Gray
                                        }
                                    }

                                },
                                strokeWidth = 5F
                            )
                        }


                        Canvas(modifier = Modifier.size(5.dp)) {
                            val canvasWidth = 5.dp.toPx()
                            val canvasHeight = 5.dp.toPx()
                            drawCircle(
                                color =
                                when (stepItemList[index].showType) {
                                    0 -> {
                                        Color.Gray
                                    }
                                    1 -> {
                                        Color.Green
                                    }
                                    2 -> {
                                        Color.Yellow
                                    }
                                    else -> {
                                        Color.Gray
                                    }
                                },
                                center = Offset(x = 0F, y = canvasHeight / 2),
                                radius = size.minDimension / 2
                            )
                        }
                        Canvas(
                            modifier = Modifier
                                .height(lineHigh.dp)
                                .width(5.dp)
                        ) {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            drawLine(
                                start = Offset(0f, 0f),
                                end = Offset(0f, canvasHeight),
                                color = if (index == stepItemList.size - 1) Color.Transparent else {
                                    when (stepItemList[index].lineColor) {
                                        0 -> {
                                            Color.Gray
                                        }
                                        1 -> {
                                            Color.Red
                                        }
                                        2 -> {
                                            Color.Blue
                                        }
                                        3 -> {
                                            Color.Yellow
                                        }
                                        4 -> {
                                            Color.Cyan
                                        }
                                        else -> {
                                            Color.Gray
                                        }
                                    }

                                },
                                strokeWidth = 5F
                            )
                        }

                    }
                    Text(
                        text = stepItemList[index].contentString,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun StepViewPreview() {
    val mutableListOf = mutableListOf<StepItem>()
    mutableListOf.add(StepItem("", 1, 0, "第一条消息"))
    mutableListOf.add(StepItem("", 1, 0, "第二条消息"))
    mutableListOf.add(StepItem("11-07 11:24:08", 1, 0, "第三条消息"))
    StepView(mutableListOf, 20)
}

data class StepItem(
    val timeStamp: String?,
    val showType: Int,
    val lineColor: Int,
    val contentString: String
)

