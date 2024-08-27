import matplotlib.pyplot as plt
import numpy as np

executionTimes = [
    [42700, 1499600, 35016100, 703933300, 2759245500],
    [60500, 307700, 1025900, 6043400, 12138200],
    [140500, 3579600, 86943900, 10556093700, 42063408400],
    [43500, 395800, 1184500, 12156000, 27065300],
    [54800, 2256700, 20101900, 2049324600, 8976588100],
    [21400, 392300, 2787200, 10136900, 24841300]
]
execution_times = np.array(executionTimes)
array_sizes = [1000, 2000, 5000, 10000, 20000]
algorithms = ["Insertion Sort", "Quick Sort", "Bubble Sort", "Merge Sort", "Selection Sort", "Shell Sort"]
plt.figure(figsize=(10, 6))
for i, algo in enumerate(algorithms):
    plt.plot(array_sizes, execution_times[i], label=algo, marker='o')

plt.xlabel("Array Size")
plt.ylabel("Execution Time (ns)")
plt.title("Sorting Algorithm Comparison")
plt.legend()
plt.grid(True)
plt.xscale('log')  
plt.yscale('log')  
plt.show()