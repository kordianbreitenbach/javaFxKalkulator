package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
public class SampleController {
	  @FXML
	    private Button jeden;
	    @FXML
	    private Button dwa;
	    @FXML
	    private Button trzy;
	    @FXML
	    private Button cztery;
	    @FXML
	    private Button pienc;
	    @FXML
	    private Button szesc;
	    @FXML
	    private Button siedem;
	    @FXML
	    private Button osiem;
	    @FXML
	    private Button dziewienc;
	    @FXML
	    private Button reset;
	    @FXML
	    private Button zero;
	    @FXML
	    private Text wynik;
	 
	    @FXML
	    private Button rownasie;
	    @FXML
	    private Button dodaj;
	    @FXML
	    private Button podziel;
	    @FXML
	    private Button mnoz;
	    @FXML
	    private Button odejmij;
	    @FXML
	    private Button przecinek;
	    private String currentValue = "0";
	    private String currentValuehidden = "0";
	    private String operationType = "";
	    boolean boolTest = false;
	    boolean przecinekTest = false;
	    public void initialize() {
	    	   wynik.setText(currentValue);
	    	   zero.setOnAction(event -> handleButtonClick("0"));
	    	   jeden.setOnAction(event -> handleButtonClick("1"));
	           dwa.setOnAction(event -> handleButtonClick("2"));
	           trzy.setOnAction(event -> handleButtonClick("3"));
	           cztery.setOnAction(event -> handleButtonClick("4"));
	           pienc.setOnAction(event -> handleButtonClick("5"));
	           szesc.setOnAction(event -> handleButtonClick("6"));
	           siedem.setOnAction(event -> handleButtonClick("7"));
	           osiem.setOnAction(event -> handleButtonClick("8"));
	           dziewienc.setOnAction(event -> handleButtonClick("9"));
	           przecinek.setOnAction(event -> handleButtonClick("."));
	           dodaj.setOnAction(event -> handleAdding());
	           rownasie.setOnAction(event -> handleequal());
	           odejmij.setOnAction(event -> handleodejmij());
	           podziel.setOnAction(event -> handlepodziel());
	           mnoz.setOnAction(event -> handlemnoz());
	           reset.setOnAction(e -> {
	               currentValue = "0";
	               currentValuehidden = "0";
	                operationType = "";
	               przecinekTest = false;
	               boolTest = false;
	               wynik.setText(currentValue);
	           });
	    	
	    }
	    private void handleButtonClick(String value) {
	     if(przecinekTest==true&&value!="."||przecinekTest==false) {
	    	 if(value==".") {
	    		 przecinekTest=true;
	    	 }
	    	if (currentValue.equals("0")&&value!=".") {
	            currentValue = value;
	        } else {
	            currentValue = currentValue + value;
	   
	        }
	     }
	        wynik.setText(currentValue);
	    }
	    private void handleAdding() {
	    	if(boolTest==false) {
	    	currentValuehidden=currentValue;
	    	currentValue="0";
	    	operationType="+";
	    	
	    	}
	        if(boolTest==true) {
	        	handleequal();
	        	   currentValuehidden=currentValue;
	   	    	currentValue="0";
	   	    	operationType="+";
	        	 
	        }
	        przecinekTest=false;   
	      boolTest=!boolTest;
	    }
	    private void handleodejmij() {
	    	if(boolTest==false) {
		    	currentValuehidden=currentValue;
		    	currentValue="0";
		    	operationType="-";
		    	}
		        if(boolTest==true) {
		        	handleequal();
		        	   currentValuehidden=currentValue;
			   	    	currentValue="0";
			   	    	operationType="-";
			        	  
		        }
		        przecinekTest=false; 
		      boolTest=!boolTest;
	    }
	    private void handlepodziel() {
	    	if(boolTest==false) {
		    	currentValuehidden=currentValue;
		    	currentValue="0";
		    	operationType="/";
		    	}
		        if(boolTest==true) {
		        	handleequal();
		        	   currentValuehidden=currentValue;
			   	    	currentValue="0";
			   	    	operationType="/";
			        	 
		        }
		        przecinekTest=false;
		      boolTest=!boolTest;
	    	
	    }
	    private void handlemnoz() {
	    	if(boolTest==false) {
		    	currentValuehidden=currentValue;
		    	currentValue="0";
		    	operationType="*";
		    	}
		        if(boolTest==true) {
		        	handleequal();
		        	   currentValuehidden=currentValue;
			   	    	currentValue="0";
			   	    	operationType="*";
			        
		        }
		        przecinekTest=false;
		      boolTest=!boolTest;
	    	
	    }
	    private void handleequal() {
	    	if(boolTest==true) {
	    		if(operationType=="+") {
	    			 double doubleValue = Double.parseDouble(currentValuehidden);
		        	  double doubleValueSecond= Double.parseDouble(currentValue);
		        	  doubleValue = doubleValue*1000;
		        	  doubleValueSecond=doubleValueSecond*1000;
		        	   double sum = (doubleValue + doubleValueSecond)/1000;
		        	   
		        	 
		        	   String numberAsString = Double.toString(sum);
		        	   if (numberAsString.matches(".*\\.0+")) {
		        		   int intValue = (int) sum;
		        		   String stringValue=  String.valueOf(intValue);
		        		   currentValue=stringValue;
		        		   wynik.setText(currentValue);
		        	   }
		        	   else {
		        		   currentValue  = numberAsString;
		        		   wynik.setText(currentValue);
		        	   }
	    			
	    		}
	    		else if(operationType=="-") {
	    			double doubleValue = Double.parseDouble(currentValuehidden);
		        	  double doubleValueSecond= Double.parseDouble(currentValue);
		        	  doubleValue = doubleValue*1000;
		        	  doubleValueSecond=doubleValueSecond*1000;
		        	   double sum = (doubleValue - doubleValueSecond)/1000;
		        	   
		        	 
		        	   
		        	   String numberAsString = Double.toString(sum);
		        	   if (numberAsString.matches(".*\\.0+")) {
		        		   int intValue = (int) sum;
		        		   String stringValue=  String.valueOf(intValue);
		        		   currentValue=stringValue;
		        		   wynik.setText(currentValue);
		        	   }
		        	   else {
		        		   currentValue  = numberAsString;
		        		   wynik.setText(currentValue);
		        	   }
	    			
	    		}
	    		else if(operationType=="*") {
	    			 double doubleValue = Double.parseDouble(currentValuehidden);
		        	  double doubleValueSecond= Double.parseDouble(currentValue);
		        	  
		        	  doubleValue = doubleValue*1000;
		        	  doubleValueSecond=doubleValueSecond*1000;
		        	   double sum = (doubleValue * doubleValueSecond)/1000000;
		        	
		        	   
		        	   String numberAsString = Double.toString(sum);
		        	   if (numberAsString.matches(".*\\.0+")) {
		        		   int intValue = (int) sum;
		        		   String stringValue=  String.valueOf(intValue);
		        		   currentValue=stringValue;
		        		   wynik.setText(currentValue);
		        	   }
		        	   else {
		        		   currentValue  = numberAsString;
		        		   wynik.setText(currentValue);
		        	   }
	    		}
	    		else if(operationType=="/") {
	    		   
			        	  double doubleValue = Double.parseDouble(currentValuehidden);
			        	  double doubleValueSecond= Double.parseDouble(currentValue);
			        	  doubleValue = doubleValue*1000;
			        	  doubleValueSecond=doubleValueSecond*1000;
			        	
			        	   double sum = doubleValue / doubleValueSecond;
			        	   
			        	   String numberAsString = Double.toString(sum);
			        	   if (numberAsString.matches(".*\\.0+")) {
			        		   int intValue = (int) sum;
			        		   String stringValue=  String.valueOf(intValue);
			        		   currentValue=stringValue;
			        		   wynik.setText(currentValue);
			        	   }
			        	   else {
			        		   currentValue  = numberAsString;
			        		   wynik.setText(currentValue);
			        	   }
			        
	    		}
	    		 przecinekTest=false;
	    		  boolTest=!boolTest;
	    	}
	    }
	    
}
