package leetcode;

public class _387_First_Unique_Character_in_a_String {
    public static int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        // bắt đầu từ 'a' kết thúc tại 'z'
        //index a= 0, z=25
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            alphabet[character - 'a']++; // index tương ứng
        }// đếm được số lần xuất hiện của tất cả các ký tự trong s

        for (int i = 0; i < s.length(); i++) { // bắt đầu đếm
            char character = s.charAt(i);
            if (alphabet[character - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "baccddee";
        System.out.println(firstUniqChar(s));
    }
}
