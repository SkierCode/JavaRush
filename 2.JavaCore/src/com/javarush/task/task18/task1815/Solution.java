package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{
        TableInterface composite;

        public TableInterfaceWrapper(TableInterface composite) {
            this.composite = composite;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            composite.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return composite.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            composite.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}