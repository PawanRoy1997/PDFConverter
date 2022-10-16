package com.freeware.pdfconverter.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<Binding : ViewBinding> : AppCompatActivity() {
    private lateinit var _binding: Binding
    protected val binding: Binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = createViewBinding()
        setContentView(binding.root)
        initViews()
    }

    abstract fun initViews()

    abstract fun createViewBinding(): Binding
}