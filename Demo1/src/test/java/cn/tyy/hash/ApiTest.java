package cn.tyy.hash;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ApiTest {
    private Set<String> words;

    @Before
    public void init() {

        // 初始化words
        words = FileUtil.readWordList("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\103976个英语单词库.txt");
    }

    @Test
    public void test_collisionRate() {
        System.out.println("单词数量:"+words.size());
        List<RateInfo> rateInfoList = HashCode.collisionRateList(words, 2, 3, 5, 7, 17, 31, 32, 33, 39, 41, 199);

        for (RateInfo rate : rateInfoList) {
            System.out.println(String.format("乘数 = %4d, 最小Hash = %11d, 最大Hash = %10d, 碰撞数量 =%6d, 碰撞概率 = %.4f%%",
                    rate.getMultiplier(), rate.getMinHash(), rate.getMaxHash(), rate.getCollisionCount(), rate.getCollisionRate() * 100));
        }
    }

}
