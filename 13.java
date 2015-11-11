/*（1）相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
 
（2）小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
 
（3）小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
 
（4）正常使用时、连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）；
 
（5）在一个数的上面画一条横线、表示这个数扩大 1000 倍。
*/

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> map = new HashMap<Character , Integer>(); 
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        s = s.toUpperCase();
        int result=0;
        for (int i = 0; i < s.length(); i++)
        {
            int curLetter = map.get(s.charAt(i));
            if (i + 1 < s.length() && curLetter < map.get(s.charAt(i+1) ))
            {
                result=result-curLetter;
            } 
            else
            {
                result=result+curLetter;
            }
        }
       return result;

    }
}