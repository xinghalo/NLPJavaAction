package xingoo.corenlp;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

/**
 *
 * <p>
 * ClassName ZH_SegDemo
 * </p>
 * <p>
 * Description 使用Stanford CoreNLP进行中文分词
 * </p>
 *
 * @author wangxu wangx89@126.com
 * <p>
 * Date 2015年1月8日 下午1:56:54
 * </p>
 * @version V1.0.0
 *
 */
public class ZH_SegDemo {
    public static CRFClassifier<CoreLabel> segmenter;
    static {
        // 设置一些初始化参数
        Properties props = new Properties();
        props.setProperty("sighanCorporaDict", "corenlp/data");
        props.setProperty("serDictionary", "corenlp/data/dict-chris6.ser.gz");
        props.setProperty("inputEncoding", "UTF-8");
        props.setProperty("sighanPostProcessing", "true");
        segmenter = new CRFClassifier<CoreLabel>(props);
        segmenter.loadClassifierNoExceptions("corenlp/data/ctb.gz", props);
        segmenter.flags.setProperties(props);
    }

    public static String doSegment(String sent) {
        String[] strs = (String[]) segmenter.segmentString(sent).toArray();
        StringBuffer buf = new StringBuffer();
        for (String s : strs) {
            buf.append(s + " ");
        }
        System.out.println("segmented res: " + buf.toString());
        return buf.toString();
    }

    public static void main(String[] args) {
        try {
            String readFileToString = FileUtils.readFileToString(new File("/Users/xingoo/IdeaProjects/NLPJavaAction/src/main/resources/test1.txt"));
            String doSegment = doSegment(readFileToString);
            System.out.println(doSegment);

            ExtractDemo extractDemo = new ExtractDemo();
            System.out.println(extractDemo.doNer(doSegment));

            System.out.println("Complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}