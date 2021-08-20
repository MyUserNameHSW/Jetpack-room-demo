package com.hswizy.roomdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hswizy.roomdemo.databinding.ActivityMainBinding
import com.hswizy.roomdemo.viewmodel.RoomViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RoomViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
        lifecycle.addObserver(viewModel)

        binding.insert.setOnClickListener {
            viewModel.insert()
        }
        binding.update.setOnClickListener { viewModel.updateFirst() }
        binding.queryAll.setOnClickListener { viewModel.queryAll() }
        binding.deleteAll.setOnClickListener { viewModel.deleteAll() }
        binding.delete.setOnClickListener { viewModel.deleteLast() }
        binding.insertProduct.setOnClickListener { viewModel.insertProduct() }
        binding.queryProductAll.setOnClickListener { viewModel.queryProductAll() }
        viewModel.listLiveData.observe(this) { list ->
            if (!list.isNullOrEmpty()) {
                val stringBuilder = StringBuilder()
                list.forEach {
                    stringBuilder.append(it.toString())
                    stringBuilder.append("\n")
                    binding.tvRes.text = stringBuilder.toString()
                }
            } else {
                binding.tvRes.text = ""
            }
        }

        viewModel.productLiveData.observe(this) { list ->
            if (!list.isNullOrEmpty()) {
                val stringBuilder = StringBuilder()
                list.forEach {
                    stringBuilder.append(it.toString())
                    stringBuilder.append("\n")
                    binding.tvResProduct.text = stringBuilder.toString()
                }
            } else {
                binding.tvResProduct.text = ""
            }
        }
    }
}