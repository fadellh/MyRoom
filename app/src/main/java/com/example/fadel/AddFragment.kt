package com.example.fadel

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fadel.data.entity.UserEntity
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        val etfirstName = view.findViewById<EditText>(R.id.etFirstName)
        val etlastName = view.findViewById<EditText>(R.id.etLastName)
        val etage = view.findViewById<EditText>(R.id.etAge)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btnAdd.setOnClickListener {
            insertToDatabase(etfirstName, etlastName, etage)
        }

    return view
    }

    private fun insertToDatabase(etFirstName: EditText, etLastName: EditText,etAge: EditText ){
        val firstName = etFirstName.text.toString()
        val lasttName = etLastName.text.toString()
        val age = etAge.text

        Log.d("conba","$lasttName , $firstName")

        if(inputCheck(firstName,lasttName,age)){
            val user = UserEntity(id=0, firstName = firstName, lastName = lasttName, age = Integer.parseInt(age.toString()))
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Succesesfully added",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill all fielded",Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(first: String, last: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(first)&&TextUtils.isEmpty(last)&&TextUtils.isEmpty(age))

    }
}