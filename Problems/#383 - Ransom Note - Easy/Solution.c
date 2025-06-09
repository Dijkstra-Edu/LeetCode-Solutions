bool canConstruct(char* ransomNote, char* magazine) {
    int ransom_count[26] = {0};
    int magazine_count[26] = {0};

    for (int i = 0; ransomNote[i] != '\0'; i++) {
        ransom_count[ransomNote[i] - 'a']++;
    }

    for (int i = 0; magazine[i] != '\0'; i++) {
        magazine_count[magazine[i] - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
        if (magazine_count[i] < ransom_count[i]) {
            return false;
        }
    }

    return true;
}