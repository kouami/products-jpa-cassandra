/**
 * 
 */
package com.example.demo.event;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.demo.domain.StudentEventMessage;
import com.example.demo.repository.StudentEventMessageRepository;

/**
 * @author efoeakolly
 *
 */
@Component
public class StudentEventListener {
	
	@Autowired
	private StudentEventMessageRepository repo;
	
	@Async
	@EventListener
    public void handleStudentEvent(StudentEvent event) {
        //do some operations
		StudentEventMessage msg = new StudentEventMessage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		msg.setTime(dateFormat.getCalendar());
		msg.setMessage("Student :: " + event.getStudent().getFirstName() + "\t" + event.getStudent().getLastName() + "\t" + "has been modified");
		repo.save(msg);
    }
}
