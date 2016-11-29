package tech.linard.android.estabelecimentosdesaude.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tech.linard.android.estabelecimentosdesaude.R;

/**
 * Created by lucas on 26/11/16.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String LOG_TAG = BaseActivity.class.getName();
    protected FirebaseAuth mAuth;
    protected FirebaseAuth.AuthStateListener mAuthListener;
    protected FirebaseUser mUser;
    public ProgressDialog mProgressDialog;

    protected boolean isLogged() {
        boolean value = false;
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        if (mUser != null) {
            // Not signed in, launch the Sign In activity
            value = true;
        }
        return value;
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
