package gmail.vuthanhvt.dictionary.screen.mongviet.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gmail.vuthanhvt.dictionary.R;
import gmail.vuthanhvt.dictionary.data.model.MongViet;
import gmail.vuthanhvt.dictionary.databinding.DialogEditTextBinding;
import gmail.vuthanhvt.dictionary.screen.mongviet.MongVietActivity;
import gmail.vuthanhvt.dictionary.screen.vietmong.VietMongActivity;

/**
 * Create by FRAMGIA\vu.anh.thanh on 30/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class EditWordDialogFragment.
 */
public class EditWordDialogFragment extends DialogFragment {

    public static final String TAG = "EditWordDialogFragment";

    private onDialogPositiveClick mListener;
    private MongViet mMongVietItem;
    private Activity mActivity;
    private DialogEditTextBinding mBinding;
    public ObservableField<Boolean> mIsMongViet = new ObservableField<>(true);
    public ObservableField<String> mWordField = new ObservableField<>();
    public ObservableField<String> mMeaningOfWordField = new ObservableField<>();
    public ObservableField<String> mReadingField = new ObservableField<>();

    public void setListener(onDialogPositiveClick mListener) {
        this.mListener = mListener;
    }

    public interface onDialogPositiveClick {
        void onDialogPositiveClick(MongViet item);
    }

    public static EditWordDialogFragment newInstance(Bundle data) {
        EditWordDialogFragment dialog = new EditWordDialogFragment();
        dialog.setArguments(data);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMongVietItem = (MongViet) getArguments().getSerializable("ITEM_CHOSEN");
        if (mMongVietItem == null) {
            return;
        }
        mActivity = getActivity();
        if (mActivity instanceof MongVietActivity) {
            mIsMongViet.set(true);
            mWordField.set(mMongVietItem.getHMongWord());
            mMeaningOfWordField.set(mMongVietItem.getVietnameseWord());
            mReadingField.set(mMongVietItem.getReading());
        } else if (mActivity instanceof VietMongActivity) {
            mIsMongViet.set(false);
            mWordField.set(mMongVietItem.getVietnameseWord());
            mMeaningOfWordField.set(mMongVietItem.getHMongWord());
            mReadingField.set(mMongVietItem.getReading());
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(getActivity().getLayoutInflater(),
                R.layout.dialog_edit_text, null, false);
        mBinding.setDialog(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mBinding.getRoot())
                .setPositiveButton("Confirm",  new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mListener != null
                                && !TextUtils.isEmpty(mBinding.meaningOfWord.getText().toString())
                                && !TextUtils.isEmpty(mBinding.reading.getText().toString())) {
                            mMongVietItem.setVietnameseWord(mIsMongViet.get() ?
                                    mBinding.meaningOfWord.getText().toString() : mWordField.get());
                            mMongVietItem.setHMongWord(mIsMongViet.get() ?
                                    mWordField.get() : mBinding.meaningOfWord.getText().toString());
                            mMongVietItem.setReading(mBinding.reading.getText().toString());
                            mListener.onDialogPositiveClick(mMongVietItem);
                        } else {
                            if (TextUtils.isEmpty(mBinding.meaningOfWord.getText().toString())) {
                                mBinding.meaningOfWord.setError("The meaning of word isn't null.");
                            }
                        }
                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }
}
