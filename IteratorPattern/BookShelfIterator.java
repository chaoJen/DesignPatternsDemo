public class BookShelfIterator implements Iterator {

	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		
		this.bookShelf = bookShelf;
	}

	public boolean hasNext() {
		
		return index < bookShelf.getLength();
	}

	public Object next() {

		Book book = bookShelf.getBookAt(index);
		++index;
		return book;
	}
}