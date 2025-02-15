package com.HasnainAkhtar.i221241

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var rvRecentSearches: RecyclerView
    private lateinit var searchAdapter: SearchAdapter
    private val recentSearches = mutableListOf("Henry Benjamin", "Emily James", "Lily Thomas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        etSearch = findViewById(R.id.etSearch)
        rvRecentSearches = findViewById(R.id.rvRecentSearches)

        setupRecyclerView()

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupRecyclerView() {
        rvRecentSearches.layoutManager = LinearLayoutManager(this)
        searchAdapter = SearchAdapter(recentSearches)
        rvRecentSearches.adapter = searchAdapter
    }
}
