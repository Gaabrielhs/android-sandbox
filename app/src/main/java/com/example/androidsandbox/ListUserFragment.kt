package com.example.androidsandbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_user_fragment.view.*


class ListUserFragment : Fragment() {

    companion object {
        fun newInstance() = ListUserFragment()
    }

    private val viewModel: ListUserViewModel by viewModels {
        ListUserViewModelFactory(UserRepository.getInstance(AppDatabase.getInstance(requireContext()).userDao()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_user_fragment, container, false)

        val adapter = UserAdapter()
        view.listUsers.layoutManager = LinearLayoutManager(context)
        view.listUsers.adapter = adapter

        //Adiciona a lista de livedata no adapter
        viewModel.users.observe(viewLifecycleOwner) {
            if(it != null) adapter.submitList(it)
        }


        return view
    }

}
