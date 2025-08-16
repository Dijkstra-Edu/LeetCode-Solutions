# Leetcode Problem #14: Longest Common Prefix (Easy)

## Problem 

Given an array of strings `strs`, return the **longest common prefix** string amongst them.  
If there is no common prefix, return an **empty string**.

---

## Approach

- Start with the first string as the **initial prefix**.
- Compare it with the next string:
  - If the current string doesn't start with the prefix, **trim the prefix** by one character from the end.
  - Repeat until it matches or becomes an empty string.
- Continue this for all strings in the list.

---




