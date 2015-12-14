{\rtf1\ansi\ansicpg936\cocoartf1348\cocoasubrtf170
{\fonttbl\f0\fnil\fcharset134 STHeitiSC-Light;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10380\viewh7200\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural

\f0\fs24 \cf0 public class Solution \{\
    public boolean isAnagram(String s, String t) \{\
        int i,j;\
        /*String[] sarr=s.split("");\
        String[] tarr=t.split("");\
        for(i=0;i<s.length();i++)\{\
            for(j=0;j<tarr.length;j++)\{\
                if(tarr[j]==sarr[i])\
                    tarr[j]="#";\
            \}\
        \}*/\
        char[] sarr = s.toCharArray();  \
        char[] tarr = t.toCharArray();  \
        Arrays.sort(sarr);  \
        Arrays.sort(tarr);  \
        return String.valueOf(sarr).equals(String.valueOf(tarr));  \
    /*\
        if(tarr==null)\
        return true;\
        return false;*/\
    \}\
\}}