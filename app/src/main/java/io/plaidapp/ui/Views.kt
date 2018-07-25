package io.plaidapp.ui

import android.animation.AnimatorInflater.loadStateListAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.View.SCROLLBARS_OUTSIDE_OVERLAY
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewStub
import android.widget.*
import androidx.core.view.setMargins
import io.plaidapp.R

object Views {
    private fun dpToPixels(context: Context, dp: Int): Int
        = (context.resources.displayMetrics.density * dp + 0.5).toInt()

    fun inflateActivityHome(context: Context): DrawerLayout {
        val view = DrawerLayout(context)
        view.id = R.id.drawer
        view.layoutParams = DrawerLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        view.clipToPadding = false

        val frame = FrameLayout(context)
        frame.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

        val v = View(context)
        v.id = R.id.status_bar_background
        v.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, dpToPixels(context, 0))
        v.background = context.resources.getDrawable(R.color.status_bar_back, context.theme)
        frame.addView(v)

        val rv = RecyclerView(context)
        rv.id = R.id.grid
        rv.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        rv.clipToPadding = false
        rv.elevation = (context.resources.displayMetrics.density * 1.0).toFloat()
        rv.scrollBarStyle = SCROLLBARS_OUTSIDE_OVERLAY
        rv.isVerticalScrollBarEnabled = true
        frame.addView(rv)

        val t = Toolbar(context, null, R.style.Widget_Plaid_HomeToolbar)
        t.id = R.id.toolbar
        t.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, R.attr.actionBarSize)
        t.elevation = (context.resources.displayMetrics.density * 1.0).toFloat()
        t.outlineProvider = null
        t.title = context.resources.getString(R.string.app_name)
        frame.addView(t)

        val p =  ProgressBar(context)
        p.id = android.R.id.empty
        p.layoutParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.CENTER)
        p.isIndeterminate = true
        p.indeterminateTintList = ColorStateList.valueOf(R.attr.colorAccent)
        p.indeterminateTintMode = PorterDuff.Mode.SRC_IN
        frame.addView(p)

        val v1 = ViewStub(context)
        v1.id = R.id.stub_no_filters
        val lp1 = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.CENTER)
        lp1.setMargins(R.dimen.spacing_huge)
        v1.layoutParams = lp1
        v1.layoutResource = R.layout.no_filters
        frame.addView(v1)

        val v2 = ViewStub(context)
        v2.id = R.id.stub_no_connection
        v2.layoutParams = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.CENTER)
        v2.layoutResource = R.layout.no_connection
        frame.addView(v2)

        val b = ImageButton(context)
        b.id = R.id.fab
        val lpb = FrameLayout.LayoutParams(
                context.resources.getDimensionPixelSize(R.dimen.fab_size),
                context.resources.getDimensionPixelSize(R.dimen.fab_size),
                Gravity.BOTTOM or Gravity.END)
        lpb.marginEnd = context.resources.getDimensionPixelSize(R.dimen.padding_normal)
        lpb.bottomMargin = context.resources.getDimensionPixelSize(R.dimen.padding_normal)
        b.layoutParams = lpb
        b.background = context.resources.getDrawable(R.drawable.fab, context.theme)
        b.elevation = context.resources.getDimension(R.dimen.z_fab)
        b.setImageResource(R.drawable.ic_add_dark)
        b.stateListAnimator = loadStateListAnimator(context, R.animator.raise)
        frame.addView(b)

        val v3 = ViewStub(context)
        v3.id = R.id.stub_posting_progress
        val lp3 = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.END)
        lp3.marginEnd = context.resources.getDimensionPixelSize(R.dimen.padding_normal)
        lp3.bottomMargin = context.resources.getDimensionPixelSize(R.dimen.padding_normal)
        v3.layoutParams = lp3
        v3.layoutResource = R.layout.posting_progress
        frame.addView(v3)

        view.addView(frame)

        val rv2 = RecyclerView(context)
        rv2.id = R.id.filters
        rv2.layoutParams = DrawerLayout.LayoutParams(context.resources.getDimensionPixelSize(R.dimen.drawer_width), MATCH_PARENT, Gravity.END)
        rv2.clipToPadding = false
        rv2.elevation = context.resources.getDimension(R.dimen.z_drawer)
        rv2.setPadding(0, context.resources.getDimensionPixelSize(R.dimen.spacing_normal), 0, context.resources.getDimensionPixelSize(R.dimen.spacing_normal))
        rv2.scrollBarStyle = SCROLLBARS_OUTSIDE_OVERLAY
        rv2.isVerticalScrollBarEnabled = true
        rv2.layoutManager = LinearLayoutManager(context)
        view.addView(rv2)

        return view
    }
}