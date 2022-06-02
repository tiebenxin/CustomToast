package com.visteon.txzing.lib

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import java.lang.ref.WeakReference

/**
 * @author liszt
 * @date 2022/6/1 15:21
 * @describe
 */
class ToastImpl {
    private val xOffset = 0;
    private val yOffset = 20;
    private var toastRef: WeakReference<Toast>? = null
    var config: CustomToast.ToastConfig? = null
    private var mTextView: TextView? = null


    fun initToast(context: Context, msg: String) {
        if (TextUtils.isEmpty(msg)) {
            return
        }
        try {
            if (toastRef == null) {
                toastRef = WeakReference(Toast(context))
            }
            val toast: Toast = toastRef!!.get()!!
            val view = getView(context);
            toast.view = getView(context)

            mTextView = toast.view!!.findViewById(R.id.tv_msg)
            mTextView!!.text = msg
            val parameter = WindowManager.LayoutParams()
            parameter.type = WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG
            view.layoutParams = parameter
            if (config == null) {
                toast.setGravity(Gravity.BOTTOM, xOffset, yOffset)
                toast.duration = Toast.LENGTH_SHORT
            } else {
                toast.setGravity(config!!.gravity, config!!.xOffset, config!!.yOffset)
                toast.duration = config!!.duration
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun getView(context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_toast, null)
    }


    fun show() {
        if (toastRef != null && toastRef!!.get() != null) {
            toastRef!!.get()!!.show()
        }
    }

}