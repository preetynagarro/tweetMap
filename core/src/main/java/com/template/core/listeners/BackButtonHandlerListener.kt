package com.template.core.listeners

/**
 * Back button handler interface. Add/remove listener functionality

 */
interface BackButtonHandlerListener {
    fun addBackpressListener(listner: BackPressListener)
    fun removeBackpressListener(listner: BackPressListener)
}