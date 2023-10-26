package com.example.linnedindicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val slideItems = listOf(
            SlideItem(
                getString(R.string.sample_item_description_bike),
                R.color.orange
            ),
            SlideItem(
                getString(R.string.sample_item_description_bike),
                R.color.black
            ),
            SlideItem(
                getString(R.string.sample_item_description_bike),
                R.color.amber
            ),
        )
        val view_pager2 = findViewById<ViewPager2>(R.id.viewPager)
        val indicatorView = findViewById<IndicatorView>(R.id.indicator_view)
        val adapter = SlideAdapter(slideItems)
        view_pager2.adapter = adapter
        view_pager2.adapter = SlideAdapter(slideItems)
        val maxWidthForIndicators = calculateMaxWidthForIndicators(slideItems)

        indicatorView.apply {
            val normalColor = resources.getColor(R.color.french_gray)
            val checkedColor = resources.getColor(R.color.colorPrimary)
            setSliderColor(normalColor, checkedColor)
            setSliderWidth(maxWidthForIndicators)
            setSliderHeight(resources.getDimension(R.dimen.dp_8))
            setSlideMode(IndicatorSlideMode.COLOR)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setPageSize(adapter.itemCount)
            notifyDataChanged()
        }
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicatorView.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicatorView.onPageSelected(position)
            }
        })
    }

    private fun calculateMaxWidthForIndicators(slideItems: List<SlideItem>): Float {
        val availableWidth = resources.getDimension(R.dimen.dp_280)
        val indicatorCount =slideItems.size
        return availableWidth / indicatorCount
    }

}