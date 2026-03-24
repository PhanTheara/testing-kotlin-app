package com.theara.miniapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CourseAdapter(
    private val context: Context,
    private val courses: List<Course>
) : ArrayAdapter<Course>(context, R.layout.list_item, courses) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater
            .from(context)
            .inflate(R.layout.list_item, parent, false)

        val course = courses[position]

        val itemTitle = view.findViewById<TextView>(R.id.itemTitle)
        val itemDesc  = view.findViewById<TextView>(R.id.itemDesc)

        itemTitle.text = course.title
        itemDesc.text  = course.description

        return view
    }
}