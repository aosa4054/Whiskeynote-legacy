package io.github.aosa4054.whiskeynote.addeditwhiskey

import io.github.aosa4054.whiskeynote.data.entity.Whiskey

interface AddEditWhiskeyNavigator{
    fun chooseWhiskeyType()
    //fun toastError()
    fun getViewData(): Whiskey
    fun backToList(): Boolean
}