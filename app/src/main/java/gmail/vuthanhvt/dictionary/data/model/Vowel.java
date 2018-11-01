package gmail.vuthanhvt.dictionary.data.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Vowel (nguyên âm).
 */
public class Vowel {

    private String mVowel;

    private String mReading;

    public Vowel(String mVowel, String mReading) {
        this.mVowel = mVowel;
        this.mReading = mReading;
    }

    public String getVowel() {
        return mVowel;
    }

    public void setVowel(String mVowel) {
        this.mVowel = mVowel;
    }

    public String getReading() {
        return mReading;
    }

    public void setReading(String mReading) {
        this.mReading = mReading;
    }
}
