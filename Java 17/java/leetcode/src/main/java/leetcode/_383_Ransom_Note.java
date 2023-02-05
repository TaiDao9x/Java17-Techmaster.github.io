package leetcode;

public class _383_Ransom_Note {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int checkExist = -1;
        for (int i = 0; i < ransomNote.length(); i++) {
            checkExist = magazine.indexOf(ransomNote.charAt(i));
            if (checkExist != -1) {
                magazine = magazine.substring(0, checkExist) + magazine.substring(checkExist + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }
}
