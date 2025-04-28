/*
name:Matthew Marks   
Date:3/25/2023
*
*
*
* Description:You want to create an app to encrypt the text messages that you send to your friends. Once your friend
gets the message, the message should be decrypted so that your friend understands it. 
*
*
*/
import java.util.Scanner;

public class EncryptMarks
{

   public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		run(kb);	
	}
	
	public static void run(Scanner kb) {
		System.out.print("How many times you want to use the app:");
		int n = kb.nextInt();
		kb.nextLine();
		for(int i = 0; i < n; i++)
		{
			System.out.print("Your message? ");
			String msg = kb.nextLine();
			System.out.print("Encoding key? ");
			int key = kb.nextInt();
			kb.nextLine();
			String enc = encrypt(msg, key);
			System.out.println("The encrypted message is:\n" + enc);
			String dec = decrypt(enc, key);
			System.out.println("The decrypted message is:\n" + dec);
		}
	}
		
	public static String encrypt(String message, int key) 
	{
		message = message.toUpperCase();
		String result = "";
		for(int i = 0; i < message.length(); i++)
		{
			char c = message.charAt(i);
			if(c >= 'A' && c <= 'Z')
			{
				c = (char)(c + key);
				if(c > 'Z') 
				{
					c = (char)(c-26);
				}
			}
			result += c;
		}
		return result;
	}
	public static String decrypt(String message, int key) 
	{
		message = message.toUpperCase();
		String result = "";
		for(int i = 0; i < message.length(); i++)
		{
			char c = message.charAt(i);
			if(c >= 'A' && c <= 'Z')
			{
				c = (char)(c - key);
				if(c < 'A') 
				{
					c = (char)(c+26);
				}
			}
			result += c;
		}
		return result;
	}
		
	
}