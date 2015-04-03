public class LongerThan implements Checker<String>
{

	private int thresholdLength;

	public LongerThan(int strLength)
	{
		thresholdLength = strLength;
	}

	public boolean check(String str)
	{
		if (str == null)
			throw new NullPointerException();

		return str.length() > thresholdLength;
	}	
}