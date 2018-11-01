package gmail.vuthanhvt.dictionary.data.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 26/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Tone (Thanh điệu).
 */
public class Tone {

    private String mTone;

    private String mReading;

    public Tone(String mTone, String mReading) {
        this.mTone = mTone;
        this.mReading = mReading;
    }

    public String getTone() {
        return mTone;
    }

    public void setTone(String mIntonation) {
        this.mTone = mIntonation;
    }

    public String getReading() {
        return mReading;
    }

    public void setReading(String mReading) {
        this.mReading = mReading;
    }
}
