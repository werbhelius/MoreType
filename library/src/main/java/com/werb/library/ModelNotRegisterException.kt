package com.werb.library


/**
 * Created by wanbo on 2017/7/6.
 */
class ModelNotRegisterException(className: String) : RuntimeException("Do you have registered the moreViewType for $className.class in the adapter?")