package com.example.customchipslayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

class CHipsLayout : FrameLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.setWillNotDraw(false)
    }

    private var left: Int? = null
    private var top: Int? = null
    private var right: Int? = null
    private var bottom: Int? = null

    fun setMargins(left: Int?, top: Int?, right: Int?, bottom: Int?) {
        this.left = dp(left)
        this.left = dp(right)
        this.left = dp(top)
        this.left = dp(bottom)
    }

    fun setRowCount(count: Int?) {

    }

    fun setBackgroundColor(bgrColor: String?) {

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0 until childCount) {
            val lp: FrameLayout.LayoutParams =
                LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(36).toInt())
            val child = getChildAt(i)
//            child.setBackgroundColor(Color.parseColor("#F2F5F9"))
            child.setBackgroundColor(Color.RED)
            var margins = 0
            var extraTopMargin = 0
            var dropChild = 0
            for (j in 0 until indexOfChild(child)) {
                val m = (getChildAt(j + dropChild) as TextView).measure(0, 0)
                margins += (getChildAt(j) as TextView).measuredWidth
                if ((margins + ((left ?: 0) * indexOfChild(child))) > this.width) {
                    extraTopMargin = child.measuredHeight
                    dropChild = indexOfChild(child)
                    margins = 0
                }
            }
            lp.setMargins(
                (left ?: 0) + margins + (left ?: 0) * indexOfChild(child),
                (top ?: 0) + extraTopMargin,
                right ?: 0,
                bottom ?: 0
            )
            child.setPadding(dp(12), dp(10), dp(12), dp(10))
            child.layoutParams = lp

        }
    }

    private fun dp(px: Int?): Int {
        if (px == 0 || px == null) return 0
        return (resources.displayMetrics.density * px).toInt()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}