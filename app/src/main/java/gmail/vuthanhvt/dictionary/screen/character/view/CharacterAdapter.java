package gmail.vuthanhvt.dictionary.screen.character.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gmail.vuthanhvt.dictionary.base.adapter.BaseRecyclerViewAdapterBinding;
import gmail.vuthanhvt.dictionary.base.adapter.BaseViewHolderBinding;
import gmail.vuthanhvt.dictionary.data.model.Consonant;
import gmail.vuthanhvt.dictionary.data.model.Rhyme;
import gmail.vuthanhvt.dictionary.data.model.Tone;
import gmail.vuthanhvt.dictionary.data.model.Vowel;
import gmail.vuthanhvt.dictionary.databinding.ItemCharacterBinding;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class CharacterAdapter.
 */
public class CharacterAdapter extends BaseRecyclerViewAdapterBinding<CharacterAdapter.CharacterHolder, Object> {

    public static final String TAG = "VietMongAdapter";

    private List<Object> mList;

    public CharacterAdapter(Context context) {
        super(context);
        mList = new ArrayList<>();
    }

    public void refreshDataView(List<Object> list) {
        Log.d(TAG, "refreshDataView: list.size() = " + list.size());
        mList.clear();
        mList.addAll(list);
        refreshData(mList);
    }

    @Override
    protected CharacterHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new CharacterHolder(ItemCharacterBinding.inflate(inflater, parent, false));
    }

    @Override
    public BaseViewHolderBinding onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolderBinding viewHolderBinding = null;
        viewHolderBinding = getViewHolder(parent, LayoutInflater.from(parent.getContext()));
        return viewHolderBinding;
    }

    @Override
    public void onBindViewHolder(BaseViewHolderBinding holder, int position) {
        Log.d("ThanhVA", "onBindViewHolder: position = " + position);
        Object item = mList.get(position);
        holder.bindData(item);
    }

    class CharacterHolder extends BaseViewHolderBinding<ItemCharacterBinding, Object> {

        public CharacterHolder(ItemCharacterBinding binding) {
            super(binding);
        }

        public void bindData(Object item) {
            mBinding.setItem(item);
            if (item instanceof Vowel) {
                Log.d(TAG, "bindData: item Vowel");
                mBinding.character.setText(((Vowel) item).getVowel());
                mBinding.reading.setText(((Vowel) item).getReading());
            } else if (item instanceof Consonant) {
                Log.d(TAG, "bindData: item Consonant");
                mBinding.character.setText(((Consonant) item).getConsonant());
                mBinding.reading.setText(((Consonant) item).getReading());
            } else if (item instanceof Rhyme) {
                Log.d(TAG, "bindData: item Rhyme");
                mBinding.character.setText(((Rhyme) item).getRhyme());
                mBinding.reading.setText(((Rhyme) item).getReading());
            } else if (item instanceof Tone) {
                Log.d(TAG, "bindData: item Tone");
                mBinding.character.setText(((Tone) item).getTone());
                mBinding.reading.setText(((Tone) item).getReading());
            }
        }
    }

}