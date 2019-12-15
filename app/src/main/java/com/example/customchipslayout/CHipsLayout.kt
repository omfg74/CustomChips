package com.example.customchipslayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

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
    private var paddingLeft: Int? = null
    private var paddingRight: Int? = null
    private var paddingTop: Int? = null
    private var paddingBottom: Int? = null
    private var totalLineCount: Int? = 2
    private var bgResource: Int? = null
    private var itemWidth: Int? = null
    private var itemHeight: Int? = null

    fun setMargins(left: Int?, top: Int?, right: Int?, bottom: Int?) {
        this.left = dp(left)
        this.right = dp(right)
        this.top = dp(top)
        this.bottom = dp(bottom)
    }

    fun setPaddings(left: Int?, top: Int?, right: Int?, bottom: Int?) {
        paddingLeft = left
        paddingRight = right
        paddingTop = top
        paddingBottom = bottom
    }

    fun setLineCount(count: Int?) {
        totalLineCount = count
    }

    fun setBackground(backgroundResource: Int?) {
        bgResource = backgroundResource
    }

    fun setViewSize(width: Int?, height: Int?) {
        itemWidth = width
        itemHeight = height
    }


    @SuppressLint("DrawAllocation")
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (i in 0 until childCount) {
            val lp: FrameLayout.LayoutParams=
             if (itemWidth != null || itemHeight == null) {
                LayoutParams(dp(itemWidth), ViewGroup.LayoutParams.WRAP_CONTENT)
            } else if (itemWidth == null || itemHeight != null) {
                LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(itemHeight))
            } else if (itemWidth == null || itemHeight == null) {
                LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            } else {
                LayoutParams(
                    dp(itemWidth),
                    dp(itemHeight)
                )
            }
            val child = getChildAt(i)
            child.background = ContextCompat.getDrawable(context, R.drawable.bgr_chips)
            var margins = 0
            var extraTopMargin = 0
            var lineCount = 0
            for (j in 0 until indexOfChild(child)) {
                val m = (getChildAt(j) as TextView).measure(0, 0)
                margins += (getChildAt(j) as TextView).measuredWidth
                if ((margins + ((left ?: 0) * indexOfChild(child))) > this.width) {
                    extraTopMargin = child.measuredHeight
                    lineCount++
                    margins = 0
                }
            }
            lp.setMargins(
                (left ?: 0) + margins + (left ?: 0) * indexOfChild(child),
                ((top ?: 0) * (1 + lineCount)) + extraTopMargin,
                right ?: 0,
                bottom ?: 0
            )
            child.setPadding(dp(paddingLeft), dp(paddingTop), dp(paddingRight), dp(paddingBottom))
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