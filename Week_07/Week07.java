package com.company.leetcode.homework;

import java.util.*;

public class Week07 {

    /**
     * 208. 实现 Trie (前缀树)
     */
    class Trie {

        private static final char START = 'a';
        private boolean isEnd = false;
        private Trie[] child;

        /** Initialize your data structure here. */
        public Trie() {
            child = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie curTrie = this;
            char[] chars = word.toCharArray();
            for(char c : chars){
                if(curTrie.child[c - START] == null){
                    curTrie.child[c - START] = new Trie();
                }
                curTrie = curTrie.child[c - START];
            }
            curTrie.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie trie = searchPrefix(prefix);
            return trie != null;
        }

        /** Returns the Trie if there is any word in the trie that starts with the given prefix, otherwise return null  */
        public Trie searchPrefix(String prefix) {
            Trie curTrie = this;
            for(char c : prefix.toCharArray()){
                if(curTrie.child[c - START] != null){
                    curTrie = curTrie.child[c - START];
                } else {
                    return null;
                }
            }
            return curTrie;
        }
    }


    /**
     * 547. 朋友圈
     */
    class SolutionFindCircleNum {
        class UnionFind{
            int[] union;
            int count;
            public UnionFind(int size){
                union = new int[size];
                count = size;
                for(int index = 0; index < size; index++){
                    union[index] = index;
                }
            }
            public int find(int pos){
                while(pos != union[pos]){
                    pos = union[pos];
                }
                return pos;
            }
            public void unionOp(int i, int j){
                int iP = find(i);
                int jP = find(j);
                if(iP != jP){
                    union[iP] = jP;
                    count--;
                }
            }
        }
        public int findCircleNum(int[][] M) {
            if(null == M || 0 == M.length || 0 == M[0].length){
                return 0;
            }
            UnionFind unionFind = new UnionFind(M.length);
            for(int i = 0; i < M.length; i++){
                for(int j = 0; j <= i; j++){
                    if(M[i][j] == 1){
                        unionFind.unionOp(i, j);
                    }
                }
            }
            return unionFind.count;
        }
    }
    /**
     * 127. 单词接龙
     */
    class SolutionLadderLength {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(beginWord.equals(endWord)){
                return 1;
            }
            Set<String> wordSet = new HashSet<>(wordList);
            if(!wordSet.contains(endWord)){
                return 0;
            }

            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visited = new HashSet<>();
            beginSet.add(beginWord);
            endSet.add(endWord);
            visited.add(beginWord);
            visited.add(endWord);
            int result = 2;
            while(!beginSet.isEmpty() && !endSet.isEmpty()){
                if(beginSet.size() > endSet.size()){
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }
                Set<String> temp = new HashSet<>();
                for(String word : beginSet){
                    char[] chars = word.toCharArray();
                    for(int index = 0; index < chars.length; index++){
                        char old = chars[index];
                        for(char c = 'a'; c <= 'z'; c++){
                            chars[index] = c;
                            String newWord = String.valueOf(chars);
                            if(endSet.contains(newWord)){
                                return result;
                            }
                            if(wordSet.contains(newWord) && !visited.contains(newWord)){
                                temp.add(newWord);
                                visited.add(newWord);
                            }
                        }
                        chars[index] = old;
                    }
                }
                beginSet = temp;
                result++;
            }
            return 0;
        }
    }

    /**
     * 51. N 皇后
     */
    class SolutionNQueens {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            Set<Integer> columnSet = new HashSet<>();
            Set<Integer> xySumSet = new HashSet<>();
            Set<Integer> xySubSet = new HashSet<>();
            char[][] board = new char[n][n];
            for(char[] chars : board){
                Arrays.fill(chars, '.');
            }
            solveNQueensDfs(board, 0, columnSet, xySumSet, xySubSet, result);
            return result;
        }
        private void solveNQueensDfs(char[][] board, int row, Set<Integer> columnSet,
                                     Set<Integer> xySumSet, Set<Integer> xySubSet, List<List<String>> result){
            if(row == board.length){
                List<String> res = new ArrayList<>();
                for(char[] chars : board){
                    res.add(new String(chars));
                }
                result.add(res);
                return;
            }
            for(int column = 0; column < board.length; column++){
                if(columnSet.contains(column) || xySumSet.contains(row + column) || xySubSet.contains(row - column)){
                    continue;
                }
                columnSet.add(column);
                xySumSet.add(row + column);
                xySubSet.add(row - column);
                board[row][column] = 'Q';
                solveNQueensDfs(board, row + 1, columnSet, xySumSet, xySubSet, result);
                columnSet.remove(column);
                xySumSet.remove(row + column);
                xySubSet.remove(row - column);
                board[row][column] = '.';
            }
        }
    }

}
