package BasicJava;

public class ReverseSentence {

	public static void main(String[] args) {
		String str[]="My is Aishwarya".split(" ");
		String rev=" ";
		for(int i=str.length-1; i>=0; i--)
		{
			rev+=str[i]+" ";
		}
		System.out.println(rev);
	}

}
