import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        
        return Arrays.equals(arr, arr1);
    }
    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        System.out.println(anagram.isAnagram("listen", "silent")); 
        System.out.println(anagram.isAnagram("rat", "car")); 
    }
}

