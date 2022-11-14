package reddit;

import java.util.Date;
import java.util.TimerTask;

public class TimerSchedule extends TimerTask {

    private String name;

    public TimerSchedule(String n) {
        this.name = n;
    }

    @Override
    public void run() {
        System.out.println("the Scheduler is running"+ new Date());
        if(Storage.commentQueue.size()!=0){
            try {
                StorageMethods.updateDBComments();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("No Data To Update");
        }
    }
}