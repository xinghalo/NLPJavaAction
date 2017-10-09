package xingoo.fnlp;

import org.fnlp.nlp.cn.CNFactory;
import org.fnlp.util.exception.LoadModelException;

import java.util.HashMap;

public class FNLPHelloWorld {
    public static void main(String[] args) throws LoadModelException {
        // 创建中文处理工厂对象，并使用“models”目录下的模型文件初始化
        CNFactory factory = CNFactory.getInstance("/Users/xingoo/IdeaProjects/NLPJavaAction/src/main/resources/fnlp/models");

        // 使用分词器对中文句子进行分词，得到分词结果
        String[] words = factory.seg("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");

        // 打印分词结果
        for(String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        // 使用标注器对中文句子进行标注，得到标注结果
        String result = factory.tag2String("关注自然语言处理、语音识别、深度学习等方向的前沿技术和业界动态。");
        // 显示标注结果
        System.out.println(result);

        String test = factory.tag2String("我想买一双运动鞋");
        // 我/人称代词 想/情态词 买/动词 一/数词 双/量词 运动鞋/名词
        System.out.println(test);


        // 使用标注器对包含实体名的句子进行标注，得到结果
        HashMap<String, String> result1 = factory.ner("詹姆斯·默多克和丽贝卡·布鲁克斯 鲁珀特·默多克旗下的美国小报《纽约邮报》的职员被公司律师告知，保存任何也许与电话窃听及贿赂有关的文件。");
        // 显示标注结果
        System.out.println(result1);
    }
}
