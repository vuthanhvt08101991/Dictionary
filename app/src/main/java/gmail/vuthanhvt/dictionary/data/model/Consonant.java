package gmail.vuthanhvt.dictionary.data.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Consonant (phụ âm).
 */
public class Consonant {

    private String mConsonant;

    private String mReading;

    public Consonant(String mConsonant, String mReading) {
        this.mConsonant = mConsonant;
        this.mReading = mReading;
    }

    public String getConsonant() {
        return mConsonant;
    }

    public void setConsonant(String mIntonation) {
        this.mConsonant = mIntonation;
    }

    public String getReading() {
        return mReading;
    }

    public void setReading(String mReading) {
        this.mReading = mReading;
    }
}
