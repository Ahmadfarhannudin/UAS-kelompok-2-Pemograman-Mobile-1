package com.ispmanagement.app.ui.cs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ispmanagement.app.R
import com.ispmanagement.app.databinding.FragmentKomplainListBinding
import com.ispmanagement.app.ui.adapters.KomplainAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class KelolaKomplainFragment : Fragment() {

    private var _binding: FragmentKomplainListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })
    private lateinit var adapter: KomplainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKomplainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabTambah.visibility = View.GONE // CS hanya membalas, tidak membuat tiket baru

        adapter = KomplainAdapter(emptyList()) { tiket ->
            findNavController().navigate(
                R.id.detailKomplainFragment,
                Bundle().apply {
                    putLong("tiketId", tiket.id)
                    putBoolean("isCs", true)
                }
            )
        }
        binding.rvKomplain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKomplain.adapter = adapter

        viewModel.semuaTiket.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
