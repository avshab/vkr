package ru.skillbranch.sbdelivery.menuCategory.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.math.MathUtils
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_category_menu.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import javax.inject.Inject
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.menuCategory.model.MenuCategoryViewModel
import kotlin.math.abs

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

class MenuCategoryFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_category_menu

    @Inject lateinit var viewModel: MenuCategoryViewModel

    lateinit var menuCategoryAdapter: MenuCategoryFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuCategoryAdapter = MenuCategoryFragmentAdapter()

        category_pager?.run {
            adapter = menuCategoryAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            clipToPadding = false
            clipChildren = false
            setPageTransformer { page, position ->
                page.alpha = 1 - abs(position)
                page.rotationY = position * -30
                page.scaleX = MathUtils.clamp(1.5f - abs(position), 0f, 1f)
                page.scaleY = MathUtils.clamp(1.5f - abs(position), 0f, 1f)
            }
        }


    }

}

class MenuCategoryFragmentAdapter :
    ListAdapter<Pair<String, List<DishModel>>, MenuCategoryFragmentAdapter.MenuCategoryViewHolder>(
        MenuCategoryDiffCallback()
    ) {

    var dishList = listOf<Pair<String, List<DishModel>>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuCategoryViewHolder(
            inflater.inflate(
                R.layout.fragment_category_menu_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuCategoryViewHolder, position: Int) =
        holder.bind(dishList[position])

    class MenuCategoryViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        //  private val imageViewPhoto: ImageView = itemView.findViewById(R.id.image_view_photo)

        fun bind(data: Pair<String, List<DishModel>>) {

        }
    }
}

class MenuCategoryDiffCallback : DiffUtil.ItemCallback<Pair<String, List<DishModel>>>() {

    override fun areItemsTheSame(oldItem: Pair<String, List<DishModel>>, newItem: Pair<String, List<DishModel>>): Boolean {
        return oldItem.first == newItem.first
    }

    override fun areContentsTheSame(oldItem: Pair<String, List<DishModel>>, newItem: Pair<String, List<DishModel>>): Boolean {
        return oldItem.first == newItem.first
    }
}