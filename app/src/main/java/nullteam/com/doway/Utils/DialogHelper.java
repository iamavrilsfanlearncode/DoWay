package nullteam.com.doway.Utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.lang.ref.WeakReference;

public class DialogHelper {
    private static WeakReference<ProgressDialog> progressDialogRef;
    private static WeakReference<Context> contextRef;

    private static AlertDialog.Builder builder;


    public static void showProgressDialog(Context mContext, String msg) {
        contextRef = new WeakReference<>(mContext);

        if (contextRef.get() != null) {
            builder = new AlertDialog.Builder(contextRef.get());
        }

        if (progressDialogRef == null) {
            progressDialogRef = new WeakReference<>(new ProgressDialog(mContext));
        }

        if (!progressDialogRef.get().isShowing()) {
            progressDialogRef = new WeakReference<>(new ProgressDialog(mContext));
            progressDialogRef.get().setMessage(msg);
            progressDialogRef.get().show();
        }
    }

    public static void closeProgressDialog() {
        try {
            if (progressDialogRef != null) {
                progressDialogRef.get().dismiss();
                progressDialogRef = null;
            }
        } catch (Exception ignored) {
            progressDialogRef = null;
        }
    }
}
