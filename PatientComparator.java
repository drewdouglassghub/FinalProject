package finalProject;

import java.util.Comparator;


	/**
	 * @author Drew Douglass, amdouglass@dmacc.edu, 12/4/18
	 *	This is a patient comparator class that uses an iterator for to correctly place the patient
	 *in the queue
	 */
	class PatientComparator implements Comparator<Patient>{ 
        
        // Overriding compare()method of Comparator  
                    // for descending order of triageRating 
		@Override
        public int compare(Patient p1, Patient p2) { 
            if ( p1.triageRating < p2.triageRating) 
                return 1; 
            else if (p1.triageRating > p2.triageRating) 
                return -1; 
                            return 0; 
            } 
    }

