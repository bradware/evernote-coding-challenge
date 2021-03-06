package evernote;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class FrequencyAnalyzerTest {
	
		String file1 = new String("cat;dog;mouse;bird;cat;dog;mouse;food;"
				+ "brad;cat;mouse;believe;i;love;to;code;brad;is;awesome;bird;cat;dog;;;hello;");
		String file2 = new String(" ");
		String file3 = null;
		String file4 = (";;;;;;");
		String file5 = new String("bradabradahelloamikeataylorabradamikeaheyahiahelloa");
		
		
		@Test
		public void testGenericFile() {
			System.out.println("testGenericFile1  *************");
			int count1 = 5;
			int count2 = 0;
			int count3 = file1.length();
			int count4 = -25000;
			
			List<String> test1 = FrequencyAnalyzer.getFrequency(file1, count1, ';');
			ArrayList<String> answer = new ArrayList<String>();
			answer.add("cat");
			answer.add("mouse");
			answer.add("dog");
			answer.add("bird");
			answer.add("brad");
			System.out.println("test1Answer: " + test1);
			assertEquals(test1, answer);
			assertEquals(count1, test1.size());
			
			List<String> test2 = FrequencyAnalyzer.getFrequency(file1, count2, ';');
			answer = new ArrayList<String>();
			System.out.println("test2Answer: " + test2);
			assertEquals(test2, answer);
			assertEquals(count2, test2.size());
			
			
			List<String> test3 = FrequencyAnalyzer.getFrequency(file1, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test3Answer: " + test3);
			
			List<String> test4 = FrequencyAnalyzer.getFrequency(file1, count4, ';');
			answer = new ArrayList<String>();
			System.out.println("test4Answer: " + test4);
			assertEquals(0, test4.size());
			
			List<String> test5 = FrequencyAnalyzer.getFrequency(file1, count1, 'z');
			answer = new ArrayList<String>();
			System.out.println("test5Answer: " + test5);
			assertEquals(1, test5.size());
			
			
			System.out.println();
		}
		
		@Test
		public void testGenericFile2() {
			System.out.println("testGenericFile2  *************");
			int count1 = 5;
			int count2 = 0;
			int count3 = file2.length();
			int count4 = -25000;
			
			List<String> test1 = FrequencyAnalyzer.getFrequency(file2, count1, 'a');
			ArrayList<String> answer = new ArrayList<String>();
			answer.add(" ");
			System.out.println("test1Answer: " + test1);
			assertEquals(test1, answer);
			assertEquals(1, test1.size());
			
			List<String> test2 = FrequencyAnalyzer.getFrequency(file2, count2, ';');
			answer = new ArrayList<String>();
			System.out.println("test2Answer: " + test2);
			assertEquals(test2, answer);
			assertEquals(0, test2.size());
			
			
			List<String> test3 = FrequencyAnalyzer.getFrequency(file2, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test3Answer: " + test3);
			
			List<String> test4 = FrequencyAnalyzer.getFrequency(file2, count4, ';');
			answer = new ArrayList<String>();
			System.out.println("test4Answer: " + test4);
			assertEquals(0, test4.size());
			
			
			System.out.println();
		}
		
		@Test
		public void testGenericFile3() {
			System.out.println("testGenericFile3  *************");
			int count1 = 5;
			int count2 = 0;
			int count3 = -25000;
			
			List<String> test1 = FrequencyAnalyzer.getFrequency(file3, count1, ';');
			ArrayList<String> answer = new ArrayList<String>();
			System.out.println("test1Answer: " + test1);
			assertEquals(test1, answer);
			assertEquals(0, test1.size());
			
			List<String> test2 = FrequencyAnalyzer.getFrequency(file3, count2, ';');
			answer = new ArrayList<String>();
			System.out.println("test2Answer: " + test2);
			assertEquals(test2, answer);
			assertEquals(0, test2.size());
			
			
			List<String> test3 = FrequencyAnalyzer.getFrequency(file3, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test3Answer: " + test3);
			
			List<String> test4 = FrequencyAnalyzer.getFrequency(file3, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test4Answer: " + test4);
			assertEquals(0, test4.size());
			
			
			System.out.println();
		}
		
		@Test
		public void testGenericFile4() {
			System.out.println("testGenericFile4  *************");
			int count1 = 5;
			int count2 = 0;
			int count3 = -25000;
			
			List<String> test1 = FrequencyAnalyzer.getFrequency(file4, count1, ';');
			ArrayList<String> answer = new ArrayList<String>();
			System.out.println("test1Answer: " + test1);
			assertEquals(test1, answer);
			assertEquals(0, test1.size());
			
			List<String> test2 = FrequencyAnalyzer.getFrequency(file4, count2, ';');
			answer = new ArrayList<String>();
			System.out.println("test2Answer: " + test2);
			assertEquals(test2, answer);
			assertEquals(0, test2.size());
			
			
			List<String> test3 = FrequencyAnalyzer.getFrequency(file4, count1, 'a');
			answer = new ArrayList<String>();
			System.out.println("test3Answer: " + test3);
			
			List<String> test4 = FrequencyAnalyzer.getFrequency(file4, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test4Answer: " + test4);
			assertEquals(0, test4.size());
			
			
			System.out.println();
		}
		
		@Test
		public void testGenericFile5() {
			System.out.println("testGenericFile5  *************");
			int count1 = 5;
			int count2 = 0;
			int count3 = -25000;
			
			List<String> test1 = FrequencyAnalyzer.getFrequency(file5, count1, 'a');
			System.out.println("test1Answer: " + test1);
			assertEquals(count1, test1.size());
			
			List<String> test2 = FrequencyAnalyzer.getFrequency(file5, count2, ';');
			ArrayList<String> answer = new ArrayList<String>();
			System.out.println("test2Answer: " + test2);
			assertEquals(test2, answer);
			assertEquals(0, test2.size());
			
			
			List<String> test3 = FrequencyAnalyzer.getFrequency(file5, count1, ';');
			answer = new ArrayList<String>();
			System.out.println("test3Answer: " + test3);
			
			List<String> test4 = FrequencyAnalyzer.getFrequency(file5, count3, ';');
			answer = new ArrayList<String>();
			System.out.println("test4Answer: " + test4);
			assertEquals(0, test4.size());
			
			
			System.out.println();
		}
}
