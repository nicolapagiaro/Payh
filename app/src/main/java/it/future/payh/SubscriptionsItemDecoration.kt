package it.future.payh

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SubscriptionsItemDecoration : RecyclerView.ItemDecoration() {
    private val VerticalSpacing = 16

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        outRect.bottom = VerticalSpacing
        outRect.top = VerticalSpacing
    }
}