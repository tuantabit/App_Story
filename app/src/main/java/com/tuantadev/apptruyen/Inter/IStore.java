package com.tuantadev.apptruyen.Inter;

import com.tuantadev.apptruyen.UI.Store;

public interface IStore {
    int getSize();
    Store getStore(int position);
    void onClick(int position);
}
