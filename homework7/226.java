{\rtf1\ansi\ansicpg936\cocoartf1348\cocoasubrtf170
{\fonttbl\f0\fnil\fcharset134 STHeitiSC-Light;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10380\viewh7200\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural

\f0\fs24 \cf0 /**\
 * Definition for a binary tree node.\
 * public class TreeNode \{\
 *     int val;\
 *     TreeNode left;\
 *     TreeNode right;\
 *     TreeNode(int x) \{ val = x; \}\
 * \}\
 */\
public class Solution \{\
    public TreeNode invertTree(TreeNode root) \{\
        TreeNode temp;\
        if(root==null)\
        return root;\
        //if(root.left!=null)\
        if(root!=null)\{\
            invertTree(root.left);\
            invertTree(root.right);\
        \}\
        temp=root.left;\
        root.left=root.right;\
        root.right=temp;\
        return root;\
    \}\
\}}