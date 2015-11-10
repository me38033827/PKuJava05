public class Solution {
    public String intToRoman(int num) {
        
        //I:1,V:5,X:10,L:50,C:100,D:500,M:1000
        String res=new String();
        int k,h,d,u,i;//k表示千位，h表示百位，d表示十位，u表示个位
        //分别取整数的每一位
        k=num/1000;
        h=(num%1000)/100;
        d=(num%100)/10;
        u=(num%10);
        //如果千位存在则表示千位
        if(k>0){
                for(i=1;i<=k;i++){
                    res+="M";
                }
        }
        //表示百位，原则：C连续数不超过三（100,200,300,600,700,800），D左边最多一个C（400），M左边最多一个C（900）
        switch(h){
            case 9:res+="CM";
                break;
            case 8:res+="DCCC";
                break;
            case 7:res+="DCC";
                break;
            case 6:res+="DC";
                break;
            case 5:res+="D";
                break;
            case 4:res+="CD";
                break;
            case 3:res+="CCC";
                break;
            case 2:res+="CC";
                break;
            case 1:res+="C";
                break;
        }
        //表示十位，原则：X连续数不超过三（10,20,30,60,70,80），L左边最多一个X（40），C左边最多一个X（90）
        switch(d){
            case 9:res+="XC";
                break;
            case 8:res+="LXXX";
                break;
            case 7:res+="LXX";
                break;
            case 6:res+="LX";
                break;
            case 5:res+="L";
                break;
            case 4:res+="XL";
                break;
            case 3:res+="XXX";
                break;
            case 2:res+="XX";
                break;
            case 1:res+="X";
                break;
        }
        //表示个位，原则：I连续数不超过三（1,2,3,6,7,8），V左边最多一个I（4），X左边最多一个I（9）
        switch(u){
            case 9:res+="IX";
                break;
            case 8:res+="VIII";
                break;
            case 7:res+="VII";
                break;
            case 6:res+="VI";
                break;
            case 5:res+="V";
                break;
            case 4:res+="IV";
                break;
            case 3:res+="III";
                break;
            case 2:res+="II";
                break;
            case 1:res+="I";
                break;
        }
        return res;
    }
}