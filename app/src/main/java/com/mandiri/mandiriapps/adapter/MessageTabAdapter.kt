package com.mandiri.mandiriapps.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mandiri.mandiriapps.presentation.message.view.HistoryTransactionFragment
import com.mandiri.mandiriapps.presentation.message.view.NotificationFragment

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

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NotificationFragment()
            1 -> HistoryTransactionFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }

//    fun addListFragment(fragment: Fragment) {
//        fragmentContent.add(fragment)
//    }
    }
}