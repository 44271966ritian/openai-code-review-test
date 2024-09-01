package cn.tyy.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HashCode {
    public static Integer hashCode(String str,Integer multiplier){
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = multiplier * hash + str.charAt(i);
        }
        return hash;
    }

    /*
    * TODO 计算哈希碰撞率
    * */
    public static RateInfo hashCollisionRate(Integer multiplier, List<Integer> hashCodeList){
        int maxHash = hashCodeList.stream().max(Integer::compareTo).get();
        int minHash = hashCodeList.stream().min(Integer::compareTo).get();

        //计算哈希碰撞元素个数
        int collisionCount = (int) (hashCodeList.size() - hashCodeList.stream().distinct().count());
        //计算碰撞率
        double collisionRate = (double) collisionCount / hashCodeList.size();


        return new RateInfo(maxHash,minHash,multiplier,collisionCount,collisionRate);
    }

    public static List<RateInfo> collisionRateList(Set<String> strList,Integer... multipliers){
        List<RateInfo> rateInfoList = new ArrayList<>();

        for (Integer multiplier : multipliers) {
            List<Integer> hashCodeList = new ArrayList<>();

            for (String str : strList) {
                Integer hashCode = hashCode(str,multiplier);

                hashCodeList.add(hashCode);
            }

            RateInfo rateInfo = hashCollisionRate(multiplier,hashCodeList);

            rateInfoList.add(rateInfo);
        }

        return rateInfoList;
    }
}
