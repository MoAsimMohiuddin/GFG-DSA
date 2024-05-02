def min_vehicles(weights, max_limit):
    weights.sort()  # Sort the weights in ascending order
    left, right = 0, len(weights) - 1
    vehicles = 0

    while left <= right:
        if weights[left] + weights[right] <= max_limit:
            left += 1
        right -= 1
        vehicles += 1

    return vehicles

# Input from the user
weights = list(map(int, input("Enter the weights of bananas in godown (separated by space): ").split()))
max_limit = int(input("Enter the maximum weight limit for each vehicle (in tons): "))

# Calculate and display the result
result = min_vehicles(weights, max_limit)
print(f"The minimum number of vehicles needed is: {result}")