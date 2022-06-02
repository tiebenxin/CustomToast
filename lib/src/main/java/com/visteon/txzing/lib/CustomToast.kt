package com.visteon.txzing.lib

import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 * @author liszt
 * @date 2022/6/1 15:18
 * @describe
 */
class CustomToast {

    companion object {
        private var mToastImpl: ToastImpl = ToastImpl()

        fun initConfig(config: ToastConfig) {
            mToastImpl.config = config
        }

        // 默认短
        fun show(context: Context, msg: String) {
            mToastImpl.initToast(context, msg)
            mToastImpl.show()
        }

        fun showLong(context: Context, msg: String) {
            initConfig(ToastConfig().apply { duration = Toast.LENGTH_LONG })
            mToastImpl.initToast(context, msg)
            mToastImpl.show()
        }
    }


    class ToastConfig {
        var gravity: Int = Gravity.BOTTOM
        var duration: Int = Toast.LENGTH_SHORT
        var xOffset: Int = 0
        var yOffset: Int = 0
    }


}