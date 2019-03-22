package indi.zyf;

import indi.zyf.IKAnlyzer.IKAnalyzerLucene;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IkSegmentation {
 
	@SuppressWarnings("resource")
	public static List<String> Seg(String sentence,boolean ai) throws IOException {
		List<String> rtList = new ArrayList<String>();
		Analyzer ik = new IKAnalyzerLucene(ai);
		TokenStream ts  = ik.tokenStream("content", sentence);
		ts.reset();
		CharTermAttribute cta = ts.getAttribute(CharTermAttribute.class);
		while (ts.incrementToken()) {
			rtList.add(cta.toString());
		}
		ts.end();
		ts.close();
		return rtList;
	}
 
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
	    String str = "早餐时间，西瓜吃完饭送了碗回到位子看见旁边的铁蛋洒了一点牛奶在桌上，西瓜说：“老师，铁蛋扣牛奶了。”老师说：“你去帮忙拿下抹布。”西瓜马上到卫生间拿了抹布出来帮忙擦干净。";
		System.out.println(IkSegmentation.Seg(str,false));
		System.out.println(IkSegmentation.Seg(str,true));
	}
}
