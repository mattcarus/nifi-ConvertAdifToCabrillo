package uk.co.mattcarus.nifi.processors;

import no.la1k.adif.*;

import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.components.PropertyValue;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.processor.*;
import org.apache.nifi.processor.io.*;
import org.apache.nifi.annotation.behavior.ReadsAttribute;
import org.apache.nifi.annotation.behavior.ReadsAttributes;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.util.StandardValidators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.*;

@Tags({"ADIF", "Cabrillo", "Amateur Radio", "Ham Radio"})
@CapabilityDescription("Convert an ADIF-format log to CABRILLO-format.")
@SeeAlso({})
@ReadsAttributes({@ReadsAttribute(attribute="", description="")})
@WritesAttributes({@WritesAttribute(attribute="", description="")})

public class ConvertAdifToCabrilloProcessor extends AbstractProcessor {

	private List<PropertyDescriptor> properties;
	private Set<Relationship> relationships;

	public static final String MATCH_ATTR = "match";

/*	public static final PropertyDescriptor JSON_PATH = new PropertyDescriptor.Builder()
	        .name("Json Path")
	        .required(true)
	        .addValidator(StandardValidators.NON_EMPTY_VALIDATOR)
	        .build();
*/
	public static final Relationship SUCCESS = new Relationship.Builder()
	        .name("SUCCESS")
	        .description("Success relationship")
	        .build();
	
	@Override
	public void init(final ProcessorInitializationContext context){
	    List<PropertyDescriptor> properties = new ArrayList<>();
//	    properties.add(JSON_PATH);
	    this.properties = Collections.unmodifiableList(properties);

	    Set<Relationship> relationships = new HashSet<>();
	    relationships.add(SUCCESS);
	    this.relationships = Collections.unmodifiableSet(relationships);
	}

	@Override
	public Set<Relationship> getRelationships(){
	    return relationships;
	}

	@Override
	public List<PropertyDescriptor> getSupportedPropertyDescriptors(){
	    return properties;
	}
	
    @Override
    public void onTrigger(final ProcessContext context, final ProcessSession session) throws ProcessException {
		FlowFile flowFile = session.get();
		if ( flowFile == null ) {
			return;
		}

        // TODO implement
		
		
	    session.read(flowFile, new InputStreamCallback() {
	        @Override
	        public void process(InputStream in) throws IOException {
	            try{
	            	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
	            	ADIFReader adifReader = new ADIFReader(bufferedReader);
	            	
	            }catch(Exception ex){
	                ex.printStackTrace();
	                //log.error("Failed to read ADIF string.");
	            }
	        }
	    });
    }
}