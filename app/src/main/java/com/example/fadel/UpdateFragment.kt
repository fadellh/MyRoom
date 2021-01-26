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
import androidx.navigation.fragment.navArgs
import com.example.fadel.data.entity.UserEntity


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btnAdd = view.findViewById<Button>(R.id.btnAdd_update)
        val etfirstName = view.findViewById<EditText>(R.id.etFirstName)
        val etlastName = view.findViewById<EditText>(R.id.etLastName)
        val etage = view.findViewById<EditText>(R.id.etAge)

        view.findViewById<EditText>(R.id.etFirstName_update).setText(args.currentUser.firstName)
        view.findViewById<EditText>(R.id.etLastName_update).setText(args.currentUser.lastName)
        view.findViewById<EditText>(R.id.etAge_update).setText(args.currentUser.age.toString())

      /*  btnAdd.setOnClickListener {
            updateDatabase(etfirstName,etlastName,etage)
        }*/

        return view
    }

    private fun updateDatabase(etFirstName: EditText, etLastName: EditText,etAge: EditText ){
        val firstName = etFirstName.text.toString()
        val lasttName = etLastName.text.toString()
        val age = etAge.text

        Log.d("conba","$lasttName , $firstName")

        if(inputCheck(firstName,lasttName,age)){
            val user = UserEntity(id= args.currentUser.id, firstName = firstName, lastName = lasttName, age = Integer.parseInt(age.toString()))
            userViewModel
            Toast.makeText(requireContext(), "Succesesfully updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill all fielded", Toast.LENGTH_LONG).show()

        }
    }


    private fun inputCheck(first: String, last: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(first)&& TextUtils.isEmpty(last)&& TextUtils.isEmpty(age))

    }
}