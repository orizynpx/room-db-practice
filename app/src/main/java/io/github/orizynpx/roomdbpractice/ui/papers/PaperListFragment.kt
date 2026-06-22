package io.github.orizynpx.roomdbpractice.ui.papers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import io.github.orizynpx.roomdbpractice.R
import io.github.orizynpx.roomdbpractice.data.model.Author
import io.github.orizynpx.roomdbpractice.data.model.Category
import io.github.orizynpx.roomdbpractice.MainApplication
import io.github.orizynpx.roomdbpractice.ui.MainViewModel
import io.github.orizynpx.roomdbpractice.ui.MainViewModelFactory
import io.github.orizynpx.roomdbpractice.ui.PaperAdapter

class PaperListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels {
        MainViewModelFactory((requireActivity().application as MainApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_paper_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editPaperTitle = view.findViewById<EditText>(R.id.editPaperTitle)
        val editPaperAbstract = view.findViewById<EditText>(R.id.editPaperAbstract)
        val spinnerCategories = view.findViewById<Spinner>(R.id.spinnerCategories)
        val spinnerAuthors = view.findViewById<Spinner>(R.id.spinnerAuthors)
        val btnAddPaper = view.findViewById<Button>(R.id.btnAddPaper)
        val rvPapers = view.findViewById<RecyclerView>(R.id.rvPapers)

        val adapter = PaperAdapter()
        rvPapers.adapter = adapter

        val categoryList = mutableListOf<Category>()
        val categorySpinnerAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, mutableListOf())
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategories.adapter = categorySpinnerAdapter

        val authorList = mutableListOf<Author>()
        val authorSpinnerAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, mutableListOf())
        authorSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAuthors.adapter = authorSpinnerAdapter

        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            categoryList.clear()
            categoryList.addAll(categories)
            categorySpinnerAdapter.clear()
            categorySpinnerAdapter.addAll(categories.map { it.name })
        }

        viewModel.authors.observe(viewLifecycleOwner) { authors ->
            authorList.clear()
            authorList.addAll(authors)
            authorSpinnerAdapter.clear()
            authorSpinnerAdapter.addAll(authors.map { it.name })
        }

        viewModel.papersWithCategory.observe(viewLifecycleOwner) { papers ->
            adapter.submitList(papers)
        }

        btnAddPaper.setOnClickListener {
            val title = editPaperTitle.text.toString()
            val abstract = editPaperAbstract.text.toString()
            val catPos = spinnerCategories.selectedItemPosition
            val authPos = spinnerAuthors.selectedItemPosition

            if (title.isNotBlank() && abstract.isNotBlank() &&
                catPos != AdapterView.INVALID_POSITION &&
                authPos != AdapterView.INVALID_POSITION
            ) {
                val categoryId = categoryList[catPos].categoryId
                val authorId = authorList[authPos].authorId
                viewModel.addPaper(title, abstract, categoryId, listOf(authorId))
                editPaperTitle.text.clear()
                editPaperAbstract.text.clear()
            } else {
                Toast.makeText(requireContext(), "Fill all fields and select both category and author", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
