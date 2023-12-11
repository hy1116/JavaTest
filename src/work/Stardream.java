package work;

import java.util.*;
import java.util.stream.Collectors;

public class Stardream {
    public String[] getKbIds() throws Exception {
        List<String> advList = new ArrayList<>();
        advList.add("cyflElDMOlAixB2PH05QJg==");
        advList.add("wOyo8IyfDiiy+DOE6vLRHg==");

        List<HashMap<String,String>> somap = new ArrayList<>();
        HashMap<String,String> hash = new HashMap<>();
        hash.put("CODE","cyflElDMOlAixB2PH05QJg==");
        hash.put("NAME","스타드림 룰렛");
        somap.add(hash);

        HashMap<String,String> hash2 = new HashMap<>();
        hash2.put("CODE","wOyo8IyfDiiy+DOE6vLRHg==");
        hash2.put("NAME","무정산 쿠폰");
        somap.add(hash2);

        Map<String,String> advmap = new HashMap<>();
        somap.stream().collect(Collectors.toMap(a->a.get("CODE"),b->b.get("NAME")));
        String[] arr = somap.stream().map(a->a.get("CODE")).toArray(String[]::new);

        return arr;
    }
}
