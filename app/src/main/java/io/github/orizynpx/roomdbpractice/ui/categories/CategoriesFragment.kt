package io.github.orizynpx.roomdbpractice.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import io.github.orizynpx.roomdbpractice.R
import io.github.orizynpx.roomdbpractice.MainApplication
import io.github.orizynpx.roomdbpractice.ui.MainViewModel
import io.github.orizynpx.roomdbpractice.ui.MainViewModelFactory

class CategoriesFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels {
        MainViewModelFactory((requireActivity().application as MainApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editCategoryName = view.findViewById<EditText>(R.id.editCategoryName)
        val btnAddCategory = view.findViewById<Button>(R.id.btnAddCategory)
        val editAuthorName = view.findViewById<EditText>(R.id.editAuthorName)
        val editAuthorAffiliation = view.findViewById<EditText>(R.id.editAuthorAffiliation)
        val btnAddAuthor = view.findViewById<Button>(R.id.btnAddAuthor)

        btnAddCategory.setOnClickListener {
            val name = editCategoryName.text.toString()
            if (name.isNotBlank()) {
                viewModel.addCategory(name)
                editCategoryName.text.clear()
            } else {
                Toast.makeText(requireContext(), "Enter category name", Toast.LENGTH_SHORT).show()
            }
        }

        btnAddAuthor.setOnClickListener {
            val name = editAuthorName.text.toString()
            val affiliation = editAuthorAffiliation.text.toString()
            if (name.isNotBlank() && affiliation.isNotBlank()) {
                viewModel.addAuthor(name, affiliation)
                editAuthorName.text.clear()
                editAuthorAffiliation.text.clear()
            } else {
                Toast.makeText(requireContext(), "Enter author name and affiliation", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
