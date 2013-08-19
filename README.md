leetcode-onlinejudge
====================
record the problems solved on leetcode onlinejudge

Longest Substring Without Repeating Characters:

Brute Force: start from each of the n characters, find the longest substring without repeating characters for all of them

O(n) solution:         scan one character at a time
                       track the head and length of current longest substring without repeating characters(clswrc)
                       if the next scanned character exists in the current clswrc
                       move head to the first character after the former occurence of the repeating character