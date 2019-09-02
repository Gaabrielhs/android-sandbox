package com.example.androidsandbox


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_user.*

/**
 * A simple [Fragment] subclass.
 */
class NewUserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository.getInstance(AppDatabase.getInstance(requireContext()).userDao()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_new_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(),"Salvante", Toast.LENGTH_SHORT).show()

            val usuario = User(nome = nome.text.toString(), apelido = apelido.text.toString())

            viewModel.insertUser(usuario)

            val directions = NewUserFragmentDirections.actionNewUserFragmentToListUserFragment()
            findNavController().navigate(directions)
        }


        super.onViewCreated(view, savedInstanceState)
    }


}
