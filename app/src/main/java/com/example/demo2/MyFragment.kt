package com.example.demo2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demo2.databinding.ABinding
import com.example.demo2.databinding.BBinding

// Dependency 'androidx.fragment:fragment-compose:1.9.1' requires libraries and applications that
//      depend on it to compile against version 37 or later of the
//      Android APIs.

//Fragment 需要一个依赖于 AndroidX Fragment 库的依赖项。您需要将 Google Maven 代码库添加到项目的 settings.gradle 文件中，才能添加此依赖项。
class MyFragment : Fragment() {
    private lateinit var _binding: BBinding
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fragment", "fragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("fragment", "fragment onCreateView")
//        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = BBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("fragment", "fragment onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}