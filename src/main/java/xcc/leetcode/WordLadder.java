package xcc.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Maximus on 3/15/14.
 */
public class WordLadder {
    class Word
    {
        String content;
        int level;

        public Word(String content, int level)
        {
            this.content = content;
            this.level = level;
        }

        public String getContent()
        {
            return this.content;
        }

        public int getLevel()
        {
            return this.level;
        }
    }

    public int ladderLength(String start, String end, HashSet<String> dict)
    {
        Queue<Word> wordQ = new LinkedList<Word>();
        wordQ.offer(new Word(start, 1));

        while(!wordQ.isEmpty())
        {
            Word curWord = wordQ.poll();
            char[] curContent = curWord.getContent().toCharArray();
            int curLevel = curWord.getLevel();

            for(int i = 0; i < curContent.length; ++i)
            {
                for(char c = 'a'; c <= 'z'; ++c)
                {
                    char temp = curContent[i];
                    if(c == temp)
                    {
                        continue;
                    }
                    curContent[i] = c;
                    String newContent = new String(curContent);

                    // found the first solution
                    if(end.equals(newContent))
                    {
                        return curLevel + 1;
                    }

                    // if word in dictionary
                    if(dict.contains(newContent))
                    {
                        wordQ.offer(new Word(newContent, curLevel + 1));
                        // remove from dictionary if used, prevent dups and unnecessary calcs
                        dict.remove(newContent);
                    }

                    curContent[i] = temp;
                }
            }
        }

        // return 0 if there is no such transformation sequence
        return 0;
    }
}
