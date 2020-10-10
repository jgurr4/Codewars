package codeWarsJava;

import java.util.stream.*;

public class Numbers20 {
	//Goal of this test is to print the numbers 1-20 on separate lines, and replace each number 
	//divisible by 3 with 'usb', and each number divisible by 5 with 'device', and replace each
	//number divisible by 5 and 3 with 'usbdevice'. 
	public static void result() {
		String newline = System.lineSeparator();
				
		String answer = "";
				for(int i = 1; i <= 20; i++) {
					if((i % 3 == 0) && (i % 5 != 0)) {
						answer += "usb" + newline; 
					} else if((i % 3 != 0) && (i % 5 == 0)) {
						answer += "device" + newline;
					} else if((i % 3 == 0) && (i % 5 == 0)) {
						answer += "usbdevice" + newline;
					} else {
						answer += i + newline;
					}
				}
				
		Stream<String> stream = Stream.of(answer);
        stream.forEach(System.out::println);
	}
}	
