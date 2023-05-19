package com.d3if4112.aplikasiku.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.d3if4112.aplikasiku.R
import com.d3if4112.aplikasiku.databinding.FragmentMainBinding

class MainFragment : Fragment(){


    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shareButton.setOnClickListener { shareData() }
        binding.btnMobil.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_mainFragment2_to_mobil2
            )
        }
        binding.btnMotor.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_mainFragment2_to_motorFragment2
            )
        }
        binding.btnTentang.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_mainFragment2_to_tentangFragment2
            )
        }

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_mainFragment2_to_tentangFragment2)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //bagikan
    private fun shareData() {
        val message = getString(R.string.tentang_aplikasi
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }


}