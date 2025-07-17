package CodingQuestions.Lib;


    public class Pair<K, V> {

        public final K element0;
        public final V element1;

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getKey() {
            return element0;
        }

        public V getValue() {
            return element1;
        }


}
