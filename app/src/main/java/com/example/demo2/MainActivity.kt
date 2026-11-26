package com.example.demo2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.example.demo2.databinding.ABinding
import com.example.demo2.ui.theme.Demo2Theme
import com.example.demo2.MyFragment


//commit {} is a Kotlin extension function provided by Fragment KTX, used to replace the lengthy beginTransaction().commit() call.
// 使用fragmentManager.commit 扩展方法 需要引入androidx.fragment.app.commit和fragment-ktx依赖.
// fragment-ktx，已经被合并入androidx.fragment:fragment
import androidx.fragment.app.commit

//class MainActivity : ComponentActivity() {
// 为了使用Fragment，需要FragmentManager，需要FragmentActivity
class MainActivity : FragmentActivity() {
    private lateinit var binding: ABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var fm = supportFragmentManager
        super.onCreate(savedInstanceState)
        // SystemBarStyle 电量，wifi导航栏背景色
//        enableEdgeToEdge(SystemBarStyle.light(Color0.parseColor("#ff0000"), Color0.parseColor("#ffff00")))
//        setContent {
//            Demo2Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//        R.layout中的R是哪个类
//        R 是 Android 编译时自动生成的资源索引类，全名是 你的包名.R（比如 com.example.myapp.R）。它不属于任何你手写的类，而是 aapt/aapt2 在构建时根据 res/ 目录自动生成的。
//        setContentView(R.layout.a) // 引入xml
        binding = ABinding.inflate(getLayoutInflater())
        val view: View? = binding.getRoot()
        setContentView(view)
        var button = binding.button1
        println("has onclick listener:" + button.hasOnClickListeners())
//        if (!button.hasOnClickListeners()) {
            button.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
//                    print("clicked")
                    Log.d("TEST", "clicked")
                    var frag = MyFragment()
                    fm.commit {
                        setReorderingAllowed(true)
                        add(R.id.fragment_container, frag)
                    }


                }
            })
//        }
//        binding.button1.onClick


//        val button = findViewById<Button>(R.id.btn_click)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name   !",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Demo2Theme {
        Greeting("Android")
    }
}