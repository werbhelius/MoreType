package com.werb.library.exception

/**
 * Created by wanbo on 2017/7/12.
 */
class MultiModelNotRegisterException(className: String)
    : RuntimeException("$className.class has another viewType and you not register , checkout multiRegister() with $className.class")