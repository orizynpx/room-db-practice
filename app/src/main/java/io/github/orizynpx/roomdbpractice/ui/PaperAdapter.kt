package io.github.orizynpx.roomdbpractice.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.orizynpx.roomdbpractice.R
import io.github.orizynpx.roomdbpractice.data.model.ResearchPaperWithCategory

class PaperAdapter : ListAdapter<ResearchPaperWithCategory, PaperAdapter.PaperViewHolder>(DiffCallback) {

    class PaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.tvPaperTitle)
        private val categoryView: TextView = itemView.findViewById(R.id.tvCategoryName)
        private val authorsView: TextView = itemView.findViewById(R.id.tvAuthors)
        private val abstractView: TextView = itemView.findViewById(R.id.tvPaperAbstract)

        fun bind(item: ResearchPaperWithCategory) {
            titleView.text = item.paper.title
            categoryView.text = item.category.name
            
            val authorNames = item.authors.joinToString(", ") { it.name }
            authorsView.text = if (authorNames.isNotEmpty()) "By: $authorNames" else "No authors listed"

            abstractView.text = item.paper.abstract
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaperViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paper, parent, false)
        return PaperViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaperViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ResearchPaperWithCategory>() {
        override fun areItemsTheSame(oldItem: ResearchPaperWithCategory, newItem: ResearchPaperWithCategory): Boolean {
            return oldItem.paper.paperId == newItem.paper.paperId
        }

        override fun areContentsTheSame(oldItem: ResearchPaperWithCategory, newItem: ResearchPaperWithCategory): Boolean {
            return oldItem == newItem
        }
    }
}
