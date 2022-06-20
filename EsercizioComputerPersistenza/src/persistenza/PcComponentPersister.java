package persistenza;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import model.PcComponent;

public interface PcComponentPersister {
	List<PcComponent> load(Reader reader)throws IOException, BadFileFormatException;
	
	void save(List<PcComponent> data, Writer writer)throws IOException;
}
