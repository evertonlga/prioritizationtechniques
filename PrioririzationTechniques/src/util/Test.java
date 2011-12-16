package util;

import main.Facade;

class Test extends Thread {
		Facade f = new Facade();
        
		public void run() {
			String [] args =  {"src/byClass", "src/byClass/output", "byClass.output", "Random", "DOM4JNavigatorTest"};
        	Facade.main(args);
        }

}