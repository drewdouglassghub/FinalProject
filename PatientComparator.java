package finalProject;

import java.util.Comparator;


	class PatientComparator implements Comparator<Patient>{ 
        
        // Overriding compare()method of Comparator  
                    // for descending order of cgpa 
		@Override
        public int compare(Patient p1, Patient p2) { 
            if ( p1.triageRating < p2.triageRating) 
                return 1; 
            else if (p1.triageRating > p2.triageRating) 
                return -1; 
                            return 0; 
            } 
    }

