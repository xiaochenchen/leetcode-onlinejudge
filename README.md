leetcode-onlinejudge
====================
record the problems solved on leetcode onlinejudge

1. Longest Substring Without Repeating Characters:
------

* Brute Force O(n^2):
> start from each of the n characters, find the longest substring without repeating characters for all of them

* O(n) solution:
> 1. scan one character at a time
> 2. track the head and length of current longest substring without repeating characters(clswrc)
> 3. if the next scanned character exists in the current clswrc
> 4. move head to the first character after the former occurence of the repeating character

2. Longest Palindrome Substring
------

* Brute Force O(n^3):
> loop through all substrings, check if they are palindrome

* Dynamic Programming O(n^2):
> * base case:
>   * length 1: p(i, i) = true
>   * length 2: p(i, i+1) = true if S(i) == S(i+1)
> * matrix calculation:
>   * p(i, j) = true if p(i+1, j-1) == true and S(i) == S(j)

* Expand Around Center O(n^2):
> 1. A palindrome mirrors around its center. Therefore a palindrome can be expanded from its center.
> 2. The center could be a letter or between two letters. There are in total 2N - 1 such centers.	=> O(N)
> 3. Expand from each center and find the longest palindrome.	=> O(n)

* Manacher Algorithm O(n):
> 1. Let C denotes the center of current maximum palindrome, R denotes the right border of the current maximum palindrome and i is the current index we are calculation the palindrome centered at i, i' is i's mirror over C
>   * `if P[i'] < R - i`
>   * `then P[i] <- P[i']`
>   * `else R - i // of course 0 on border cases`
> 2. try to grow P[i] by comparing whether S[i- P[i] - 1] = S[i + P[i] + 1]
>   * `if i + P[i] grows beyond R, move C and R so that`
>   * `C = i;`
>   * `R = i + P[i];`

3. Regular Expression Matching
------

* Recursive:
    If the next character of p is NOT ‘*’, then it must match the current character of s.
    Continue pattern matching with the next character of both s and p.
    If the next character of p is ‘*’, then we do a brute force exhaustive matching of 0, 1,
    or more repeats of current character of p… Until we could not match any more characters.
