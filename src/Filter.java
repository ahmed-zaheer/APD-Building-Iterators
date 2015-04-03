import java.util.Iterator;
import java.util.NoSuchElementException;

public class Filter<E> implements Iterator<E>
{
	private E element;
	private boolean isNextItemExist;
	
	private Checker<E> checker;
	private Iterator<E> filterIterator;	
	
	public Filter(Iterator<E> it, Checker<E> chk)
	{
		filterIterator = it;
		checker = chk;
		isNextItemExist = false;
	}

	public boolean hasNext()
	{
		if (isNextItemExist)
			return true;
		else
			return moveNext();
	}
	
	public E next()
	{
		if (isNextItemExist || moveNext())
		{
			isNextItemExist = false;
			return element;
		}	
		throw new NoSuchElementException();
	}
	
	private boolean moveNext()
	{
		E ele = null;
		while(filterIterator.hasNext())
		{
			ele = filterIterator.next();			
			if(checker.check(ele))
			{
				element = ele;
				isNextItemExist = true;
				return true;
			}
		}
		return false;
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}