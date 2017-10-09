package xingoo.fnlp;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;

import java.util.ArrayList;
import java.util.List;

public class APILearning {
    public static final String ROOT = "/Users/xingoo/IdeaProjects/NLPJavaAction/src/main/resources/fnlp/";

    public static void main(String[] args) throws LoadModelException {
        List<String> list = new ArrayList<>();
        list.add("天狗公司");
        CNFactory factory = CNFactory.getInstance(ROOT+"models");
        factory.addDict(list);

        String test = factory.tag2String("我想在天狗公司买一双运动鞋");
        System.out.println(test);

        String test1 = factory.tag2String("天狗公司卖浪琴吗？");
        System.out.println(test1);

    }
}
