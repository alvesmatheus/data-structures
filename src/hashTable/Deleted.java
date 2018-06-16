package hashTable;

public class Deleted {

	public Deleted() {

	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			return (obj instanceof Deleted);
		}

		return false;
	}

	@Override
	public String toString() {
		return "D";
	}

}
