package com.example.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.exam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var unsortedAnagrams: MutableList<String> = arrayListOf()

        binding.btnSave.setOnClickListener(){

            unsortedAnagrams = binding.editTextText.text.toString().split(" ").toMutableList()
            Toast.makeText(this, "Words saved!!", Toast.LENGTH_LONG).show()
        }
        
        binding.btnOutput.setOnClickListener(){
            binding.textView.text = "Anagrams count: ${sortAnagrams(unsortedAnagrams).count().toString()}"
        }


    }


    private fun sortAnagrams(words: List<String>): List<List<String>>{
        val sortedWords = mutableMapOf<String, MutableList<String>>()

        words.forEach{ word ->
            val sortedChars = word.toCharArray().sorted().joinToString("")
            if(sortedWords.containsKey(sortedChars)){
                sortedWords[sortedChars]!!.add(word)
            }else{
                sortedWords[sortedChars] = mutableListOf(word)
            }
        }
        return sortedWords.values.toList()
    }
}
