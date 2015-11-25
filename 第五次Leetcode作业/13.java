/*��1����ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
 
��2��С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
 
��3��С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
 
��4������ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
 
��5����һ���������滭һ�����ߡ���ʾ��������� 1000 ����
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