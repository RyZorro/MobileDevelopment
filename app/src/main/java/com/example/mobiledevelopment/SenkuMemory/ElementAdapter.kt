package com.example.mobiledevelopment.SenkuMemory

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledevelopment.databinding.SurveyItemViewBinding

class ElementAdapter(val elementList: List<Element>) :RecyclerView.Adapter<ElementAdapter.ViewHolder>(), Filterable{

    var elementFilterList = ArrayList<Element>()

    init {
        elementFilterList = elementList as ArrayList<Element>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SurveyItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = elementList[position]
        holder.bindItem(element)
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    inner class ViewHolder(val itemBinding: SurveyItemViewBinding)
        :RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(element: Element) {
            itemBinding.title.text = element.title
            itemBinding.detail.text = element.detail
            itemBinding.image.setImageResource(element.image)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    elementFilterList = elementList as ArrayList<Element>
                } else {
                    val resultList = ArrayList<Element>()
                    for (row in elementFilterList) {
                        if (row.title.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    elementFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = elementFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                elementFilterList = results?.values as ArrayList<Element>
                notifyDataSetChanged()
            }
        }
    }
}