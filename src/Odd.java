public class Odd implements Checker<Integer>
{

	public boolean check(Integer number)
	{
		if(number % 2 != 0)		
			return true;
		
		else
			return false;
	}
}
