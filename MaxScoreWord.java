import java.io.*;
import java.util.*;
public class MaxScoreWord {
    public static int maxscore(String[] words, int[] fre, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        int scoreno = 0 + maxscore(words, fre, score, index + 1);  //when word is not included in set

        int scoreword = 0;  //when word is included then we have to check whether frequency is in limit of that wordset
        String word = words[index];
        boolean flag = true;  // if word is included
        for (int i = 0; i < word.length(); i++) {  //this is for takeing charater so score are added eaisly
            char ch = word.charAt(i);
            if (fre[ch - 'a'] == 0) {  //checking frequency
                flag = false;   //if beyond limit then make flag false so word will not included
            }
            fre[ch - 'a']--;
            scoreword += score[ch - 'a'];
        }
        int scoreyes = 0;
        if (flag) {
            scoreyes = scoreword + maxscore(words, fre, score, index + 1);
        }
        for (int i = 0; i < word.length(); i++) {  //this is for takeing charater so score are added eaisly
            char ch = word.charAt(i);
            fre[ch - 'a']++;
        }
        return Math.max(scoreno, scoreyes);
    }
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);

        int noofwords=s.nextInt();
        String []words=new String[noofwords];
        for (int i=0;i<words.length;i++){
            words[i]=s.next();
        }

        int noofletters=s.nextInt();
        char[] letters=new char[noofletters];
        for (int i=0;i<letters.length;i++){
            letters[i]=s.next().charAt(0);
        }

        int [] score=new int[26];
        for (int i=0;i<score.length;i++){
            score[i]=s.nextInt();
        }

        if(words==null || words.length==0 || letters==null || letters.length==0 || score.length==0){
            System.out.println(0);
            return;
        }

        int []fre=new int[score.length];
        for(char ch: letters){
            fre[ch-'a']++;
        }
        System.out.println(maxscore(words,fre,score,0));
    }
}
