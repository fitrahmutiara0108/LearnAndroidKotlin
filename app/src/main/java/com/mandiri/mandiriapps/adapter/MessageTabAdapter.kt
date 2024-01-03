package com.mandiri.mandiriapps.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MessageTabAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(
    fragment.childFragmentManager,
    fragment.lifecycle
) {

    private val fragmentContent = arrayListOf<Fragment>()
    private val listFragment = listOf(
        fragmentContent.add(fragment)
    )

    override fun getItemCount() =
        fragmentContent.size

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }

    fun addListFragment(fragment: Fragment) {
        fragmentContent.add(fragment)
    }
}