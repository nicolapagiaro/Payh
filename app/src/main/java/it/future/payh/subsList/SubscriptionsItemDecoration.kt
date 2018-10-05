package it.future.payh.subsList

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class SubscriptionsItemDecoration : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {
    private val VerticalSpacing = 16

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView,
                                state: androidx.recyclerview.widget.RecyclerView.State) {
        outRect.bottom = VerticalSpacing
        outRect.top = VerticalSpacing
    }
}