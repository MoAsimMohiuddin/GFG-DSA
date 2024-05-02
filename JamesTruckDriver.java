import java.util.*;

class City {
    String name;
    int goods;
    int tax;

    public City(String name, int goods, int tax) {
        this.name = name;
        this.goods = goods;
        this.tax = tax;
    }
}

public class JamesTruckDriver {
    static Map<String, List<City>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static List<String> route = new ArrayList<>();
    static int totalTax = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N - 1; i++) {
            String city1 = scanner.next();
            String city2 = scanner.next();
            int goods = scanner.nextInt();
            int tax = scanner.nextInt();

            graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(new City(city2, goods, tax));
            graph.computeIfAbsent(city2, k -> new ArrayList<>()).add(new City(city1, goods, tax));
        }

        dfs("hyderabad");

        String routeMap = String.join("-", route);
        System.out.println(routeMap);
        System.out.println(totalTax);
    }

    static void dfs(String city) {
        visited.add(city);
        route.add(city);

        List<City> neighbors = new ArrayList<>(graph.getOrDefault(city, Collections.emptyList()));
        neighbors.sort((a, b) -> {
            if (b.goods != a.goods) {
                return Integer.compare(b.goods, a.goods);
            } else if (b.tax != a.tax) {
                return Integer.compare(a.tax, b.tax);
            } else {
                return a.name.compareTo(b.name);
            }
        });

        for (City neighbor : neighbors) {
            if (!visited.contains(neighbor.name)) {
                totalTax += neighbor.tax;
                dfs(neighbor.name);
                route.add(city);
            }
        }
    }
}
