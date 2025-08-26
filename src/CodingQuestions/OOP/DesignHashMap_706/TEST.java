package CodingQuestions.OOP.DesignHashMap_706;

import java.util.Arrays;

public class TEST {

        int [] map;
        public TEST() {
            map = new int [1000001];
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;

        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }

}
