package com.werb.library.exception

/**
 * Created by wanbo on 2018/8/6.
 */
class ViewHolderInitErrorException(viewHolderName: String, stackMessage: String): RuntimeException("$viewHolderName reflect init error , error message is $stackMessage")