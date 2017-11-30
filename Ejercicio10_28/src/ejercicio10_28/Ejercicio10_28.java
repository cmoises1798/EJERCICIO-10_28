/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10_28;

/**
 *
 * @author user
 */
public class Ejercicio10_28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] chars = {'I', 'n', 's', 'e', 'r', 't'}; 

		// Create two MyStringBuilder2 objects
		MyStringBuilder2 str1 = new MyStringBuilder2("testString");
		MyStringBuilder2 str2 = new MyStringBuilder2(chars);

		// Insert str2 into str1 at index 3
		System.out.print("\nInsert string 2 into string 1 at index 3: ");
		MyStringBuilder2 str3 = str1.insert(3, str2);
		System.out.println(str3);

		// Reverse str1
		System.out.println("\nReverse string 1: " + str1.reverse());

		// Create a substring of str3 from index 10
		System.out.println("\nSubstring of string 3 beginning index 10: " + 
			str3.substring(10));

		// Display str2 in all upper case
		System.out.println("\nString 2 to upper case: " + str2.toUpperCase());
	
    }
    
}
