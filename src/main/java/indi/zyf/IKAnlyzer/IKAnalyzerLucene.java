package indi.zyf.IKAnlyzer;

import indi.zyf.Tokenizer.IKTokenizerLucene;
import org.apache.lucene.analysis.Analyzer;

/**
 * 因为Analyzer的createComponents方法API改变了需要重新实现分析器
 */
public class IKAnalyzerLucene extends Analyzer {

    private boolean useSmart = false;

    public IKAnalyzerLucene() {
        this(false);
    }

    protected TokenStreamComponents createComponents(String s) {
        IKTokenizerLucene tk = new IKTokenizerLucene(this.useSmart);
        return new TokenStreamComponents(tk);
    }

    public IKAnalyzerLucene(boolean useSmart) {
        super();
        this.useSmart = useSmart;
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }



}
