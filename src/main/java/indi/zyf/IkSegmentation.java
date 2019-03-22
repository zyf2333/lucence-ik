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
	    String str = "���ʱ�䣬���ϳ��극������ص�λ�ӿ����Աߵ���������һ��ţ�������ϣ�����˵������ʦ��������ţ���ˡ�����ʦ˵������ȥ��æ����Ĩ�������������ϵ�����������Ĩ��������æ���ɾ���";
		System.out.println(IkSegmentation.Seg(str,false));
		System.out.println(IkSegmentation.Seg(str,true));
	}
}
