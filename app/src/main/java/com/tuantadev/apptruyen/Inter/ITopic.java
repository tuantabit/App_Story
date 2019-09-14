package com.tuantadev.apptruyen.Inter;


import com.tuantadev.apptruyen.UI.Topic;

public interface ITopic {
    int getSize();
    Topic getTopic(int position);
    void onClick(int position);
}
