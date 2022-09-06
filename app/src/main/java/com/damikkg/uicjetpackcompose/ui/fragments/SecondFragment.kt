package com.damikkg.uicjetpackcompose.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.damikkg.uicjetpackcompose.R
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            findViewById<Button>(R.id.showToastBtn).setOnClickListener {
                Toast.makeText(context, getString(R.string.toast_msg), Toast.LENGTH_LONG).show()
            }

            findViewById<Button>(R.id.showDialogBtn).setOnClickListener {
                AlertDialog.Builder(context)
                    .setTitle(getString(R.string.dialog_title))
                    .setMessage(getString(R.string.dialog_text))
                    .setPositiveButton(getString(R.string.dialog_btn)) { dialog, _ ->
                        dialog.cancel()
                    }
                    .show()
            }

            findViewById<Button>(R.id.backBtn).setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}
