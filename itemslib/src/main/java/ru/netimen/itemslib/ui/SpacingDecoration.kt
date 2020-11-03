package ru.netimen.itemslib.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingDecoration(private val size: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) + 1 != parent.adapter?.itemCount) {
            outRect.bottom = size
        }
    }
}