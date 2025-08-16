Initialization:

n: Length of the word.

freq: Array to store the frequency of each character.

currConsonant: Counter for the current number of consonants in the substring.

cnt: Counter for the valid substrings.

left: Left pointer for the sliding window.

Iterating through the word:

For each character ch in the word:

If ch is a consonant, increment currConsonant.

Increment the frequency of ch in freq.

Checking the conditions:

While the current substring contains at least k consonants and all vowels:

Increment cnt by the number of valid substrings ending at the current position.

Move the left pointer to reduce the window size.

Decrement the frequency of the character at the left pointer.

If the character is a consonant, decrement currConsonant.

This logic ensures that we count all substrings that meet the conditions specified in the problem.