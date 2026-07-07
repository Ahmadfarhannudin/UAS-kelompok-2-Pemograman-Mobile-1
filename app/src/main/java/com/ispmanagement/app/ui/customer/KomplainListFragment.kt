package com.ispmanagement.app.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ispmanagement.app.MainActivity
import com.ispmanagement.app.R
import com.ispmanagement.app.databinding.FragmentKomplainListBinding
import com.ispmanagement.app.ui.adapters.KomplainAdapter
import com.ispmanagement.app.viewmodel.AppViewModel

class KomplainListFragment : Fragment() {

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

        // Wajib login: jika sesi pelanggan belum ada, arahkan ke login
        if (!viewModel.session.isPelangganLoggedIn()) {
            findNavController().navigate(R.id.loginPelangganFragment)
            return
        }

        val pelangganId = viewModel.session.getPelangganId()

        adapter = KomplainAdapter(emptyList()) { tiket ->
            findNavController().navigate(
                R.id.detailKomplainFragment,
                Bundle().apply {
                    putLong("tiketId", tiket.id)
                    putBoolean("isCs", false)
                }
            )
        }
        binding.rvKomplain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKomplain.adapter = adapter

        viewModel.tiketByPelanggan(pelangganId).observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }

        binding.fabTambah.setOnClickListener {
            findNavController().navigate(R.id.buatKomplainFragment)
        }

        (requireActivity() as MainActivity).refreshDrawerState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
