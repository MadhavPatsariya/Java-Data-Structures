package Graph;

import java.util.*;

public class FindRecipes {
    public static void main(String[] args) {
        FindRecipes findRecipes = new FindRecipes();
        String[] recipes = {"bread","sandwich","burger"};
        String[] supplies = {"yeast","flour","meat"};
        String[][] ingredients = {
                {"yeast", "flour"},
                {"bread", "meat"},
                {"sandwich", "meat", "bread"}
        };
        List<List<String>> ingredientsList = new ArrayList<>();
        for (String[] arr : ingredients) {
            ingredientsList.add(Arrays.asList(arr));
        }
        List<String> result = findRecipes.findAllRecipes(recipes, ingredientsList, supplies);
        System.out.println(result);
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String raw : supplies) {
            queue.offer(raw);
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            set.add(recipe);
            for(String ingredient : ingredients.get(i)) {
                map.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
            if(!map.containsKey(recipe)) {
                map.put(recipe, new ArrayList<>());
            }
        }
        Map<String, Integer> indegree = new HashMap<>();
        for(String raw : supplies) {
            indegree.put(raw, 0);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            for(String val : entry.getValue()) {
                indegree.put(val, indegree.getOrDefault(val, 0) + 1);
            }
        }
        List<String> list = new ArrayList();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String current = queue.poll();
                if(set.contains(current)) {
                    list.add(current);
                }
                for(String related : map.get(current)) {
                    int in = indegree.get(related);
                    if(in > 0) {
                        in = in - 1;
                        if(in == 0) {
                            queue.offer(related);
                        }
                        indegree.put(related, in);
                    }
                }
            }
        }
        return list;
    }
}
