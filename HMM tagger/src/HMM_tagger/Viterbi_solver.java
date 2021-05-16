package HMM_tagger;

class Viterbi_solver 
{
 private float A[][];
 private float B[][];
 private int number_of_tags;
 private int V[];
 private float tag_p[];
 static int index=0;
 static float max = 0;
 
 
public Viterbi_solver(float[][] a, float[][] b, int number_of_tags, int number_of_words) 
{
	A = a;
	B = b;
	this.number_of_tags = number_of_tags;
	V = new int[number_of_words];
	tag_p = new float[number_of_tags];
}

public void find_initial_Vectors()
{
		for(int j=0;j<number_of_tags;j++)
		{	
			B[j][0]=B[j][0]*A[0][j];
		}
		
		for(int j=0;j<number_of_tags;j++)
		{	
			if(B[j][0]>max)
			{
				max=B[j][0];  // first word
				index=j;
			}
		}
		V[0] = index;
}


public void find_path_probabilities_and_next_Vectors(int k)
{
	for(int j=0;j<number_of_tags;j++)
	{
		tag_p[j] = max * A[index][j];
	}
	
	for(int j=0;j<number_of_tags;j++)
	{	
		if(B[j][k]>0)
		{
			B[j][k]=B[j][k]*tag_p[j];
		}
	}
	
	max=0;
	
	for(int j=0;j<number_of_tags;j++)
	{	
		if(B[j][k]>max)
		{
			max=B[j][k];  // first word
			index=j;
		}
	}
	
	V[k] = index;
	
}

public int[] get_parts_of_speech() 
{
	return V;
}


}



