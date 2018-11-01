package gmail.vuthanhvt.dictionary.screen.character;

import android.databinding.ObservableField;
import android.util.Log;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.base.screen.BasePresenter;
import gmail.vuthanhvt.dictionary.constant.ActivityCharacterType;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class CharacterPresenter.
 */
public class CharacterPresenter implements BasePresenter {

    public static final String TAG = "CharacterPresenter";

    private CharacterView mCharacterView;

    public ObservableField<Boolean> isClickedMenuIcon = new ObservableField<>(false);

    public ObservableField<String> mTableName = new ObservableField<>("");

    public ObservableField<String> mCharacterCol = new ObservableField<>("");

    public int mCharacterType;

    public CharacterPresenter(CharacterView mCharacterView) {
        this.mCharacterView = mCharacterView;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    public void onClickBackView() {
        Log.d(TAG, "onClickBackView: ");
        mCharacterView.onClickBackView();
    }

    public void onClickMenuView() {
        Log.d(TAG, "onClickMenuView: ");
        isClickedMenuIcon.set(!isClickedMenuIcon.get());
        mCharacterView.onClickMenuView();
    }

    public void onClickItemVowel() {
        Log.d(TAG, "onClickItemVowel: ");
        mTableName.set(mCharacterView.context().getString(R.string.menu_character_vowwel));
        mCharacterCol.set(mCharacterView.context().getString(R.string.vowel_col));
        mCharacterType = ActivityCharacterType.VOWEL;
        mCharacterView.loadData(ActivityCharacterType.VOWEL);
        isClickedMenuIcon.set(false);
    }

    public void onClickItemConsonant() {
        Log.d(TAG, "onClickItemConsonant: ");
        mTableName.set(mCharacterView.context().getString(R.string.menu_character_consonant));
        mCharacterCol.set(mCharacterView.context().getString(R.string.consonant_col));
        mCharacterType = ActivityCharacterType.CONSONANT;
        mCharacterView.loadData(ActivityCharacterType.CONSONANT);
        isClickedMenuIcon.set(false);
    }

    public void onClickItemRhyme() {
        Log.d(TAG, "onClickItemRhyme: ");
        mTableName.set(mCharacterView.context().getString(R.string.menu_character_rhyme));
        mCharacterCol.set(mCharacterView.context().getString(R.string.rhyme_col));
        mCharacterType = ActivityCharacterType.RHYME;
        mCharacterView.loadData(ActivityCharacterType.RHYME);
        isClickedMenuIcon.set(false);
    }

    public void onClickItemTone() {
        Log.d(TAG, "onClickItemTone: ");
        mTableName.set(mCharacterView.context().getString(R.string.menu_character_tone));
        mCharacterCol.set(mCharacterView.context().getString(R.string.tone_col));
        mCharacterType = ActivityCharacterType.TONE;
        mCharacterView.loadData(ActivityCharacterType.TONE);
        isClickedMenuIcon.set(false);
    }
    
    public void loadData(int type) {
        Log.d(TAG, "loadData: ");
        switch (type) {
            case ActivityCharacterType.VOWEL:
                mTableName.set(mCharacterView.context().getString(R.string.menu_character_vowwel));
                mCharacterCol.set(mCharacterView.context().getString(R.string.vowel_col));
                mCharacterType = ActivityCharacterType.VOWEL;
                break;

            case ActivityCharacterType.CONSONANT:
                mTableName.set(mCharacterView.context().getString(R.string.menu_character_consonant));
                mCharacterCol.set(mCharacterView.context().getString(R.string.consonant_col));
                mCharacterType = ActivityCharacterType.CONSONANT;
                break;

            case ActivityCharacterType.RHYME:
                mTableName.set(mCharacterView.context().getString(R.string.menu_character_rhyme));
                mCharacterCol.set(mCharacterView.context().getString(R.string.rhyme_col));
                mCharacterType = ActivityCharacterType.RHYME;
                break;

            case ActivityCharacterType.TONE:
                mTableName.set(mCharacterView.context().getString(R.string.menu_character_tone));
                mCharacterCol.set(mCharacterView.context().getString(R.string.tone_col));
                mCharacterType = ActivityCharacterType.TONE;
                break;

            default:
                break;

        }
        mCharacterView.loadData(type);
    }
}
