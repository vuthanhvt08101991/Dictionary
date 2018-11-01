package gmail.vuthanhvt.dictionary.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.widgets.SwipeBackLayout;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class SwipeBackFragment.
 */

public class SwipeBackFragment extends BaseFragment implements SwipeBackLayout.SwipeBackListener {

    private SwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return getContainer();
    }

    public void setView(View view) {
        swipeBackLayout.addView(view);
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(getActivity());
        swipeBackLayout = new SwipeBackLayout(getActivity());
        swipeBackLayout.setDragEdge(SwipeBackLayout.DragEdge.LEFT);
        swipeBackLayout.setOnSwipeBackListener(this);
        ivShadow = new ImageView(getActivity());
        ivShadow.setBackgroundColor(
                getResources().getColor(R.color.black_opacity_30));
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        return container;
    }

    public void setDragEdge(SwipeBackLayout.DragEdge dragEdge) {
        swipeBackLayout.setDragEdge(dragEdge);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return swipeBackLayout;
    }

    @Override
    public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
    }

    @Override
    public void onSwipeComplete() {
        getActivity().onBackPressed();
    }
}
