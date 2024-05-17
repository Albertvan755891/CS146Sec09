class Anagram:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s)==sorted(t)

def main():
    anagram = Anagram()

    # Test cases
    print(anagram.isAnagram("listen", "silent"))  
    print(anagram.isAnagram("rat", "car"))       

if __name__ == "__main__":
    main()
