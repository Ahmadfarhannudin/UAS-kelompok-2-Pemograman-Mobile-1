package com.ispmanagement.app.ui.role

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.MainActivity
import com.ispmanagement.app.R
import com.ispmanagement.app.databinding.FragmentRoleSelectionBinding

class RoleSelectionFragment : Fragment() {

    private var _binding: FragmentRoleSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoleSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardPelanggan.setOnClickListener {
            findNavController().navigate(R.id.cekTagihanFragment)
        }

        binding.cardCs.setOnClickListener {
            val activity = requireActivity() as MainActivity
            if (activity.viewModel.session.isCsLoggedIn()) {
                findNavController().navigate(R.id.csDashboardFragment)
            } else {
                findNavController().navigate(R.id.loginCsFragment)
            }
        }

        (requireActivity() as MainActivity).refreshDrawerState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
