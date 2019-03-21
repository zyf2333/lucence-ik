package indi.zyf;


import java.io.IOException;

import indi.zyf.IKAnlyzer.IKAnalyzerLucene;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;


/**
 * IKAnalyzer分词器集成测试:
 * 细粒度切分：把词分到最细
 * 智能切分：根据词库进行拆分符合我们的语言习惯
 *
 * @author THINKPAD
 *
 */
public class IKAnalyzerTest {
    private static void doToken(TokenStream ts) throws IOException {
        ts.reset();
        CharTermAttribute cta = ts.getAttribute(CharTermAttribute.class);
        while (ts.incrementToken()) {
            System.out.print(cta.toString() + "|");
        }
        System.out.println();
        ts.end();
        ts.close();
    }

    public static void main(String[] args) throws IOException {

        String chineseText = "ikanalyzer 中文分词器 因为Analyzer的createComponents方法API改变了 需要我们自己实现";
        /**
         * ikanalyzer 中文分词器 因为Analyzer的createComponents方法API改变了 需要我们自己实现
         */
        // IKAnalyzer 细粒度切分
        try (Analyzer ik = new IKAnalyzerLucene();) {
            TokenStream ts = ik.tokenStream("content", chineseText);
            System.out.println("细粒度切分：");
            doToken(ts);
        }

        // IKAnalyzer 智能切分
        try (Analyzer ik = new IKAnalyzerLucene(true);) {
            TokenStream ts  = ik.tokenStream("content", chineseText);
            System.out.println("智能切分：");
            doToken(ts);
        }
    }
}