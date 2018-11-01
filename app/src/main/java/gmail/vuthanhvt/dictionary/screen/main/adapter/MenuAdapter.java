package gmail.vuthanhvt.dictionary.screen.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gmail.vuthanhvt.dictionary.base.adapter.BaseRecyclerViewAdapterBinding;
import gmail.vuthanhvt.dictionary.base.adapter.BaseViewHolderBinding;
import gmail.vuthanhvt.dictionary.data.MenuItem;
import gmail.vuthanhvt.dictionary.databinding.ItemMenuBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 23/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MenuAdapter.
 */
public class MenuAdapter extends BaseRecyclerViewAdapterBinding<MenuAdapter.MenuViewHolder, MenuItem> {

    public MenuAdapter(Context context, List<MenuItem> list) {
        super(context, list);
    }

    @Override
    protected MenuViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new MenuViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(getContext())));
    }

    class MenuViewHolder extends BaseViewHolderBinding<ItemMenuBinding, MenuItem> {

        public MenuViewHolder(ItemMenuBinding binding) {
            super(binding);
        }

        @Override
        public void bindData(MenuItem otherMenuItem) {
            super.bindData(otherMenuItem);
            mBinding.setIcon(getContext().getResources().getDrawable(otherMenuItem.getIcon()));
            mBinding.setButtonName(otherMenuItem.getTitle());
            mBinding.setListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemListener != null) {
                        mItemListener.onItemClick(getAdapterPosition(),
                                getData().get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
