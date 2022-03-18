package com.doubleclick

import com.doubleclick.marktinhome.Model.Cart

/**
 * Created By Eslam Ghazy on 3/12/2022
 */
interface OnCartLisnter {

    fun OnAddItemOrder(cart: Cart?)
    fun OnMinsItemOrder(cart: Cart?)
    fun OnDeleteItemOrder(cart: Cart?)

}