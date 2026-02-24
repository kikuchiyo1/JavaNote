package com.example.utils;

import java.util.List;

public class maopaoSort {
    public static void main(List<Integer> arr) {
        boolean pos = false;
        for (int i = 0; i < arr.size() - 1; i++) {
            for(int j = 0; j < arr.size() - i - 1; j++) {
                if(arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    pos = true;
                }
            }
            if(!pos) break;
        }
    }
}



