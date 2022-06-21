package persistenza;

import java.io.Reader;
import java.util.List;

public interface Persister<T> {
	public List<T> load(Reader reader); 
}
