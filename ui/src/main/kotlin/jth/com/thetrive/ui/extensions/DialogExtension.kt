package jth.com.thetrive.ui.extensions

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import jth.com.thetrive.ui.views.dialog.CustomDialogFragment
import jth.com.thetrive.ui.views.dialog.ProgressDialog

fun ProgressDialog.show(manager : FragmentManager) {
    show(manager, "progress")
}

fun ProgressDialog.close() {
    dismiss()
}

fun Activity.isActivityAvailable(): Boolean {
    return !isFinishing
}

fun Activity.showDlg(message: String) {
    if (this is FragmentActivity && this.isActivityAvailable()) {
        val fragmentManager = supportFragmentManager
        CustomDialogFragment(
            message = message,
            onPositiveButtonClick = {
                finish()
            }).show(fragmentManager, "dlg")
    }
}
