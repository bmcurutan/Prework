/*
 * In C, a string "Hello World" is stored such as ['h','e','l','l','o',' ','w','o','r','l','d','\0']
 * Return a new string, with ' ' replaced by '%','2','0'
 * Do not use any build in string functions other than string[i]
 * Do this in place, assume the string length is large enough to accommodate the extra characters
 */

public class ReplaceSpacesInCString {
    // Pre: string != null
    public static char[] replaceSpaces(char[] string) {
        int spaces = 0;
        int i = 0;
        while (string[i] != '0') {
            if (string[i] == ' ') {
                spaces++;
            }
            i++;
        }
        // i+1 is now the length of the string

        for (int j = i; j >= 0; j--) {
            if (string[j] != ' ') {
                string[j + spaces*2] = string[j];
            } else {
                string[j + spaces*2] = '0';
                string[j + spaces*2 - 1] = '2';
                string[j + spaces*2 - 2] = '%';
                spaces--;
            }
        }

        return string;
    }

    // For testing only
    private static void print(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // In the tests, # will be used to denote an available space, and 0 will represent \0
        char[] test0 = {'0'};
        print(replaceSpaces(test0)); //

        char[] test1 = {'h', 'e', 'l', 'l', 'o', '0'};
        print(replaceSpaces(test1)); // hello0

        char[] test2 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '0', '#', '#'};
        print(replaceSpaces(test2)); // hello%20world0

        char[] test3 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'a', 'g', 'a', 'i', 'n', '0', '#', '#', '#', '#'};
        print(replaceSpaces(test3)); // hello%20world%20again0
    }
}
