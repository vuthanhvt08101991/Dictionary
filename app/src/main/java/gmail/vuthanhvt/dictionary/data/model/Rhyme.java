package gmail.vuthanhvt.dictionary.data.model;

/**
 * Create by FRAMGIA\vu.anh.thanh on 29/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class Rhyme (vần tiếng).
 */
public class Rhyme {

    private String mRhyme;

    private String mReading;

    public Rhyme(String mRhyme, String mReading) {
        this.mRhyme = mRhyme;
        this.mReading = mReading;
    }

    public String getRhyme() {
        return mRhyme;
    }

    public void setRhyme(String mRhyme) {
        this.mRhyme = mRhyme;
    }

    public String getReading() {
        return mReading;
    }

    public void setReading(String mReading) {
        this.mReading = mReading;
    }
}
