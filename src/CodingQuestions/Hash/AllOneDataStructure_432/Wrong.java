package CodingQuestions.Hash.AllOneDataStructure_432;

import java.util.TreeMap;

public class Wrong {
    TreeMap<String, Integer> map;

    public static void main(String[] args) {
//            String[] operations = {"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"};
//            Object[][] inputs = {
//                    {},
//                    {"hello"},
//                    {"hello"},
//                    {},
//                    {},
//                    {"leet"},
//                    {},
//                    {}
//            };
        String[] operations = {"AllOne", "inc", "inc", "inc", "inc", "getMaxKey", "inc", "inc", "inc", "dec", "inc", "inc", "inc", "getMaxKey"};
        Object[][] inputs = {
                {},
                {"hello"},
                {"goodbye"},
                {"hello"},
                {"hello"},
                {},
                {"leet"},
                {"code"},
                {"leet"},
                {"hello"},
                {"leet"},
                {"code"},
                {"code"},
                {}
        };

        Wrong allOne = null;

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "AllOne":
                    allOne = new Wrong();
                    System.out.println("AllOne initialized");
                    break;
                case "inc":
                    allOne.inc((String) inputs[i][0]);
                    System.out.println("inc(" + inputs[i][0] + ")");
                    break;
                case "dec":
                    allOne.dec((String) inputs[i][0]);
                    System.out.println("dec(" + inputs[i][0] + ")");
                    break;
                case "getMaxKey":
                    System.out.println("getMaxKey() -> " + allOne.getMaxKey());
                    break;
                case "getMinKey":
                    System.out.println("getMinKey() -> " + allOne.getMinKey());
                    break;
            }
        }
    }


    public Wrong() {
     map =  new TreeMap<>();
    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public void dec(String key) {
        if (map.get(key) == 1) map.remove(key);
        map.put(key, map.get(key) - 1);
    }

    public String getMaxKey() {
        if (map.size() == 0) return "";
        return map.lastKey();
    }

    public String getMinKey() {
        if (map.size() == 0) return "";
        return map.firstKey();
    }
}
