package io.zipcoder;
import java.util.ArrayList;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        Integer counter=0;
        input=input.toLowerCase().trim();
        ArrayList<String> words = new ArrayList<>();
      /*  while (input.length()>0) {
            for (int i = 0; i < input.length(); i++) {
                if(!Character.isLetter(input.charAt(i))) {
                    words.add(input.substring(0, i));

                   if (input.length() > i + 1) input = input.substring(i + 1);
                    else input = "";
                    i = 0;
                    while(input.length()>1&&!Character.isLetter(input.charAt(0))) input=input.substring(1);
                    if (input.length()==1){
                        if (Character.isLetter(input.charAt(0))) words.add(input);
                        input="";
                    }
                }
            }
            */
        while(input.length()>1&&!Character.isLetter(input.charAt(0))) input=input.substring(1);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                words.add(input.substring(0, i));
                this.countYZ(input.substring(i+1));
            }
        }
        words.add(input);
        input="";
       // }
        for (String thisOne: words) {
            if(thisOne.charAt(thisOne.length()-1)=='y'||thisOne.charAt(thisOne.length()-1)=='z')counter++;
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        for(int i=0; i<base.length()-remove.length()+1;i++){
            if(base.substring(i,i+remove.length()).toLowerCase().equals(remove.toLowerCase())){
                base = base.substring(0,i)+base.substring(i+remove.length());
                i=0; // this line might not be needed depending on my question below about creating new instances of remove
            }
        }

        return base;
    }
/* I wasn't sure from the requirements whether or not we should re-evaluate the base string to see if any new instances of remove
    are created.  For example, given: removeString("My nanameme is Jeff", "name") // would we want it to return "My name is Jeff"
    or would we want it to return "My  is Jeff"?
 */
    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        input=input.toLowerCase().trim();
        Integer isCounter=0, notCounter=0;
        for(int i=0;i<input.length()-2;i++) {
            if(input.substring(i,i+2).equals("is")) isCounter++;
            else if (input.substring(i,i+3).equals("not")) notCounter++;
        }
        if(input.substring(input.length()-1).equals("is")) isCounter++;
        return isCounter==notCounter;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //input = input.toLowerCase(); // un-comment this line to make the method case-insensitive
        if (input.length()<1) return true;
        if (input.length()==1) return input.charAt(0)!='g';
        if (input.charAt(0)=='g'&&input.charAt(1)!='g') return false;
        if(input.charAt(input.length()-1)=='g'&&input.charAt(input.length()-2)!='g')return false;
        for(int i=1;i<input.length()-2;i++) {
            if (input.charAt(i)=='g' && input.charAt(i-1)!='g' && input.charAt(i+1)!='g')return false;
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        //input = input.toLowerCase(); // un-comment this line to make the method case-insensitive
        Integer counter=0;
        for(int i=0; i<input.length()-2;i++){
            if(input.charAt(i)==input.charAt(i+1)&&input.charAt(i)==input.charAt(i+2))counter++;
        }
        return counter;
    }
}
