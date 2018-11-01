package gmail.vuthanhvt.dictionary.base.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import gmail.vuthanhvt.dictionary.base.view.BaseDialog;

import gmail.vuthanhvt.dictionary.R;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class base activity for application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private BaseDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (enableTransaction()) {
            overridePendingTransition(R.anim.enter_from_right, 0);
        }
        super.onCreate(savedInstanceState);
    }

    public abstract boolean enableTransaction();

    public void showOrHideDialog(final boolean show) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (show) {
                        if (mDialog != null && mDialog.isShowing()) {
                            return;
                        }
                        mDialog = new BaseDialog(BaseActivity.this);
                        if (!isFinishing()) {
                            mDialog.show();
                        }
                    } else {
                        if (mDialog == null || !mDialog.isShowing()) {
                            return;
                        }
                        mDialog.dismiss();
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (enableTransaction()) {
            overridePendingTransition(0, R.anim.exit_to_right);
        }
    }

    public void startAnimationFinish() {
        overridePendingTransition(0, R.anim.exit_to_right);
    }
}
