import java.util.*;

public class TransformURL 
{
	public static String generateFixedLengthString(int hashCode, String uniqueString, int length) 
	{
        StringBuilder sb = new StringBuilder(length);

        int uniqueStringLength = uniqueString.length();
        
        for (int i = 0; i < length; i++) {
            int index = Math.abs((hashCode + i) % uniqueStringLength);
            char c = uniqueString.charAt(index);
            sb.append(c);
        }
        
        return sb.toString();
    }
	public static String removeSpecialCharacters(String url)
	{
		// Remove special characters from the URL
        String urlWithoutSpecialChars = url.replaceAll("[^a-zA-Z0-9]", "");
        return urlWithoutSpecialChars;
	}
	public static String getUniqueCharacters(String urlWithoutSpecialChars) {
        
        
        // Create a set to store unique characters
        Set<Character> uniqueChars = new HashSet<>();
        
        // Iterate over each character in the URL
        for (char c : urlWithoutSpecialChars.toCharArray()) {
            uniqueChars.add(c);
        }
        
        // Build the string with unique characters
        StringBuilder uniqueString = new StringBuilder();
        for (char c : uniqueChars) {
            uniqueString.append(c);
        }
        
        return uniqueString.toString();
    }




	public static void main(String[] args)
	{
		// Scan the input url and new url string length
		String[] oURL = {"https://www.google.com/travel/flights/search?tfs=CBwQAhojEgoyMDIzLTA2LTA2agcIARIDSkZLcgwIAxIIL20vMDljNndAAUACSAFwAYIBCwj___________8BmAEC&tfu=EgIIASIA&hl=en&gl=us&curr=USD",
						"https://www.w3schools.com/java/java_strings_specchars.asp",
						"https://www.youtube.com/watch?v=2Gik4bFYJbM",
						"https://www.javastring.net/java/string/java-string-transform-method-examples",
						"https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Character.html",
						"https://courses.telusko.com/learn/home/Live-Java-Course/section/373033/lesson/2306661?",
						"https://www.youtube.com/watch?v=2Gik4bFYJbM",
						"https://accounts.google.com/InteractiveLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv=Af_xneHklmm-vHuSQ9exQpoCHsa4pcnBWrcUf0EwuRb0qoDCmRsQQ4rQSZOIXDTiUUWJgFMnA_Qq8w&flowName=GlifWebSignIn&flowEntry=ServiceLogin"};
		
		int nURLLen = 6;
		int hashVal = 0;
		Map<Integer, String> resultMap = new HashMap<>();
		String urlWithoutSpecialChars, uniqueString, sURL;
		for (int i = 0; i < oURL.length; i++)
		{
			// Generate the hashCode() for the transformed url string 
			hashVal = oURL[i].hashCode();
			
			if(!resultMap.containsKey(hashVal))
			{
				// Transform the input url by removing the special characters removeSpecialCharaters
				 urlWithoutSpecialChars = TransformURL.removeSpecialCharacters(oURL[i]);
				
				 uniqueString = TransformURL.getUniqueCharacters(urlWithoutSpecialChars);
				
				
				// Use the hashCode to generate the new url String of fixed length
				 sURL = TransformURL.generateFixedLengthString(hashVal, uniqueString, nURLLen);
				
				// Save the hashCode and the new String to map so that regeneration would be stopped
				resultMap.put(hashVal, sURL);
			}
		}
		for(int i = 0; i < oURL.length; i++)
		{
	            System.out.println("Original URL :"+oURL[i]+ "\nHashCode: " + oURL[i].hashCode() + "\nShort URL: " + "telsu.ko/"+resultMap.get(oURL[i].hashCode()));
		}
	}

}
