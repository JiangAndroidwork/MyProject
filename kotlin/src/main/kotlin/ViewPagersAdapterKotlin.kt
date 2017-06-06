import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/5/19 13:44.
 */
 open class  ViewPagersAdapterKotlin (private val viewList: List<View>?) : PagerAdapter() {

    override fun getCount(): Int {
        if (viewList == null)
            return 0
        return viewList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = viewList!![position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(viewList!![position])
    }
}
