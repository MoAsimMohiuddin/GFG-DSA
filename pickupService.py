from collections import defaultdict

def dfs(city, visited, path, total_tax):
    visited[city] = True
    path.append(city)
    
    neighbors = sorted(adj_list[city], key=lambda x: (-goods[x], entry_tax[x], x))
    
    for neighbor in neighbors:
        if not visited[neighbor]:
            total_tax += entry_tax[neighbor]
            total_tax = dfs(neighbor, visited, path, total_tax)
    
    return total_tax

def min_tax_route(start_city):
    visited = {city: False for city in adj_list}
    path = []
    total_tax = dfs(start_city, visited, path, 0)
    
    return path, total_tax

# Input
n = int(input())
adj_list = defaultdict(list)
goods = {}
entry_tax = {}

for _ in range(n-1):
    city1, city2, goods_count, tax = input().split()
    city1, city2 = city1.lower(), city2.lower()  # Convert city names to lowercase
    adj_list[city1.lower()].append(city2.lower())
    adj_list[city2.lower()].append(city1.lower())
    goods[city2.lower()] = int(goods_count)
    entry_tax[city2.lower()] = int(tax)

# Starting city
start_city = list(adj_list.keys())[0]

# Find the route and minimum tax
route, total_tax = min_tax_route(start_city)

# Print output
print('-'.join(route))
print(total_tax)
