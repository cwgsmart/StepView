package com.cwg.stepview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cwg.stepview.ui.theme.StepViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StepViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    val mutableListOf = mutableListOf<StepItem>()
                    mutableListOf.add(StepItem("",0, 0,"确认收货"))
                    mutableListOf.add(StepItem("",0,1,"到达卸货地址，卸货"))
                    mutableListOf.add(StepItem("",0,2,"已发车，前往卸货地址"))
                    mutableListOf.add(StepItem("",0,3,"到达卸货地址，装货"))
                    mutableListOf.add(StepItem("",0,4,"前往装货地址"))
                    mutableListOf.add(StepItem("",2,5,"上传洗消凭证"))
                    mutableListOf.add(StepItem("11-07\n11:24:08",1,6,"接单"))
                    mutableListOf.add(StepItem("11-07\n12:24:08", 1, 7,"下单"))
                    StepView(stepItemList =mutableListOf,30)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StepViewTheme {
        Greeting("Android")
    }
}