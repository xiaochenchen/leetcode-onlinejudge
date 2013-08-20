leetcode-onlinejudge
====================
record the problems solved on leetcode onlinejudge

(1) Longest Substring Without Repeating Characters:

Brute Force O(n^2): start from each of the n characters, find the longest substring without repeating characters for all of them

O(n) solution:          scan one character at a time
                        track the head and length of current longest substring without repeating characters(clswrc)
                        if the next scanned character exists in the current clswrc
                        move head to the first character after the former occurence of the repeating character

(2) Longest Palindrome Substring

Brute Force O(n^3): loop through all substrings, check if they are palindrome

Dynamic Programming O(n^2):
    base case:
        length 1: p(i, i) = true
        length 2: p(i, i+1) = true if S(i) == S(i+1)
    matrix calculation:
        p(i, j) = true if p(i+1, j-1) == true and S(i) == S(j)

Expand Around Center O(n^2):
    A palindrome mirrors around its center.
	Therefore a palindrome can be expanded from its center.

	The center could be a letter or between two letters.
	There are in total 2N - 1 such centers.	=> O(N)

	Expand from each center and find the longest palindrome.	=> O(n)