def solution(n):
    word = list(int(i) for i in str(n))
    word.sort()
    answer = 0
    for i in range(len(word)):
        answer += word[i]*10**i
    return answer