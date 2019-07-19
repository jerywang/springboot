/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package server;

/**
 * 前缀树是一个非常好用的数据结构，特别是针对求相同前缀字符串有多少个的时候
 */
public class TrieTree {

    //内部类
    private class TrieNode {
        public int path;
        public int end;
        public TrieNode nexts[];

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];//这里假设是26个字母，如果有其他的情况，参照ascii表
        }
    }

    public TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    //插入操作
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = this.root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    //查找操作
    public int search(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        char[] chs = word.toCharArray();
        TrieNode node = this.root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    //删除操作
    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            TrieNode node = this.root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (--node.nexts[index].path == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    //判断前缀相同的字符串个数
    public int prefix(String prefix) {
        if (prefix == null) {
            return 0;
        }
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
//        char a = 'a';
//        System.out.println('c'-a);
        TrieTree root = new TrieTree();
        root.insert("abc");
        root.insert("abc");
        root.insert("bdc");
        root.insert("abe");
        root.insert("abfg");
        System.out.println(root.search("abc"));
        System.out.println(root.search("ab"));
        System.out.println(root.prefix("ab"));
        root.delete("abe");
    }
}
