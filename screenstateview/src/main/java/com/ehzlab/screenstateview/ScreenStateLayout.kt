package com.ehzlab.screenstateview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout


class ScreenStateLayout : FrameLayout {

    private lateinit var loadingView: ViewGroup
    private lateinit var emptyView: ViewGroup
    private lateinit var errorView: ViewGroup
    var state: ScreenState = ScreenState.Show
        set(value) {
            field = value
            when (value) {
                is ScreenState.Loading -> loading()
                is ScreenState.Error -> error()
                is ScreenState.Empty -> empty()
                is ScreenState.Show -> show()
            }
        }

    constructor(context: Context) : super(context) {

        View.inflate(context, R.layout.view_screen_state, this)
        buildViews(context, null)

    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {

        View.inflate(context, R.layout.view_screen_state, this)
        buildViews(context, attributes)

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {

        View.inflate(context, R.layout.view_screen_state, this)
        buildViews(context, attributeSet)

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attributeSet, defStyleAttr, defStyleRes) {

        View.inflate(context, R.layout.view_screen_state, this)
        buildViews(context, attributeSet)

    }

    private fun buildViews(context: Context, attributeSet: AttributeSet?) {

        attributeSet?.let { attrs ->
            val a = context.obtainStyledAttributes(attrs, R.styleable.ScreenStateLayout)
            if (a.hasValue(R.styleable.ScreenStateLayout_loading_layout)) {
                val loadingLayoutRes = a.getResourceId(R.styleable.ScreenStateLayout_loading_layout, 0)
                loadingView = ConstraintLayout(context)
                View.inflate(context, loadingLayoutRes, loadingView)
            }
            if (a.hasValue(R.styleable.ScreenStateLayout_empty_layout)) {
                val emptyLayoutRes = a.getResourceId(R.styleable.ScreenStateLayout_empty_layout, 0)
                emptyView = ConstraintLayout(context)
                View.inflate(context, emptyLayoutRes, emptyView)
            }
            if (a.hasValue(R.styleable.ScreenStateLayout_error_layout)) {
                val errorLayoutRes = a.getResourceId(R.styleable.ScreenStateLayout_error_layout, 0)
                errorView = ConstraintLayout(context)
                View.inflate(context, errorLayoutRes, errorView)
            }
            a.recycle()
        }

    }

    private fun removeStateViews() {
        removeView(loadingView)
        removeView(errorView)
        removeView(emptyView)
    }

    private fun addStateView(view: View) {
        removeStateViews()

        view.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )

        addView(view)
    }

    private fun show() {
        removeStateViews()
    }

    private fun loading() {
        removeStateViews()
        addStateView(loadingView)
    }

    private fun error() {
        removeStateViews()
        addStateView(errorView)
    }

    private fun empty() {
        removeStateViews()
        addStateView(emptyView)
    }


}
