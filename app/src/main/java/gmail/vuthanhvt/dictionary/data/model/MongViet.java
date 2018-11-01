package gmail.vuthanhvt.dictionary.data.model;

import java.io.Serializable;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class model MongViet.
 */
public class MongViet implements Serializable {

    private String mVietnameseWord;

    private String mHMongWord;

    private String mReading;

    public MongViet(String mVietnameseWord, String mHMongWord, String mReading) {
        this.mVietnameseWord = mVietnameseWord;
        this.mHMongWord = mHMongWord;
        this.mReading = mReading;
    }

    public String getVietnameseWord() {
        return mVietnameseWord;
    }

    public void setVietnameseWord(String mVietnameseWord) {
        this.mVietnameseWord = mVietnameseWord;
    }

    public String getHMongWord() {
        return mHMongWord;
    }

    public void setHMongWord(String mHMongWord) {
        this.mHMongWord = mHMongWord;
    }

    public String getReading() {
        return mReading;
    }

    public void setReading(String mReading) {
        this.mReading = mReading;
    }
}
