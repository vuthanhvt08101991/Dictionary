package gmail.vuthanhvt.dictionary.screen.character;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BaseDataBindingActivity;
import gmail.vuthanhvt.dictionary.base.widgets.SmoothLayoutManager;
import gmail.vuthanhvt.dictionary.constant.ActivityCharacterType;
import gmail.vuthanhvt.dictionary.data.DataBaseHelper;
import gmail.vuthanhvt.dictionary.databinding.ActivityCharacterBinding;
import gmail.vuthanhvt.dictionary.screen.character.view.CharacterAdapter;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class CharacterActivity.
 */
public class CharacterActivity  extends BaseDataBindingActivity<ActivityCharacterBinding, CharacterPresenter>
        implements CharacterView {

    public static final String TAG = "CharacterActivity";

    private List<Object> mList;

    private CharacterAdapter mAdapter;

    private DataBaseHelper mDBHelper;

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_character;
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        mDBHelper = new DataBaseHelper(this);
        mPresenter = new CharacterPresenter(this);
        mAdapter = new CharacterAdapter(this);
        mBinding.listCharacter.setLayoutManager(new SmoothLayoutManager(context()));
        mBinding.setAdapter(mAdapter);
        mPresenter.loadData(ActivityCharacterType.VOWEL);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onClickBackView() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (mPresenter.isClickedMenuIcon.get()) {
            mPresenter.isClickedMenuIcon.set(false);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClickMenuView() {
        Log.d(TAG, "onClickMenuView: ");
    }

    @Override
    public void loadData( int type) {
        Log.d(TAG, "loadData: ");
        try {
            mList.clear();
            mDBHelper.createDatabase();
            mDBHelper.openDatabase();
            switch (mPresenter.mCharacterType) {
                case ActivityCharacterType.VOWEL:
                    mDBHelper.getAllTableCharacter(mList, "BANGNGUYENAM");
                    break;

                case ActivityCharacterType.CONSONANT:
                    mDBHelper.getAllTableCharacter(mList, "BANGPHUAM");
                    break;

                case ActivityCharacterType.RHYME:
                    mDBHelper.getAllTableCharacter(mList, "BANGVAN");
                    break;

                case ActivityCharacterType.TONE:
                    mDBHelper.getAllTableCharacter(mList, "BANGTHANHDIEU");
                    break;

                default:
                    break;
            }
            if (mList.size() == 0) {
                return;
            }
            mAdapter.refreshDataView(mList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
