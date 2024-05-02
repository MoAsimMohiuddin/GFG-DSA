import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SoloRider {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Passenger> p = new HashMap<>();
        Map<String, Vehicle> v = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            p.put(name, new Passenger(name, x, y));
        }

        for (int i = 0; i < m; i++) {
            String id = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            v.put(id, new Vehicle(id, x, y));
        }

        PriorityQueue<Passenger> pq = new PriorityQueue<>(Comparator.comparing(Passenger::getName));
        pq.addAll(p.values());

        Map<Passenger, Vehicle> assignments = new HashMap<>();

        while (!pq.isEmpty()) {
            Passenger passenger = pq.poll();

            Vehicle nv = null;
            int minDistance = Integer.MAX_VALUE;

            for (Vehicle vehicle : v.values()) {
                if (assignments.containsKey(vehicle)) {
                    continue;
                }

                int distance = md(passenger.x, passenger.y, vehicle.x, vehicle.y);

                if (distance == minDistance) {
                    if (nv == null || nv.id.compareTo(vehicle.id) > 0) {
                        nv = vehicle;
                    }
                } else if (distance < minDistance) {
                    minDistance = distance;
                    nv = vehicle;
                }
            }

            assignments.put(passenger, nv);
            v.remove(nv.id);
        }

        int td = 0;
        for (Map.Entry<Passenger, Vehicle> entry : assignments.entrySet()) {
            Passenger passenger = entry.getKey();
            Vehicle vehicle = entry.getValue();

            td += md(passenger.x, passenger.y, vehicle.x, vehicle.y);
        }

        System.out.print(td);
    }

    private static int md(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Passenger {
        String name;
        int x;
        int y;

        public Passenger(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return name;
        }
    }

    static class Vehicle {
        String id;
        int x;
        int y;

        public Vehicle(String id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}