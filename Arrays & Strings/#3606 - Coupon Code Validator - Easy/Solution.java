class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> validCategories = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        Map<String, Integer> categoryOrder = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        List<String[]> validList = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&
                validCategories.contains(businessLine[i]) &&
                code[i] != null && !code[i].isEmpty() &&
                code[i].matches("[a-zA-Z0-9_]+")) {
                validList.add(new String[]{businessLine[i], code[i]});
            }
        }

        validList.sort((a, b) -> {
            int cmp = Integer.compare(categoryOrder.get(a[0]), categoryOrder.get(b[0]));
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] item : validList) {
            result.add(item[1]);
        }

        return result;
    }
}