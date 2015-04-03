import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MySet<E>
{	// OVERVIEW: Sets are unbounded mutable sets 

	private ArrayList<E> els; // the rep

	// constructors
	public MySet()
	{
		els = new ArrayList<E>();
	}

	//methods

	public void insert(E el)
	// MODIFIES: this
	// EFFECTS: Adds el to the elements of this
	{
		if(getIndex(el)<0) els.add(el);
	}

	public void remove(E el)
	// MODIFIES: this
	// EFFECTS: Removes el from this
	{
		int i = getIndex(el);
		if(i<0) return;
		els.set(i,els.get(els.size()-1));
		els.remove(els.size()-1);
	}

	public boolean isIn(E el)
	// EFFECTS: Returns true if el is in this else returns false
	{
		return getIndex(el)>=0;
	}

	private int getIndex(E el)
	// EFFECTS: If el is in this returns index where el appears 
	//          else returns -1
	{
		for(int i=0; i<els.size(); i++)
			if(el.equals(els.get(i))) return i;
		return -1;
	}

	public int size()
	// EFFECTS: Returns the cardinality of this
	{
		return els.size();
	}

	public String toString()
	// EFFECTS: Return string representation of this
	{
		if(els.size()==0)
			return "{}";
		else
		{
			String str="{"+els.get(0);
			for(int i=1; i<els.size(); i++)
				str+=","+els.get(i);
			return str+"}";
		}
	}
	
	public Iterator<E> iterator()
	{
		return new MySetGen(this);
	}
	
	
	// inner class
	private class MySetGen implements Iterator<E>
	{
		private MySet<E> ms;	// the MySet being iterated
		private int n;			// the next set to consider

		MySetGen(MySet<E> it)
		{	//REQUIRES: it != null

			ms = it;
			n = 0;	
		}

		public boolean hasNext()
		{
			return n < ms.els.size();
		}

		public E next() throws NoSuchElementException
		{
			if (n < ms.els.size())
			{	
				E element = ms.els.get(n);
				n++;
				return element;
			}
			throw new NoSuchElementException();
		}

		public void remove() 
		{
			throw new UnsupportedOperationException();
		}
	}
	//end MySetGen
	
}
