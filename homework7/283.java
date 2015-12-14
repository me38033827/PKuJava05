{\rtf1\ansi\ansicpg936\cocoartf1348\cocoasubrtf170
{\fonttbl\f0\fnil\fcharset134 STHeitiSC-Light;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10380\viewh7200\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural

\f0\fs24 \cf0 public class Solution \{\
    public void moveZeroes(int[] nums) \{\
        int i,j=0,count=0; // i\'b1\'e9\'c0\'fa\'ca\'fd\'d7\'e9\'a3\'acj\'b1\'ed\'ca\'bei\'c7\'b0\'d2\'bb\'b8\'f6\'b2\'bb\'ce\'aa\'c1\'e3\'b5\'c4\'ca\'fd\'b5\'c4\'ce\'bb\'d6\'c3\'a3\'account\'b1\'ed\'ca\'be0\'b5\'c4\'b8\'f6\'ca\'fd\
        for(i=0;i<nums.length;i++)\{\
            /*if(nums[i]==0)\{\
                j=i;\
                count++;\
                //while(nums[i+1]==0&&i<nums.length-1)\
                while(i<nums.length-1&&nums[i+1]==0)\
                    \{i++;count++;\}\
                if(i<nums.length-1)\
                nums[j]=nums[i+1];\
            \}*/\
            //while(i<nums.length&&nums[i]==0)\{\
            while(i<nums.length-1&&nums[i]==0)\{\
                count++;\
                i++;\
            \}\
            nums[j]=nums[i];\
            j++;\
        \}\
        for(i=nums.length-count;i<nums.length;i++)\{\
            nums[i]=0;\
        \}\
    \}\
\}}