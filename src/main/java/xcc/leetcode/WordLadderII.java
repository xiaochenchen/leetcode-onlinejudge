package xcc.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Maximus on 3/15/14.
 */
public class WordLadderII {

    class Word
    {
        String content;
        int level;
        Word parent;

        public Word(String content, int level)
        {
            this.content = content;
            this.level = level;
            this.parent = null;
        }

        public Word(String content, int level, Word parent)
        {
            this.content = content;
            this.level = level;
            this.parent = parent;
        }

        public void setParent(Word parent)
        {
            this.parent = parent;
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

    private ArrayList<String> createLadder(Word word)
    {
        ArrayList<String> result = new ArrayList<String>();
        while(word != null)
        {
            result.add(0, word.content);
            word = word.parent;
        }
        return result;
    }

    public String printResult(ArrayList<ArrayList<String>> results)
    {
        StringBuilder strResult = new StringBuilder();

        for(ArrayList<String> result : results)
        {
            for(String word : result)
            {
                strResult.append(word);
                strResult.append(" ");
            }
            strResult.append("\n");
        }

        return strResult.toString();
    }

    public ArrayList<ArrayList<String>> findLaddersBacktrace(String start, String end, HashSet<String> dict) {

        // final results to return
        List<Word> ladders = new ArrayList<Word>();

        // store words that have been used at this level
        Set<String> usedWords = new HashSet<String>();

        // queue to BFS traverse through the ladder
        Queue<Word> candidates = new LinkedList<Word>();
        candidates.offer(new Word(start, 1));

        int prevLevel = 1;
        while(!candidates.isEmpty())
        {
            Word curWord = candidates.poll();
            char[] curContent = curWord.getContent().toCharArray();
            int curLevel = curWord.getLevel();

            // we get to a new level in BFS
            if(curLevel > prevLevel)
            {
                // if we have final results, stop calculating
                if(!ladders.isEmpty())
                {
                    break;
                }

                // remove words used in the previous level
                for(String word : usedWords)
                {
                    dict.remove(word);
                }

                usedWords.clear();;
            }

            for(int i = 0; i < curContent.length; ++i)
            {
                for(char c = 'a'; c <= 'z'; ++c)
                {
                    if(curContent[i] == c)
                    {
                        continue;
                    }

                    char temp = curContent[i];
                    curContent[i] = c;
                    String newContent = new String(curContent);

                    // if matches end, one of the final results
                    if(end.equals(newContent))
                    {
                        ladders.add(new Word(newContent, curLevel + 1, curWord));
                        continue;
                    }

                    if(dict.contains(newContent))
                    {
                        candidates.offer(new Word(newContent, curLevel + 1, curWord));
                        usedWords.add(newContent);
                    }

                    curContent[i] = temp;
                }
            }

            prevLevel = curLevel;
        }

        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        for(Word word : ladders)
        {
            results.add(createLadder(word));
        }
        return results;
    }

//    private ArrayList<String> generateAdjacentList(String strWord, HashSet<String> dict)
//    {
//        ArrayList<String> adjacentList = new ArrayList<String>();
//
//        char[] word = strWord.toCharArray();
//
//        for(int i = 0; i < word.length; i ++)
//        {
//            for(char c = 'a'; c <= 'z'; ++c)
//            {
//                if(word[i] == c)
//                {
//                    continue;
//                }
//
//                char temp = word[i];
//                word[i] = c;
//                String newWord = new String(word);
//
//                if(dict.contains(newWord))
//                {
//                    adjacentList.add(newWord);
//                }
//
//                word[i] = temp;
//            }
//        }
//
//        if(adjacentList == null || adjacentList.isEmpty())
//        {
//            return null;
//        }
//    }

    public ArrayList<ArrayList<String>> findLaddersAdjacentList(String start, String end, HashSet<String> dict) {

        Map<String, ArrayList<String>> ajacentLists = new HashMap<String, ArrayList<String>>();

        // add start and end to dict set to create adjacent list
        dict.add(start);
        dict.add(end);

        // build the adjacentLists
        for(String strWord : dict)
        {
            ArrayList<String> adjacentList = new ArrayList<String>();

            char[] word = strWord.toCharArray();

            for(int i = 0; i < word.length; i ++)
            {
                for(char c = 'a'; c <= 'z'; ++c)
                {
                    if(word[i] == c)
                    {
                        continue;
                    }

                    char temp = word[i];
                    word[i] = c;
                    String newWord = new String(word);

                    if(dict.contains(newWord))
                    {
                        adjacentList.add(newWord);
                    }

                    word[i] = temp;
                }
            }

            if(adjacentList != null && !adjacentList.isEmpty())
            {
                ajacentLists.put(strWord, adjacentList);
            }
        }

        List<Word> resultWords = new ArrayList<Word>();
        Set<String> usedWords = new HashSet<String>();
        Set<String> levelUsedWords = new HashSet<String>();

        Queue<Word> candidates = new LinkedList<Word>();
        candidates.offer(new Word(start, 1));

        int prevLevel = 1;
        while(!candidates.isEmpty())
        {
            Word curWord = candidates.poll();
            int curLevel = curWord.getLevel();
            String curContent = curWord.getContent();

            if(curLevel > prevLevel)
            {
                if(!resultWords.isEmpty())
                {
                    break;
                }

                usedWords.addAll(levelUsedWords);
                levelUsedWords.clear();
            }

            ArrayList<String> curAdjacentList = ajacentLists.get(curContent);
            if(curAdjacentList != null && !curAdjacentList.isEmpty())
            {
                for(String strWord : curAdjacentList)
                {
                    // found one result
                    if(strWord.equals(end))
                    {
                        resultWords.add(new Word(strWord, curLevel + 1, curWord));
                    }
                    if(usedWords.contains(strWord)) continue;
                    candidates.offer(new Word(strWord, curLevel + 1, curWord));
                    levelUsedWords.add(strWord);
                }
            }

            prevLevel = curLevel;
        }

        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        for(Word word : resultWords)
        {
            results.add(createLadder(word));
        }
        return results;
    }
}
