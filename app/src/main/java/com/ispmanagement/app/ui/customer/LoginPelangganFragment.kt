package com.ispmanagement.app.ui.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ispmanagement.app.MainActivity
import com.ispmanagement.app.R
import com.ispmanagement.app.databinding.FragmentLoginBinding
import com.ispmanagement.app.viewmodel.AppViewModel

class LoginPelangganFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvLoginTitle.text = "Login Pelanggan"
        binding.tvLoginSubtitle.text = "Login diperlukan untuk mengakses fitur komplain"
        binding.tvHint.text = "Contoh akun demo → username: budi, password: budi123"

        binding.btnLogin.setOnClickListener {
            val u = binding.etUsername.text?.toString()?.trim().orEmpty()
            val p = binding.etPassword.text?.toString()?.trim().orEmpty()
            if (u.isEmpty() || p.isEmpty()) {
                Toast.makeText(requireContext(), "Lengkapi username dan password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.loginPelanggan(u, p) { sukses, pesan ->
                if (!isAdded) return@loginPelanggan
                Toast.makeText(requireContext(), pesan, Toast.LENGTH_SHORT).show()
                if (sukses) {
                    (requireActivity() as MainActivity).refreshDrawerState()
                    findNavController().navigate(R.id.komplainListFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
