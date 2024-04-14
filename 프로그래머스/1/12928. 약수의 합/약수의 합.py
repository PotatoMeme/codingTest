import math

def solution(n):
    result = list()
    for i in range(1, int(math.sqrt(n))+1):
        if n % i == 0:
            result.append(i)
            result.append(n/i)
    answer = sum(set(result))
    return int(answer)
