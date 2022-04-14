package com.doubleclick.marktinhome.Views.RichEditor.interfaces;


import com.doubleclick.richeditor.ActionType;

/**
 * OnActionPerformListener
 *
 * @author even.wu
 * @date 17/8/17
 */

public interface OnActionPerformListener {
    void onActionPerform(ActionType type, Object... values);
}
