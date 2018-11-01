package gmail.vuthanhvt.dictionary.screen.main;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;
import gmail.vuthanhvt.dictionary.constant.MenuType;
import gmail.vuthanhvt.dictionary.data.MenuItem;
import gmail.vuthanhvt.dictionary.screen.character.CharacterActivity;
import gmail.vuthanhvt.dictionary.screen.history.HistoryActivity;
import gmail.vuthanhvt.dictionary.screen.information.InfoActivity;
import gmail.vuthanhvt.dictionary.screen.mongviet.MongVietActivity;
import gmail.vuthanhvt.dictionary.screen.vietmong.VietMongActivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MainPresenter.
 */
public class MainPresenter implements BasePresenter {

    public static final String TAG = "MainPresenter";

    private MainView mMainView;

    private List<MenuItem> mListItems = new ArrayList<>();

    public MainPresenter(MainView view) {
        mMainView = view;
    }

    @Override
    public void subscribe() {
        //don't anything.
    }

    @Override
    public void unSubscribe() {
        //don't anything.
    }

    public void addMenuItems() {
        Log.d(TAG, "addMenuItems: ");
        mListItems.clear();
        mListItems.add(new MenuItem(MenuType.VietMong, R.drawable.ic_folder,
                getString(R.string.item_menu_vietmong)));
        mListItems.add(new MenuItem(MenuType.MongViet, R.drawable.ic_folder,
                getString(R.string.item_menu_mongviet)));
        mListItems.add(new MenuItem(MenuType.Character, R.drawable.ic_folder,
                getString(R.string.item_menu_character)));
        mListItems.add(new MenuItem(MenuType.History, R.drawable.ic_folder,
                getString(R.string.item_menu_history)));

        mMainView.menuChange(mListItems);
    }

    private String getString(int id) {
        return mMainView.context().getString(id);
    }

    public void onClickInfoView() {
        Log.d(TAG, "onClickInfoView: ");
        Intent intent = new Intent(mMainView.context(), InfoActivity.class);
        mMainView.context().startActivity(intent);
    }

    public void clickButtonVietMong() {
        Log.d(TAG, "clickButtonVietMong: ");
        Intent intent = new Intent(mMainView.context(), VietMongActivity.class);
        mMainView.context().startActivity(intent);
    }

    public void clickButtonMongViet() {
        Log.d(TAG, "clickButtonMongViet: ");
        Intent intent = new Intent(mMainView.context(), MongVietActivity.class);
        mMainView.context().startActivity(intent);
    }

    public void clickButtonCharacter() {
        Log.d(TAG, "clickButtonCharacter: ");
        Intent intent = new Intent(mMainView.context(), CharacterActivity.class);
        mMainView.context().startActivity(intent);
    }

    public void clickButtonHistory() {
        Log.d(TAG, "clickButtonHistory: ");
        Intent intent = new Intent(mMainView.context(), HistoryActivity.class);
        mMainView.context().startActivity(intent);
    }
}
