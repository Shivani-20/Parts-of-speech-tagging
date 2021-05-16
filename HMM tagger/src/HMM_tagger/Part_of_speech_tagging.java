package HMM_tagger;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Part_of_speech_tagging extends JFrame
{

private static String[] words;
private static int number_of_words;

private static String tag[];
private static int number_of_tags;

private static float B[][];
private static float A[][];
private static int result[];
private static HashMap<String,String> part_of_speech_tags = new HashMap<String,String>();

	public static void sentence_input()
	{
		// pop up at the beginning of the program to get the sentence
				String sentence = JOptionPane.showInputDialog("Enter the words and place commas in between");
						
						// if user clicks on ok without entering anything, exit
						// if user clicks on cancel without entering anything, exit
						// if user enters blank spaces and clicks on ok, exit
						// if user enters blank spaces and clicks on cancel, exit
						
						if((sentence==null)||(sentence.isBlank()))
						{
							System.exit(0);
						}
						
						words = sentence.split(",");
						number_of_words = words.length;	
						tag_input();
	}
	
	public static void tag_input()
	{
		
		// pop up at the beginning of the program to get the tags
				String tags = JOptionPane.showInputDialog("Enter the tags and place commas in between");
				
						// if user clicks on ok without entering anything, exit
						// if user clicks on cancel without entering anything, exit
						// if user enters blank spaces and clicks on ok, exit
						// if user enters blank spaces and clicks on cancel, exit
						
						if((tags==null)||(tags.isBlank()))
						{
							System.exit(0);
						}
						
						tag = tags.split(",");
						number_of_tags = tag.length;
						input_emission_probability();
	}
	
	public static void input_emission_probability()
	{
		JTextField field[][] = new JTextField[number_of_tags][number_of_words];
		JLabel Probability[][] = new JLabel[number_of_tags][number_of_words];
		
		JPanel Probability_panel = new JPanel();
		Probability_panel.setLayout(new BoxLayout(Probability_panel, BoxLayout.LINE_AXIS));
	
		
		for(int i=0;i<number_of_words;i++)
		{
			JPanel sub_panel = new JPanel();
			sub_panel.setPreferredSize(new Dimension(150,60*number_of_tags));
			sub_panel.setLayout((new BoxLayout(sub_panel, BoxLayout.PAGE_AXIS)));
			
			
			String w = words[i];
			for(int j=0;j<number_of_tags;j++)
			{	
				
		    String t = tag[j];	
		    Probability[j][i] = new JLabel("P["+w+"] | ["+t+"]");
		    
			sub_panel.add(Probability[j][i]);
			
			field[j][i] = new JTextField(5);
	
			sub_panel.add(field[j][i]);
			sub_panel.add(Box.createRigidArea(new Dimension(20,20)));
			}
			
			Probability_panel.add(sub_panel);
			Probability_panel.add(Box.createRigidArea(new Dimension(2,60*number_of_tags)));
		}
			
			int result = JOptionPane.showConfirmDialog(null, Probability_panel, "Please fill in the probabilities", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		    
			if (result == JOptionPane.CANCEL_OPTION) 
		      {
		    	System.exit(1);
              }
			
			B = new float[number_of_tags][number_of_words]; 
        
        try
        {
        for(int i=0;i<number_of_words;i++)
		{
			for(int j=0;j<number_of_tags;j++)
			{	
				B[j][i]=Float.parseFloat(field[j][i].getText());
			}
		}
        }
        
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,"one or more of your inputs were not valid");
        	System.exit(1);
        }
			
        input_transition_probability();
			
	}
	
	public static void input_transition_probability()
	{
		JTextField tag_field[][] = new JTextField[number_of_tags+1][number_of_tags];
		JLabel tag_Probability[][] = new JLabel[number_of_tags+1][number_of_tags];
		
		JPanel tag_transition_panel = new JPanel();
		tag_transition_panel.setLayout(new BoxLayout(tag_transition_panel, BoxLayout.LINE_AXIS));
		
		for(int i=0;i<number_of_tags;i++)
		{
			JPanel sub_panel = new JPanel();
			sub_panel.setPreferredSize(new Dimension(150,60*(number_of_tags+1)));
			sub_panel.setLayout((new BoxLayout(sub_panel, BoxLayout.PAGE_AXIS)));
			String w = tag[i];
			
			tag_Probability[0][i] = new JLabel("P["+w+"] | [<s>]");
		    
			sub_panel.add(tag_Probability[0][i]);
			
			tag_field[0][i] = new JTextField(5);
	
			sub_panel.add(tag_field[0][i]);
			sub_panel.add(Box.createRigidArea(new Dimension(20,20)));
			
			
			for(int j=1;j<=number_of_tags;j++)
			{	
				
		    String t = tag[j-1];	
		    tag_Probability[j][i] = new JLabel("P["+w+"] | ["+t+"]");
		    
			sub_panel.add(tag_Probability[j][i]);
			
			tag_field[j][i] = new JTextField(5);
	
			sub_panel.add(tag_field[j][i]);
			sub_panel.add(Box.createRigidArea(new Dimension(20,20)));
			}
			
			tag_transition_panel.add(sub_panel);
			tag_transition_panel.add(Box.createRigidArea(new Dimension(2,60*(number_of_tags+1))));
		}
		
		
		int result1 = JOptionPane.showConfirmDialog(null, tag_transition_panel, "Please fill in the probabilities", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    
		if (result1 == JOptionPane.CANCEL_OPTION) 
	      {
	    	System.exit(1);
          }
	      
		A = new float[number_of_tags+1][number_of_tags]; 

		
		try
		{
		for(int i=0;i<number_of_tags;i++)
		{
			A[0][i]=Float.parseFloat(tag_field[0][i].getText());
		}
		

		for(int i=0;i<number_of_tags;i++)
		{
			for(int j=1;j<=number_of_tags;j++)
			{
				A[j][i]=Float.parseFloat(tag_field[j][i].getText());
			}
		}
		
		}
		 catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,"one or more of your inputs were not valid");
        	System.exit(1);
        }
	}
	
	public static void final_output()
	{
		JFrame f = new JFrame();
		String column_heads[]={"WORDS","PART OF SPEECH"};   
		String data[][] = new String[words.length][2];
		for(int i=0;i<words.length;i++)
		{
			data[i][0]=words[i];
		    data[i][1]=part_of_speech_tags.get(tag[result[i]]);    		
		}
		JTable jt=new JTable(data,column_heads);   
		jt.setBounds(30,40,300,200);  
		JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);          
	    f.setSize(300,200);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);    
	}
	
	public static void main(String[] args)
	{
		part_of_speech_tags.put("DT", "Determiner");
		part_of_speech_tags.put("IN", "Preposition");
		part_of_speech_tags.put("JJ", "Adjective");
		part_of_speech_tags.put("MD", "Modal");
		
		part_of_speech_tags.put("NN", "Common Noun");
		part_of_speech_tags.put("JJR","Comparative Adjective");
		part_of_speech_tags.put("JJS","Superlative Adjective");
		part_of_speech_tags.put("SYM","Symbol");
		
		part_of_speech_tags.put("RB","Adverb");
		part_of_speech_tags.put("RBR","Comparative Adverb");
		part_of_speech_tags.put("RBS","Superlative Adverb");
		part_of_speech_tags.put("PRP", "Personal Noun");
		
		part_of_speech_tags.put("PRP$","Possessive Pronoun");
		part_of_speech_tags.put("NNP","Proper Noun");
		part_of_speech_tags.put("VB","Verb");
		part_of_speech_tags.put("UH","Interjection");
		
		sentence_input();
		Viterbi_solver solve = new Viterbi_solver(A,B,number_of_tags,number_of_words);
		solve.find_initial_Vectors();
		
	
		for(int i=1;i<number_of_words;i++)
		{
			solve.find_path_probabilities_and_next_Vectors(i);
		}

		result = solve.get_parts_of_speech();
		final_output();
	}

}
