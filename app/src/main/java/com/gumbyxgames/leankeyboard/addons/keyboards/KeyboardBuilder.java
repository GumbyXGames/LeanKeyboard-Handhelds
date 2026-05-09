package com.gumbyxgames.leankeyboard.addons.keyboards;

import android.inputmethodservice.Keyboard;

public interface KeyboardBuilder {
    Keyboard createAbcKeyboard();
    Keyboard createSymKeyboard();
    Keyboard createNumKeyboard();
}
