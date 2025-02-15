package com.HasnainAkhtar.i221241

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.HasnainAkhtar.i221241.models.People
import com.HasnainAkhtar.i221241.adapters.PeopleAdapter

class PeopleActivity : AppCompatActivity() {

    private lateinit var peopleAdapter: PeopleAdapter
    private var peopleList = mutableListOf<People>()
    private var filteredList = mutableListOf<People>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_people)

        setupRecyclerView()
        setupSearchBar()
    }

    private fun setupRecyclerView() {
        peopleList = getSamplePeople()  // Load dummy data
        filteredList.addAll(peopleList)
        peopleAdapter = PeopleAdapter(filteredList)

        val recyclerView = findViewById<RecyclerView>(R.id.rvInviteList)
        recyclerView.layoutManager = LinearLayoutManager(this@PeopleActivity)
        recyclerView.adapter = peopleAdapter
    }

    private fun setupSearchBar() {
        val etSearch = findViewById<EditText>(R.id.etSearch)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterPeople(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterPeople(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(peopleList)
        } else {
            for (person in peopleList) {
                if (person.name.contains(query, ignoreCase = true)) {
                    filteredList.add(person)
                }
            }
        }
        peopleAdapter.notifyDataSetChanged()
    }

    private fun getSamplePeople(): MutableList<People> {
        return mutableListOf(
            People("Henry School", R.drawable.facebook),
            People("Emily James", R.drawable.facebook),
            People("Lily Thomas", R.drawable.facebook),
            People("Amy Wesley", R.drawable.facebook),
            People("Laura Ryan", R.drawable.facebook),
            People("Christopher", R.drawable.facebook)
        )
    }
}
