class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res = new ArrayList<>();
        
        for (int a : asteroids) {
            boolean exploded = false;
            
            while (!res.isEmpty() && a < 0 && res.get(res.size() - 1) > 0) {
                int lastAsteroid = res.get(res.size() - 1);
                
                if (-a > lastAsteroid) {
                    res.remove(res.size() - 1);
                    continue;
                } else if (-a == lastAsteroid) {
                    res.remove(res.size() - 1);
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            
            if (!exploded) {
                res.add(a);
            }
        }
        
        // Convert List to array
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
