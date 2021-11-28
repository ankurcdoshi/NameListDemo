package com.plantix.namelistdemo.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.plantix.namelistdemo.databinding.FragmentListBinding
import com.plantix.namelistdemo.ui.adapter.NameListAdapter
import com.plantix.namelistdemo.ui.viewmodel.NameListViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NameListFragment : Fragment() {

    private lateinit var mBinding: FragmentListBinding
    private val mViewModel: NameListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListBinding.inflate(inflater, container, false)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.srl.setOnRefreshListener {
            mBinding.srl.isRefreshing = false
            mViewModel.loadNames()
        }

        mViewModel.nameListLiveData.observe(viewLifecycleOwner, {
            var adapter = mBinding.rvNames.adapter
            if (adapter == null) {
                adapter = NameListAdapter(it)
            }
            mBinding.rvNames.adapter = adapter
        })

        mViewModel.loadNames()
    }
}