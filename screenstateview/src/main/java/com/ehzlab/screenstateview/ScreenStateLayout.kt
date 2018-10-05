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

            context.obtainStyledAttributes(attrs, R.styleable.ScreenStateLayout).apply {

                if (hasValue(R.styleable.ScreenStateLayout_loading_layout)) {
                    val loadingLayoutRes = getResourceId(R.styleable.ScreenStateLayout_loading_layout, 0)
                    loadingView = ConstraintLayout(context)
                    View.inflate(context, loadingLayoutRes, loadingView)
                } else {
                    View.inflate(context, R.layout.layout_state_default_loading, loadingView)
                }

                if (hasValue(R.styleable.ScreenStateLayout_empty_layout)) {
                    val emptyLayoutRes = getResourceId(R.styleable.ScreenStateLayout_empty_layout, 0)
                    emptyView = ConstraintLayout(context)
                    View.inflate(context, emptyLayoutRes, emptyView)
                } else {
                    View.inflate(context, R.layout.layout_state_default_empty, emptyView)
                }

                if (hasValue(R.styleable.ScreenStateLayout_error_layout)) {
                    val errorLayoutRes = getResourceId(R.styleable.ScreenStateLayout_error_layout, 0)
                    errorView = ConstraintLayout(context)
                    View.inflate(context, errorLayoutRes, errorView)
                } else {
                    View.inflate(context, R.layout.layout_state_default_error, errorView)
                }

                recycle()
            }

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
