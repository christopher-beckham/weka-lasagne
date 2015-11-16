package weka.lasagne.layers;

import java.util.Enumeration;
import java.util.Vector;

import weka.core.Option;
import weka.core.Utils;
import weka.lasagne.nonlinearities.NonLinearity;
import weka.lasagne.nonlinearities.Sigmoid;

/**
 * A fully-connected layer.
 * @author cjb60
 */
public class DenseLayer extends Layer {
	
	private static final long serialVersionUID = -4158355845708293518L;
	
	public static final NonLinearity DEFAULT_NONLINEARITY = new Sigmoid();
	public static final int DEFAULT_NUM_UNITS = 1;
	
	private int m_numUnits = DEFAULT_NUM_UNITS;
	
	public int getNumUnits() {
		return m_numUnits;
	}
	
	public void setNumUnits(int numUnits) {
		m_numUnits = numUnits;
	}
	
	@Override
	public String getOutputString() {
		return String.format("DenseLayer(l_prev, num_units=%d)", getNumUnits());
	}
	
	private NonLinearity m_nonLinearity = DEFAULT_NONLINEARITY;
	
	public NonLinearity getNonLinearity() {
		return m_nonLinearity;
	}
	
	public void setNonLinearity(NonLinearity nonLinearity) {
		m_nonLinearity = nonLinearity;
	}

	@Override
	public Enumeration<Option> listOptions() {
		return null;
	}

	@Override
	public void setOptions(String[] options) throws Exception {
		super.setOptions(options);
		String tmp = Utils.getOption('u', options);
		setNumUnits( Integer.parseInt(tmp) );	
	}

	@Override
	public String[] getOptions() {
		Vector<String> result = new Vector<String>();
		String[] superOptions = super.getOptions();
		for(int x = 0; x < superOptions.length; x++) {
			result.add(superOptions[x]);
		}
		result.add("-u");
		result.add( "" + getNumUnits() );
	    return result.toArray(new String[result.size()]);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DenseLayer\\n");
		sb.append( String.format("  num_units = %d\\n", getNumUnits()) );
		sb.append( String.format("  nonlinearity = %s\\n", getNonLinearity().toString()) );
		return sb.toString();
	}

}
