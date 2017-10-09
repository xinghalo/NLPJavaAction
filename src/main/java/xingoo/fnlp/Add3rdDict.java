package xingoo.fnlp;

import org.fnlp.ml.types.Dictionary;
import org.fnlp.nlp.cn.tag.POSTagger;
import org.fnlp.nlp.parser.dep.DependencyTree;
import org.fnlp.nlp.parser.dep.JointParser;

public class Add3rdDict {
    private static JointParser parser;
    public static final String ROOT = "/Users/xingoo/IdeaProjects/NLPJavaAction/src/main/resources/fnlp/";

    public static void main(String[] args) throws Exception {
        parser = new JointParser(ROOT+"models/dep.m");
        String word = "中国进出口银行与中国银行深度加强合作张持良。这是一个可扩展的机器集群华兴资本";
        //test_dep(word);
        test_dep("天狗电子商务有限公司成立于2014年，目前主要从事实体电商行业");
    }

    /**
     * 增加第三方词库
     *
     * @param word
     * @throws Exception
     */
    private static void test_dep(String word) throws Exception {
        POSTagger tag = new POSTagger(ROOT+"models/seg.m",ROOT+"models/pos.m",new Dictionary(ROOT+"models/dict.txt"));
        String[][] s = tag.tag2Array(word);
        try {
            DependencyTree tree = parser.parse2T(s[0],s[1]);
            System.out.println(tree.toString());
            String stree = parser.parse2String(s[0],s[1],true);
            System.out.println(stree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
