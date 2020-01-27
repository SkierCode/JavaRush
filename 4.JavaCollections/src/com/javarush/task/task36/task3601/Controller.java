package com.javarush.task.task36.task3601;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.List;

public class Controller {
    Model model = new Model();

    public List<String> onShowDataList() {
        return model.getStringDataList();
    }
}
